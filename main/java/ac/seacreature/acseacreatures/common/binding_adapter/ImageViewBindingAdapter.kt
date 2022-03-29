package ac.seacreature.acseacreatures.common.binding_adapter

import ac.seacreature.acseacreatures.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("loadingImage")
fun ImageView.loadImage(url: String?) {
    if (url == null) {
        return
    }
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_error)
        .circleCrop()
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .into(this)
}
