package ac.seacreature.acseacreatures.common.network

import ac.seacreature.acseacreatures.R
import androidx.annotation.StringRes
import java.lang.RuntimeException

sealed class NetworkErrors(@StringRes val messageRes: Int) : RuntimeException() {
    object NullBodyException : NetworkErrors(R.string.null_body_exception)
    object JsonParseException : NetworkErrors(R.string.json_parse_exception)
    object IOException : NetworkErrors(R.string.io_exception)
    object ClientException : NetworkErrors(R.string.client_exception)
    object ServerException : NetworkErrors(R.string.server_exception)
    object UnknowingError : NetworkErrors(R.string.unknowing_error)
}
