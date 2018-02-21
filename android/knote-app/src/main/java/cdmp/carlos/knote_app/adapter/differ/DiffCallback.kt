package cdmp.carlos.knote_app.adapter.differ

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView


class ListDiffer<T>(newItemList: List<T>,
                    oldItemList: List<T>,
                    itemDiffer: ItemDiffer<T>) {

    private val operations: DiffUtil.DiffResult by lazy { DiffUtil.calculateDiff(DiffCallback(newItemList, oldItemList, itemDiffer)) }

    fun update(updateListener: RecyclerView.Adapter<*>) {
        operations.dispatchUpdatesTo(updateListener)
    }

    class DiffCallback<T>(private val newItemList: List<T>, private val oldItemList: List<T>, private val itemDiffer: ItemDiffer<T>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldItemList.size
        }

        override fun getNewListSize(): Int {
            return newItemList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = itemDiffer.areItemsTheSame(newItemList[newItemPosition], oldItemList[newItemPosition])

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = itemDiffer.areContentsTheSame(newItemList[newItemPosition], oldItemList[newItemPosition])

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int) = super.getChangePayload(oldItemPosition, newItemPosition)
    }

    interface ItemDiffer<T> {
        fun areItemsTheSame(first: T, second: T): Boolean
        fun areContentsTheSame(first: T, second: T): Boolean
    }
}
