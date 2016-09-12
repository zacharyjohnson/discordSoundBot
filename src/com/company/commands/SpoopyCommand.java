package com.company.commands;

import com.company.Command;
import com.company.Main;
import net.dv8tion.jda.audio.player.FilePlayer;
import net.dv8tion.jda.audio.player.Player;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.managers.AudioManager;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.company.Main.jda;


/**
 * Created by Zach on 9/8/16.
 */
public class SpoopyCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        // The guild of the player who sent the message
        Guild guild = event.getGuild();

        // The voice channel of the person who called the command
        VoiceChannel channel = Main.getVoiceChannel(event, guild);

        AudioManager audioManager = jda.getAudioManager(guild);
        audioManager.openAudioConnection(channel);

        File audioFile = null;
        URL audioUrl = null;
        try
        {
            audioFile = new File("/Users/Zach/Documents/discordSoundBot/src/com/company/Sounds/Spooky.mp3");
//                    audioUrl = new URL("https://dl.dropboxusercontent.com/u/41124983/anime-48000.mp3?dl=1");

            Map<String,Player> players = new HashMap<>();
            Player player = players.get(event.getGuild().getId());

            player = new FilePlayer(audioFile);
//                    player = new URLPlayer(event.getJDA(), audioUrl);

            //Add the new player to the cache


            //Provide the handler to send audio.
            //NOTE: You don't have to set the handler each time you create an audio connection with the
            // AudioManager. Handlers persist between audio connections. Furthermore, handler playback is also
            // paused when a connection is severed (closeAudioConnection), however it would probably be better
            // to pause the play back yourself before severing the connection (If you are using a player class
            // you could just call the pause() method. Otherwise, make canProvide() return false).
            // Once again, you don't HAVE to pause before severing an audio connection,
            // but it probably would be good to do.
            event.getGuild().getAudioManager().setSendingHandler(player);

            //Start playback. This will only start after the AudioConnection has completely connected.
            //NOTE: "completely connected" is not just joining the VoiceChannel. Think about when your Discord
            // client joins a VoiceChannel. You appear in the channel lobby immediately, but it takes a few
            // moments before you can start communicating.
            player.play();
        }
        catch (IOException e)
        {
            event.getChannel().sendMessage("Could not load the file. Does it exist?  File name: " + audioFile.getName());
            e.printStackTrace();
        }
        catch (UnsupportedAudioFileException e)
        {
            event.getChannel().sendMessage("Could not load file. It either isn't an audio file or isn't a" +
                    " recognized audio format.");
            e.printStackTrace();
        }

        event.getTextChannel().sendMessage("http://i.makeagif.com/media/10-09-2015/KH29IN.gif");
    }




    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}