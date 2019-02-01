package com.vibe.parlamentar

class Contato {

    String fone
    String email

    static constraints = {
        fone nullable: true
        email nullable: true
    }
}
