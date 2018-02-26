package cdmp.carlos.knote_app.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MultipleRecyclerViewAdapter<T>(private val layoutSwitch: ((viewType: Int) -> Int),
                                     private val items: List<T> = emptyList(),
                                     private val viewTypeSwitch: ((item: T, position: Int) -> Int),
                                     private val holderInitializer: (item: T, view: View, viewType: Int) -> Unit)
    : RecyclerView.Adapter<MultipleRecyclerViewAdapter.ViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder<T>(LayoutInflater.from(parent.context).inflate(layoutSwitch.invoke(viewType), parent, false), viewType)

    override fun getItemViewType(position: Int) = viewTypeSwitch(items[position], position)

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) = holder.bind(items[position], holderInitializer)

    override fun getItemCount() = items.size

    class ViewHolder<T>(itemView: View, private val viewType: Int) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: T, holderInitializer: (item: T, view: View, viewType: Int) -> Unit) = with(itemView) {
            holderInitializer.invoke(item, itemView, viewType)
        }
    }
}