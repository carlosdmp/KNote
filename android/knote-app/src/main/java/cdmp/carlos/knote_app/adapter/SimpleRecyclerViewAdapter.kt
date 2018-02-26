package cdmp.carlos.knote_app.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cdmp.carlos.knote_app.adapter.differ.ListDiffer

class SimpleRecyclerViewAdapter<T>(private var items: MutableList<T> = mutableListOf(),
                                   @LayoutRes private val viewHolderLayout: Int,
                                   private val holderInitializer: (item: T, view: View) -> Unit,
                                   private val itemDiffer: ListDiffer.ItemDiffer<T>? = null)
    : RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder<T>>() {

    /**
     * @param nItems new items the recycler will show
     */
    fun update(nItems: MutableList<T>) {
        when (itemDiffer) {
            null -> change(nItems)
            else -> {
                val listDiffer = ListDiffer<T>(nItems, items, itemDiffer)
                items.clear()
                this.items.addAll(nItems)
                listDiffer.update(this)
            }
        }
    }

    fun change(newItems: MutableList<T>) {
        items = newItems
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder<T>(LayoutInflater.from(parent.context).inflate(viewHolderLayout, parent, false))

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) = holder.bind(items[position], holderInitializer)

    override fun getItemCount() = items.size

    class ViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: T, holderInitializer: (item: T, view: View) -> Unit) = with(itemView) {
            holderInitializer.invoke(item, itemView)
        }
    }


}