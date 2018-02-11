package org.pasas.knote

import data.Note
import kotlin.properties.Delegates

class NoteBindModel(note : Note) : BindModel(){
    var note by bind(note)
}