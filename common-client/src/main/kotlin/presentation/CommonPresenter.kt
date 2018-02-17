package presentation

import common.Cancellable

abstract class CommonPresenter : Presenter {

    protected var jobs: List<Cancellable> = emptyList()

    override fun onDestroy() {
        jobs.forEach { it.cancel() }
    }
}