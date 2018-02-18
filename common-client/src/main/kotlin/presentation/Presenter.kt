package presentation

interface Presenter<out V : CommonView> {
    fun onCreate() {}
    fun onDestroy() {}
    fun doInView(uiTask: (V.() -> Unit))
}