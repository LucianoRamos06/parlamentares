package com.vibe.parlamentar

import grails.gorm.transactions.Transactional
import sun.security.validator.ValidatorException

import java.text.SimpleDateFormat

@Transactional
class ParlamentarService {

    def contatoService
    def partidoService

    def requestParlamentaresService
    def requestParlamentarDetalhesService

    /**
     * Método que retorna uma lista de parlamentares, esse método faz:
     * - Busca os palamentares através de um web service
     * - Filtra atraves dos parametros que o usuário passo na visão
     * - Retorna uma lista de Objetos Parlamentar
     * @param consulta
     * @return
     */
    List<Parlamentar> obterParlamentares(Map pesquisa){
        def response = requestParlamentaresService.sendRestParlamentares(pesquisa)

        if((response.status as Integer) != 200) throw new ValidatorException("Não foi possível obter os parlamentares!")

        def parlamentares = response?.body?.dados

        return converterJsonResultToList(parlamentares)
    }

    Parlamentar obterDetalhes(String idCadastro, String idLegislatura){

        Parlamentar parlamentar = Parlamentar.findByIdCadastro(idCadastro)

        if(parlamentar) return parlamentar

        def response = requestParlamentarDetalhesService.sendSoapParlamentarDetalhes(idCadastro, idLegislatura)

        if((response.status as Integer) != 200) throw new ValidatorException("Não foi possível obter os parlamentares!")

        def responseBody = new XmlSlurper().parseText(response?.body as String)
        def parlamentarXml = responseBody?.Deputado

        parlamentar = converterXmlToParlamentar(parlamentarXml)

        return parlamentar
    }

    /**
     * Método Que converte o resultado já filtrado do xml e retorna uma lista de Objetos Parlamentar
     * @param xmlResult
     * @return
     */
    List<Parlamentar> converterJsonResultToList(def jsonResult){
        List<Parlamentar> parlamentarList = new ArrayList<>()
        jsonResult.each { jsonIntance ->
            parlamentarList.add(converterJsonToParlamentar(jsonIntance))
        }

        return parlamentarList
    }


    /**
     * Método statico que recebe uma instância de um objeto json e retorna um Obnjeto Parlamentar
     * @param jsonInstance
     * @return
     */
    def converterJsonToParlamentar(def jsonInstance){

        Contato contato = new Contato(fone: jsonInstance?.fone, email: jsonInstance?.email)
        Partido partido = new Partido(sigla: jsonInstance?.siglaPartido)

        return new Parlamentar(
                idCadastro: jsonInstance?.id,
                idLegislatura: jsonInstance.idLegislatura,
                nome: jsonInstance?.nome,
                idade: jsonInstance?.idade,
                urlFoto: jsonInstance?.urlFoto,
                contato: contato,
                sexo: jsonInstance?.sexo,
                uf: jsonInstance?.siglaUf,
                partido: partido,
                situacaoNaLegislaturaAtual: jsonInstance?.situacaoNaLegislaturaAtual
        )
    }

    /**
     * Método statico que recebe uma instância de um objeto xml e retorna um Objeto Parlamentar
     * @param xmlInstance
     * @return
     */
    def converterXmlToParlamentar(def xmlInstance){
        Contato contato = contatoService.salvar(xmlInstance?.gabinete?.telefone as String, xmlInstance?.email as String)
        Partido partido = partidoService.salvar(xmlInstance?.partidoAtual?.sigla as String, xmlInstance?.partidoAtual?.nome as String)

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        def map = [idCadastro: xmlInstance?.ideCadastro as String,
                   idLegislatura: xmlInstance.numLegislatura as String,
                   dataNascimento: formato.parse(xmlInstance.dataNascimento as String),
                   nome: xmlInstance?.nomeCivil as String,
                   urlFoto: xmlInstance?.urlFoto as String,
                   contato: contato,
                   sexo: xmlInstance?.sexo as String,
                   uf: xmlInstance?.ufRepresentacaoAtual as String,
                   partido: partido,
                   situacaoNaLegislaturaAtual: xmlInstance?.situacaoNaLegislaturaAtual as String]

        return salvar(map)
    }

    /**
     * Método que salva uma instancia de parlamentar
     * @param map
     * @return
     */
    def salvar(def map){
        return new Parlamentar(
                idCadastro: map?.idCadastro,
                idLegislatura: map?.idLegislatura,
                nome: map?.nome,
                dataNascimento: map?.dataNascimento,
                urlFoto: map?.urlFoto,
                contato: map?.contato,
                sexo: map?.sexo,
                uf: map?.uf,
                partido: map?.partido,
                situacaoNaLegislaturaAtual: map?.situacaoNaLegislaturaAtual
        ).save(flush: true)
    }
}
