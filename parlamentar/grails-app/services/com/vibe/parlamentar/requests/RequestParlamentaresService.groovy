package com.vibe.parlamentar.requests

import grails.gorm.transactions.Transactional
import groovyx.net.http.ContentType
import groovyx.net.http.Method

@Transactional
class RequestParlamentaresService {

    def httpService

    /**
     * Método que faz uma requisição e retorna uma lista de parlamentares
     * @return
     */
    def sendRestParlamentares(Map pesquisa) {
        return httpService.connect([
                url: obterUrl(pesquisa),
                header: obterHeader(),
                type: ContentType.JSON,
                method: Method.GET
        ])
    }

    /**
     * Cabeçalho da requisição
     * @return
     */
    def obterHeader(){
        return ["Content-Type": "application/json"
        ]
    }

    /**
     * Url da requisição
     * @return
     */
    def obterUrl(Map pesquisa){
        String query = ""
        if (pesquisa?.'NOME') query = "${query}${query.equals("") ? "nome=${tratarStringParaWeb(pesquisa?.'NOME' as String)}" : "&nome=${tratarStringParaWeb(pesquisa?.'NOME' as String)}"}"
        if (pesquisa?.'UF') query = "${query}${query.equals("") ? "siglaUf=${tratarStringParaWeb(pesquisa?.'UF' as String)}" : "&siglaUf=${tratarStringParaWeb(pesquisa?.'UF' as String)}"}"
        if (pesquisa?.'PARTIDO') query = "${query}${query.equals("") ? "siglaPartido=${tratarStringParaWeb(pesquisa?.'PARTIDO' as String)}" : "&siglaPartido=${tratarStringParaWeb(pesquisa?.'PARTIDO' as String)}"}"

        return "https://dadosabertos.camara.leg.br/api/v2/deputados?${query}"
    }

    def tratarStringParaWeb(String palavra){
        return palavra.replace(" ", "+").toUpperCase()
    }
}
