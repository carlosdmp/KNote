package presentation

import common.Cancellable
import kotlinx.coroutines.experimental.Job

abstract class CommonPresenter<out V : CommonView>(private val view: V) : Presenter<V> {

    override fun doInView(uiTask: (V.() -> Unit)){
        uiTask.invoke(view)
    }
    protected val jobs: MutableList<Job> = mutableListOf()

    override fun onDestroy() {
        jobs.forEach { it.cancel() }
    }
}