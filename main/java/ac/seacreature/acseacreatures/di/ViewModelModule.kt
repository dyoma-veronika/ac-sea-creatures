package ac.seacreature.acseacreatures.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ac.seacreature.acseacreatures.presentation.ui.detailed_screen.SeaCreatureDetailsViewModel
import ac.seacreature.acseacreatures.presentation.ui.main_screen.MainScreenViewModel

val viewModelModule = module {
    viewModel<MainScreenViewModel> { MainScreenViewModel(get(), get()) }
    viewModel<SeaCreatureDetailsViewModel> { parameter ->
        SeaCreatureDetailsViewModel(get(), get(), id = parameter.get())
    }
}
