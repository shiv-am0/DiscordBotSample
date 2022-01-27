package com.sriv.shivam.discordbotsample.utils

import android.os.Build
import androidx.annotation.RequiresApi
import org.javacord.api.DiscordApi
import org.javacord.api.DiscordApiBuilder

@RequiresApi(Build.VERSION_CODES.N)
object API {
    val api: DiscordApi by lazy {
        val api = DiscordApiBuilder().setToken(CONSTANTS.KEY_TOKEN).login().join()
        api
    }
}