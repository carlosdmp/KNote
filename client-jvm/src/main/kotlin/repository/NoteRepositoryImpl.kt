package repository

import common.HttpError
import constants.api.Endpoints
import data.Note
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.http.GET
import ru.gildor.coroutines.retrofit.await

class NoteRepositoryImpl : NoteRepository {
    interface Api {
        @GET(Endpoints.noteEndpoint)
        fun getNotes(): Call<List<Note>>
    }
    private val api = retrofit.create(Api::class.java)

    suspend override fun getNotes(): List<Note> = try {
        api.getNotes().await()
    }catch (t : HttpException){
        throw HttpError(t.code(),t.message())
    }

}