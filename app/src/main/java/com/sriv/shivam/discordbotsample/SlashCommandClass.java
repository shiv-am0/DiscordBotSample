package com.sriv.shivam.discordbotsample;

import android.os.Build;
import androidx.annotation.RequiresApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.interaction.SlashCommand;

public class SlashCommandClass {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void createSlashCommand(DiscordApi api) {
        SlashCommand.with("katon", "Fire Style")
                .createGlobal(api)
                .join();
    }
}