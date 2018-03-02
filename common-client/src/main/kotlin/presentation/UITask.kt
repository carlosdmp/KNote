package presentation

sealed class UITask{
    data class ExecuteTask<D>(val exec: D.() -> Unit) : UITask()
    data class TryTask<D, E>(val exec: D.() -> Unit, val errorExec: E.() -> Unit) : UITask()
}