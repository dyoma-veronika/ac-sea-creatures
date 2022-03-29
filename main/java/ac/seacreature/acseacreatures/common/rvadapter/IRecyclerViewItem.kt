package ac.seacreature.acseacreatures.common.rvadapter

interface IRecyclerViewItem {
    fun getItemId(): Int
    fun getLayoutId(): Int
    fun getId(): Int
}
