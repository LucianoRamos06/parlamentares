package com.vibe.parlamentar

import grails.gorm.transactions.Transactional

@Transactional
class PartidoService {

    /**
     * Métódo que salva uma entidade de Partido,
     * caso já exista no banco ele retorna a instância criada anteriormente
     * @param sigla
     * @param nome
     * @return
     */
    Partido salvar(String sigla, String nome) {

        Partido partido = Partido.findBySigla(sigla.toUpperCase())

        if (partido) return partido

        return new Partido(sigla: sigla, nome: nome).save(flush: true)
    }
}
