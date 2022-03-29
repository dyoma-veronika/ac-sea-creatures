package ac.seacreature.acseacreatures.common.rvadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@Suppress("UNCHECKED_CAST")
@BindingAdapter("items")
fun <T : IRecyclerViewItem> RecyclerView.setItems(dataList: List<T>?) {
    val items = dataList ?: emptyList()
    (adapter as? BindableRecyclerViewAdapter<T>)?.updateList(items) ?: run {
        val bindableAdapter = BindableRecyclerViewAdapter<T>()
        bindableAdapter.updateList(items)
        adapter = bindableAdapter
    }
}
