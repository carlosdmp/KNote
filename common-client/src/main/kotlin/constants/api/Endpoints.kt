package constants.api



object ClientEndpoints {

    const val clientNotes = Api.api + Endpoints.noteEndpoint
    /**
     *  GET: returns a list of all notes
     *      Success:    200 OK
     *      Error:      400 Bad request
     *                  500 Internal error
     */
    const val getAllNotes = ""

    /**
     *  POST: create a new note, returns note id
     *      Success:    201 Created
     *      Error:      400 Bad request
     *                  409 Conflict
     *                  500 Internal error
     *
     */
    const val createNote = ""

    /**
     *  GET: returns a note
     *      Success:    200 OK
     *      Error:      400 Bad request
     *                  404 Not found
     *                  500 Internal error
     */
    fun getNote(id:String) : String = "/$id"
    const val getNoteTemplate = "/{id}"

    /**
     *  PUT: updates a note
     *      Success:    204 No content
     *      Error:      400 Bad request
     *                  404 Not found
     *                  500 Internal error
     */
    fun updateNote(id:String) : String = "/$id"
    const val updateNoteTemplate = "/{id}"

    /**
     *  DELETE: removes a note
     *      Success:    204 No content
     *      Error:      400 Bad request
     *                  404 Not found
     *                  500 Internal error
     */
    fun deleteNote(id:String) : String = "/$id"
    const val deleteNoteTemplate = "/{id}"
}