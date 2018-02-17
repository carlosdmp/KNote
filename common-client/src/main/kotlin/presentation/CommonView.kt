package presentation

interface CommonView{
    fun logError(error: Throwable)
    fun showError(error: Throwable)
}