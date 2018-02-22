package presentation

enum class Source {
    CACHE,
    DB,
    API,
    NONE
}

enum class Status {
    SUCCESS,
    FAILURE,
    LOADING
}

data class Resource<out T>(val source: Source, val status: Status, val data: T?, val error: DomainError? = null) {

    fun handle(onSuccess: ((T) -> Unit), onFailure: ((DomainError) -> Unit), whileLoading: ((T) -> Unit) = {}) {
        when (status) {
            Status.SUCCESS -> data?.let { onSuccess.invoke(data) }
            Status.FAILURE -> error?.let { onFailure.invoke(error) }
            Status.LOADING ->  data?.let { onSuccess.invoke(data) }
        }
    }

    companion object {

        fun <T> loading(source: Source, data: T?) = Resource(source, Status.LOADING, data)

        fun <T> success(source: Source, data: T?) = Resource(source, Status.SUCCESS, data)

        fun <T> failure(source: Source, error: DomainError, data: T? = null) = Resource(source, Status.FAILURE, data, error)
    }
}
