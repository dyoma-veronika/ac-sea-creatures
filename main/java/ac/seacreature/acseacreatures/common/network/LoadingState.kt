package ac.seacreature.acseacreatures.common.network

sealed interface LoadingState {
    object Loading : LoadingState
    object Success : LoadingState
    class Error(val error: NetworkErrors) : LoadingState
}
