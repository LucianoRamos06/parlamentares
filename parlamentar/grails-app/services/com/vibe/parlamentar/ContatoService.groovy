package com.vibe.parlamentar

import grails.gorm.transactions.Transactional

@Transactional
class ContatoService {

    /**
     * Método que salva um contado de um parlamentar
     * @param fone
     * @param email
     * @return
     */
    def salvar(String fone, String email) {
        return new Contato(fone: fone, email: email).save(flush: true)
    }
}
