package com.rns.marvelapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor() : Interceptor {

    private val publicKey: String = "You public key"
    private val privateKey: String = "You private key"
    private val timeStamp = System.currentTimeMillis().toString()
    private val hash = generateHash(publicKey, privateKey, timeStamp)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(API_KEY, publicKey)
            .addQueryParameter(TIME_STAMP, timeStamp)
            .addQueryParameter(HASH, hash)
            .build()

        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }

    private fun generateHash(publicKey: String, privateKey: String, timeStamp: String): String {
        val input = timeStamp + privateKey + publicKey
        val bytes = MessageDigest.getInstance("MD5").digest(input.toByteArray(Charsets.UTF_8))
        return bytes.joinToString("") { "%02x".format(it) }
    }

    companion object {
        private const val API_KEY = "apikey"
        private const val TIME_STAMP = "ts"
        private const val HASH = "hash"
    }
}