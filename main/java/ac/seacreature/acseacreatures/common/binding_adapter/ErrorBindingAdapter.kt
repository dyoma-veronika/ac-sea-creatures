package ac.seacreature.acseacreatures.common.binding_adapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import ac.seacreature.acseacreatures.presentation.model.UIState

@BindingAdapter("showOnError")
fun TextView.showOnError(uiState: UIState?) {
    when (uiState) {
        is UIState.Error -> {
            visibility = View.VISIBLE
            text = resources.getText(uiState.error.messageRes)
        }
        is UIState.Loading, is UIState.Success -> visibility = View.INVISIBLE
    }
}
