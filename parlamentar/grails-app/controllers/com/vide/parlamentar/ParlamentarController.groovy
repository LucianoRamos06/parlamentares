package com.vide.parlamentar

import com.vibe.parlamentar.Parlamentar

class ParlamentarController {

    def parlamentarService

    /**
     * Método que lista todos os parlamentares,
     * podendo piltrar por nome, uf e sigla
     */
    def listar() {
        try {
            def pesquisa = [:]

            if (params?.pesquisa?.nome) pesquisa.'NOME' = params.pesquisa.nome
            if(params?.pesquisa?.partido) pesquisa.'PARTIDO' = params.pesquisa.partido
            if(params?.pesquisa?.uf) pesquisa.'UF' = params.pesquisa.uf

            List<Parlamentar> parlamentares = parlamentarService.obterParlamentares(pesquisa)
            return [parlamentares: parlamentares, pesquisa: params?.pesquisa]

        }catch (Exception e){
            log.error e.getMessage()
        }
    }

    /**
     * Método que detalha um parlamentar
     */
    def detalhes(){
        try {
            Parlamentar parlamentar = parlamentarService.obterDetalhes(params?.idCadastro as String, params.idLegislatura as String)
            render template: 'modalParlamentar', model: [parlamentar: parlamentar]
        }catch (Exception e){
            log.error e.getMessage()
        }
    }
}
