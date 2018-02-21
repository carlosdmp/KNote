package presentation

import common.Cancellable

abstract class CommonPresenter<out V : CommonView>(private val view: V) : Presenter<V> {

    override fun doInView(uiTask: (V.() -> Unit)){
        uiTask.invoke(view)
    }


    private val jobs: List<Cancellable> = emptyList()

    override fun onDestroy() {
        jobs.forEach { it.cancel() }
    }
}