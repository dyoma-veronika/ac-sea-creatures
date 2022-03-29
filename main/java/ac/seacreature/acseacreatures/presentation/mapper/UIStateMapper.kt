package ac.seacreature.acseacreatures.presentation.mapper

import ac.seacreature.acseacreatures.common.network.LoadingState
import ac.seacreature.acseacreatures.presentation.model.UIState

fun LoadingState.toUIState(): UIState = when (this) {
    is LoadingState.Error -> UIState.Error(this.error)
    is LoadingState.Success -> UIState.Success
    is LoadingState.Loading -> UIState.Loading
}
