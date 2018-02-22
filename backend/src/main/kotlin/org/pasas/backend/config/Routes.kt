package org.pasas.backend.config

import constants.api.Api
import constants.api.Endpoints
import org.pasas.backend.handlers.NoteHandler
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

class Routes(val noteHandler: NoteHandler) {
    fun router() = router {
        Api.api.nest {
            Endpoints.noteEndpoint.nest {
                accept(MediaType.APPLICATION_JSON).nest {
                    GET(Endpoints.getAllNotes, noteHandler::all)
                    GET("${Endpoints.getNoteTemplate}", noteHandler::get)
                }
                POST(Endpoints.createNote, noteHandler::create)
                PUT("${Endpoints.updateNoteTemplate}", noteHandler::update)
                DELETE("${Endpoints.deleteNoteTemplate}", noteHandler::delete)
            }
        }
    }
}