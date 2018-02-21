package cdmp.carlos.knote_app

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import presentation.CommonView
import presentation.Presenter
import presentation.ViewError

open class BaseActivity : AppCompatActivity(), CommonView {

    private var lazyPresenters: MutableList<Lazy<Presenter<CommonView>>> = common.emptyList()

    protected fun<T : Presenter<CommonView>> presenter(init: () -> T) = lazy(init)
            .also { lazyPresenters.add(it) }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lazyPresenters.forEach { it.value.onCreate() }
    }

    override fun logError(error: Throwable) {

    }

    override fun showError(error: ViewError) {

    }
}
