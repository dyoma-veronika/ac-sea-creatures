package ac.seacreature.acseacreatures.presentation.model

import ac.seacreature.acseacreatures.R
import ac.seacreature.acseacreatures.BR
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.findFragment
import ac.seacreature.acseacreatures.common.rvadapter.IRecyclerViewItem
import ac.seacreature.acseacreatures.presentation.ui.detailed_screen.SeaCreatureDetailsFragment


data class SeaCreatureViewData(
    private val id: Int,
    val nameEuRu: String,
    val nameUsEn: String,
    val iconUri: String,
    val price: Int
) : IRecyclerViewItem {
    override fun getItemId(): Int = BR.seaCreature
    override fun getLayoutId(): Int = R.layout.sea_creature_item
    override fun getId(): Int = id

    fun onClickItem(view: View) {
        val fragment = SeaCreatureDetailsFragment.newInstance(id)
        val fragmentManager = (view.context as AppCompatActivity).supportFragmentManager
        fragmentManager.beginTransaction().apply {
            add(R.id.host_fragment, fragment)
            detach(view.findFragment())
            addToBackStack(SeaCreatureDetailsFragment.BACK_STACK_NAME)
            commit()
        }
    }
}
