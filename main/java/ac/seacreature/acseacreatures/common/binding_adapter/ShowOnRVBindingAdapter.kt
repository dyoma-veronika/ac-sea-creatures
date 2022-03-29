package ac.seacreature.acseacreatures.common.binding_adapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ac.seacreature.acseacreatures.presentation.model.UIState

@BindingAdapter("showOnRV")
fun RecyclerView.showOnRV(uiState: UIState?) {
    when (uiState) {
        is UIState.Loading -> visibility = View.INVISIBLE
        is UIState.Error, is UIState.Success -> visibility = View.VISIBLE
    }
}