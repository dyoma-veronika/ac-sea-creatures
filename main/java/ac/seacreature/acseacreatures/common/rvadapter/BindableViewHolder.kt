package ac.seacreature.acseacreatures.common.rvadapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindableViewHolder<T : IRecyclerViewItem>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: T) {
        binding.setVariable(item.getItemId(), item)
    }
}
