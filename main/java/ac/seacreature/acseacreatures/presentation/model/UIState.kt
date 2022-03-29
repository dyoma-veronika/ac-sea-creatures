package ac.seacreature.acseacreatures.presentation.model

import ac.seacreature.acseacreatures.common.network.NetworkErrors

sealed interface UIState {
    object Success : UIState
    object Loading : UIState
    class Error(val error: NetworkErrors) : UIState
}