package com.vibe.parlamentar.requests

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import org.apache.commons.validator.ValidatorException
import sun.net.www.protocol.http.HttpURLConnection

class HttpService {

    static transactional = false

    def connectSoap(Map<String, Object> map) {

        def url = map.url.toString().toURL()
        def connection = url.openConnection() as HttpURLConnection

        connection.setRequestMethod(map.method as String)

        map.header.each{ chave, valor ->
            connection.addRequestProperty(chave as String, valor as String)
        }

        if(map?.body){
            connection.doOutput = true
            connection.outputStream.write(map.body.toString().bytes)
            connection.outputStream.flush()
            connection.outputStream.close()
        }else{
            connection.doOutput = false
        }

        return [status: connection.getResponseCode(), body: connection.inputStream.text]
    }

    def   connect(def request) {

        try {

            def http = new HTTPBuilder(request?.url)

            println "Req ${request?.url} . H: ${request?.header} B: ${request?.body}"

            http.request(request?.method as Method, request?.type as ContentType) { req ->
                headers = request?.header
                body = request?.body

                response.success = { resp, reader ->
                    println "Sucesso na requisição: [URL : ${request?.url}, Status: ${resp.status}"
                    return [status: resp.status, body: reader]
                }

                response.failure = { resp, reader ->
                    log.error "Falha. Status: ${resp?.status}"
                    return [status: resp.status, body: reader]
                }

            }
        }catch (e){
            log.error e?.getMessage()
            throw new ValidatorException("Um erro ocorreu. Comunique os administradores.")
        }
    }
}
