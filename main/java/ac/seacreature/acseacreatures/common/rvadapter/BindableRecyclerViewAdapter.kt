package ac.seacreature.acseacreatures.common.rvadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class BindableRecyclerViewAdapter<T : IRecyclerViewItem> :
    RecyclerView.Adapter<BindableViewHolder<T>>() {

    private val data = ArrayList<T>()

    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): BindableViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false)
        return BindableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindableViewHolder<T>, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemViewType(position: Int): Int = data[position].getLayoutId()

    override fun getItemCount(): Int = data.size

    fun updateList(newList: List<T>) {
        val diffCallback = DiffCallback(data, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data.clear()
        data.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    private class DiffCallback<T : IRecyclerViewItem>(val oldList: List<T>, val newList: List<T>) :
        DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].getId() == newList[newItemPosition].getId()

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

    }
}
