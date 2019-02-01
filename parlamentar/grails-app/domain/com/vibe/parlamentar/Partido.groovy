package com.vibe.parlamentar

class Partido {

    String sigla
    String nome

    static constraints = {
        sigla nullable: true
        nome nullable: true
    }
}
