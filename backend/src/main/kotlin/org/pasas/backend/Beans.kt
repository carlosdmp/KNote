package org.pasas.backend

import com.mongodb.ConnectionString
import org.pasas.backend.config.Routes
import org.pasas.backend.handlers.NoteHandler
import org.pasas.backend.repositories.NoteRepository
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.context.support.beans
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.repository.support.ReactiveMongoRepositoryFactory
import org.springframework.web.reactive.function.server.HandlerStrategies
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.server.WebHandler

fun beans() = beans {
    bean {
        NoteHandler(ref())
    }

    bean {
        Routes(ref())
    }

    bean<WebHandler>("webHandler"){
        RouterFunctions.toWebHandler(
                ref<Routes>().router(),
                HandlerStrategies.withDefaults()
        )
    }

    bean("messageSource"){
        ReloadableResourceBundleMessageSource().apply {
            setBasename("messages")
            setDefaultEncoding("UTF-8")
        }
    }

    bean{
        NoteRepository(ref())
    }

    bean{
        ReactiveMongoRepositoryFactory(ref())
    }

    bean{
        ReactiveMongoTemplate(
                SimpleReactiveMongoDatabaseFactory(
                        ConnectionString(
                                "mongodb://admin:admin@ds237848.mlab.com:37848/knote"
                        )
                )
        )
    }

    profile("dev"){

    }
}