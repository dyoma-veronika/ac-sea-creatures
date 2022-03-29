package ac.seacreature.acseacreatures.presentation.ui.detailed_screen

import ac.seacreature.acseacreatures.databinding.FragmentSeacreatureDetailBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SeaCreatureDetailsFragment : Fragment() {
    private var _binding: FragmentSeacreatureDetailBinding? = null
    private val binding get() = _binding!!
    private val creatureId: Int?
        get() = arguments?.getInt(CREATURE_ID)
    private val viewModel: SeaCreatureDetailsViewModel by viewModel { parametersOf(creatureId) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeacreatureDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BACK_STACK_NAME = "SeaCreatureDetailsFragment"
        const val CREATURE_ID = "id"

        fun newInstance(creatureId: Int): SeaCreatureDetailsFragment =
            SeaCreatureDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(CREATURE_ID, creatureId)
                }
            }
    }
}
