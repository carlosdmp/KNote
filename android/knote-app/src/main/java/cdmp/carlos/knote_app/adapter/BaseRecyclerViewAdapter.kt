package cdmp.carlos.knote_app.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BaseRecyclerViewAdapter<T>(@LayoutRes private val viewHolderLayout: Int,
                                                    private val items: List<T> = emptyList(),
                                                    private val holderInitializer: (T, View) -> Unit)
    : RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder<T>(LayoutInflater.from(parent.context).inflate(viewHolderLayout, parent, false))

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) = holder.bind(items[position], holderInitializer)

    override fun getItemCount() = items.size

    class ViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: T, holderInitializer: (T, View) -> Unit) = with(itemView) {
            holderInitializer.invoke(item, itemView)
        }
    }
}