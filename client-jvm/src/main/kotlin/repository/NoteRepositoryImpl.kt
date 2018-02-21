package repository

import arrow.core.Either
import arrow.core.flatMap
import arrow.data.Try
import arrow.syntax.either.left
import arrow.syntax.function.andThen
import common.ApiResponse
import constants.api.Endpoints
import data.Note
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import presentation.DomainError
import presentation.Resource
import presentation.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import ru.gildor.coroutines.retrofit.await
import kotlin.coroutines.experimental.EmptyCoroutineContext.fold

class NoteRepositoryImpl : NoteRepository() {
    interface Api {
        @GET(Endpoints.noteEndpoint)
        fun getNotes(): Call<List<Note>>
    }

    private val api = retrofit.create(Api::class.java)

    override suspend fun requestNotes(uiTask: ((Resource<List<Note>>) -> Unit)) = api.getNotes()
            .enqueue(object : Callback<List<Note>> {
                override fun onFailure(call: Call<List<Note>>?, t: Throwable?) {
                    uiTask.invoke(Resource.failure(Source.API, DomainError(t?.message
                            ?: "Unknown api error")))
                }

                override fun onResponse(call: Call<List<Note>>?, response: Response<List<Note>>?) {
                    if (response != null && response.isSuccessful) {
                        uiTask.invoke(Resource.success(Source.API, response.body()))
                    } else {
                        uiTask.invoke(Resource.failure(Source.API, DomainError(response?.message()
                                ?: "Unknown api error")))
                    }
                }

            })
}


