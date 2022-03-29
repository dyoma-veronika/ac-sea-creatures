package ac.seacreature.acseacreatures.common.binding_adapter

import android.view.View
import androidx.databinding.BindingAdapter
import ac.seacreature.acseacreatures.presentation.model.UIState

@BindingAdapter("showOnLoading")
fun View.showOnLoading(uiState: UIState?) {
    when (uiState) {
        is UIState.Loading -> visibility = View.VISIBLE
        is UIState.Error, is UIState.Success -> visibility = View.INVISIBLE
    }
}
