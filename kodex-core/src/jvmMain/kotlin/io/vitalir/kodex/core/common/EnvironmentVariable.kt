package io.vitalir.kodex.core.common

actual fun getEnv(name: String): String? = System.getenv(name)
