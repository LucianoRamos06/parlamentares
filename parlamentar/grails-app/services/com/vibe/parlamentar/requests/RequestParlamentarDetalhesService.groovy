package com.vibe.parlamentar.requests

import grails.gorm.transactions.Transactional

@Transactional
class RequestParlamentarDetalhesService {

    def httpService

    /**
     * Método que faz uma requisição e retorna uma lista de parlamentares
     * @return
     */
    def sendSoapParlamentarDetalhes(String idCadastro, String idLegislatura) {
        return httpService.connectSoap([
                url: obterUrl(idCadastro, idLegislatura),
                header: obterHeader(),
                method: "GET"])
    }

    /**
     * Cabeçalho da requisição
     * @return
     */
    def obterHeader(){
        return ["Content-Type": "text/xml; charset=utf-8"]
    }


    /**
     * Url da requisição
     * @return
     */
    def obterUrl(String idCadastro, String idLegislatura){
        return "http://www.camara.leg.br/SitCamaraWS/Deputados.asmx/ObterDetalhesDeputado?ideCadastro=${idCadastro}&numLegislatura=${idLegislatura}"
    }
}
