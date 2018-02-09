import data.Note
import dataflow.toJson

fun main(args: Array<String>) {
    print(Note("Hello world","content").toJson())
}