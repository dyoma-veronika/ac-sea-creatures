package ac.seacreature.acseacreatures.presentation.ui.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import ac.seacreature.acseacreatures.domain.usecase.GetAllSeaCreaturesUsecase
import ac.seacreature.acseacreatures.domain.usecase.RefreshAllSeaCreaturesUsecase
import ac.seacreature.acseacreatures.presentation.mapper.toSeaCreatureViewData
import ac.seacreature.acseacreatures.presentation.mapper.toUIState
import ac.seacreature.acseacreatures.presentation.model.UIState

class MainScreenViewModel(
    getUsecase: GetAllSeaCreaturesUsecase,
    private val refreshUsecase: RefreshAllSeaCreaturesUsecase
) : ViewModel() {
    val isLoading = MutableStateFlow(false)
    private val trigger = MutableSharedFlow<Unit>(replay = 1)

    @OptIn(ExperimentalCoroutinesApi::class)
    val uiState: LiveData<UIState> = trigger.flatMapLatest {
        refreshUsecase().map {
            it.toUIState()
        }
    }.asLiveData(viewModelScope.coroutineContext)

    @OptIn(ExperimentalCoroutinesApi::class)
    val seaCreatures = trigger
        .flatMapLatest {
            getUsecase().map { requestData ->
                requestData.map { seaCreatureData ->
                    seaCreatureData.toSeaCreatureViewData()
                }
            }
        }
        .onStart {
            isLoading.value = true
            updateData()
        }
        .onEach {
            isLoading.value = false
        }
        .asLiveData(viewModelScope.coroutineContext)

    val listener = SwipeRefreshLayout.OnRefreshListener {
        updateData()
    }

    private fun updateData() {
        isLoading.value = true
        trigger.tryEmit(Unit)
    }
}
