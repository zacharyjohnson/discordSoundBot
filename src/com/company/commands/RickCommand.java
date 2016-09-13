package com.company.commands;

import com.company.Command;
import com.company.Main;
import net.dv8tion.jda.audio.player.FilePlayer;
import net.dv8tion.jda.audio.player.Player;
import net.dv8tion.jda.entities.Channel;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.managers.AudioManager;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.events.Event;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.company.Main.jda;
import static com.company.Main.voiceCommandExecution;
import static java.lang.Thread.sleep;
import static net.dv8tion.jda.entities.impl.JDAImpl.LOG;
import static sun.audio.AudioPlayer.player;


/**
 * Created by Zach on 9/8/16.
 */
public class RickCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

       voiceCommandExecution(event, "/Users/Zach/Documents/discordSoundBot/src/com/company/Sounds/I'm Rick Harrison, and this is my Pawn Shop..mp3");


    }




    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}