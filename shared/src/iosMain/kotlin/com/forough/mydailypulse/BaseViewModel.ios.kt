package com.forough.mydailypulse

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

actual open class BaseViewModel actual constructor() {

    actual val scope = CoroutineScope(Dispatchers.IO)

    fun clear() {
        scope.cancel()
    }
}