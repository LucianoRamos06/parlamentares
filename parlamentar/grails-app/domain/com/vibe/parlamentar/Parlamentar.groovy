package com.vibe.parlamentar

class Parlamentar {

    String idCadastro
    String idLegislatura
    String nome
    String sexo
    Date dataNascimento
    Integer idade

    String urlFoto
    String uf

    Contato contato
    Partido partido

    String situacaoNaLegislaturaAtual

    static constraints = {
        idCadastro nullable: true
        dataNascimento nullable: true
        idLegislatura  nullable: true
        nome nullable: true
        idade nullable: true
        urlFoto nullable: true
        uf nullable: true
        contato nullable: true
        sexo nullable: true
        partido nullable: true
        situacaoNaLegislaturaAtual nullable: true
    }
}
