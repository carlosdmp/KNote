package constants.api



object Endpoints{
    const val noteEndpoint = "notes"

    /**
     *  GET: return a list of all notes
     *      Success:    200 OK
     *      Error:      400 Bad request
     *                  500 Internal error
     */
    const val getAllNotes = "get"

    /**
     *  POST: create a new note, returns note id
     *      Success:    201 Created
     *      Error:      409 Conflict
     *                  500 Internal error
     *
     */
    const val createNote = "add"


}