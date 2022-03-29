package ac.seacreature.acseacreatures.presentation.ui.detailed_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import ac.seacreature.acseacreatures.domain.usecase.GetSeaCreatureUsecase
import ac.seacreature.acseacreatures.domain.usecase.RefreshAllSeaCreaturesUsecase
import ac.seacreature.acseacreatures.presentation.mapper.toSeaCreatureDetailViewData
import ac.seacreature.acseacreatures.presentation.mapper.toUIState
import ac.seacreature.acseacreatures.presentation.model.SeaCreatureDetailViewData
import ac.seacreature.acseacreatures.presentation.model.UIState

class SeaCreatureDetailsViewModel(
    getUsecase: GetSeaCreatureUsecase,
    private val refreshUsecase: RefreshAllSeaCreaturesUsecase,
    id: Int
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
    val seaCreature: StateFlow<SeaCreatureDetailViewData?> = trigger
        .flatMapLatest {
            getUsecase(id).map { it.toSeaCreatureDetailViewData() }
        }
        .onStart {
            isLoading.value = true
            updateData()
        }
        .onEach {
            isLoading.value = false
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    private fun updateData() {
        isLoading.value = true
        trigger.tryEmit(Unit)
    }
}
