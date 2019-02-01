package com.vide.parlamentar

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'parlamentar', action: 'listar')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
