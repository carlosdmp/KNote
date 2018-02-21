package constants.api



object Endpoints{
    const val noteEndpoint = "notes"

    /**
     *  GET: returns a list of all notes
     *      Success:    200 OK
     *      Error:      400 Bad request
     *                  500 Internal error
     */
    const val getAllNotes = "get"

    /**
     *  POST: create a new note, returns note id
     *      Success:    201 Created
     *      Error:      400 Bad request
     *                  409 Conflict
     *                  500 Internal error
     *
     */
    const val createNote = "add"

    /**
     *  getNote + {id}
     *  GET: returns a note
     *      Success:    200 OK
     *      Error:      400 Bad request
     *                  404 Not found
     *                  500 Internal error
     */
    const val getNote = "get/"

    /**
     *  updateNote + {id}
     *  PUT: updates a note
     *      Success:    204 No content
     *      Error:      400 Bad request
     *                  404 Not found
     *                  500 Internal error
     */
    const val updateNote = "add/"

    /**
     *  removeNote + {id}
     *  DELETE: removes a note
     *      Success:    200 OK
     *      Error:      400 Bad request
     *                  404 Not found
     *                  500 Internal error
     */
}