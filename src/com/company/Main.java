package com.company;

import com.company.commands.*;
import javafx.scene.media.MediaPlayer;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.audio.player.Player;
import net.dv8tion.jda.audio.player.URLPlayer;
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

public class Main {

    // Initializes the Java Discord Api (JDA) to be used for the program
    public static JDA jda;

    // Initialize the command parser object
    public static final CommandParser PARSER = new CommandParser();

    // Initialize the HashMap for the commands
    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    private static Player player;

    private static AudioManager audioManager;

    private int hello = 0;


    // Main method
    public static void main(String[] args) {

        // Set up JDA (log in)
        try {
            jda = new JDABuilder().addListener(new BotListener()).setBotToken("MjIzNTk0NDYyMzgxNjA0ODY0.CrOOFQ.EAfHsXvYyGzl0qWDIKIhk61_NA4").buildBlocking();
            jda.setAutoReconnect(true);
        } catch(Exception e) {
            e.printStackTrace();
        }

        commands.put("ping", new PingCommand());
        commands.put("hello", new HelloCommand());
        commands.put("leave", new LeaveCommand());
        commands.put("nerd", new NerdCommand());
        commands.put("!", new SoundCommand());
        commands.put("help", new HelpCommand());
    }


    /**
     * Executes commands if they contain a correct key
     * @param cmd the command that will be executed
     */
    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if(commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (safe) {
                commands.get(cmd.invoke).action(cmd.splitBeheaded, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
        }
    }


    /**
     * Detemines the voice channel of the user
     * @param event The message event
     * @param guild The guild of the player who sent the message
     * @return
     */
    public static VoiceChannel getVoiceChannel(MessageReceivedEvent event, Guild guild){

        VoiceChannel channel = null;

        outerloop:
        for (VoiceChannel channel1 : guild.getVoiceChannels()) {
            for (net.dv8tion.jda.entities.User user : channel1.getUsers()) {
                if (user.getId().equals(event.getAuthor().getId())) {
                    channel = channel1;
                    break outerloop;
                }
            }
        }

        return channel;
    }


    /**
     * Returns the player of the class
     * @return
     */
    public static Player getPlayer(){
        return player;
    }


    /**
     * Plays a specific file through the voice channel that the bot is in
     * @param channel The channel for the
     * @param fileExtensionName
     * @param event
     * @param guild
     */
    public static void playFile(VoiceChannel channel, String fileExtensionName, MessageReceivedEvent event, Guild guild, float volume) {

        File audioFile = null;
        URL audioUrl = null;
        try
        {
            //audioFile = new File(fileName);
                    audioUrl = new URL("https://raw.githubusercontent.com/zacharyjohnson/discordSoundBot/master/src/com/company/Sounds/" + fileExtensionName);


            //Player player = players.get(event.getGuild().getId());

            //Player player = new FilePlayer(audioFile);
                    player = new URLPlayer(event.getJDA(), audioUrl);

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
            player.setVolume(volume);
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
    }


    /**
     * Opens the audio connection for the bot
     * @param channel The channel to join
     * @param guild The guild of the player who sent the message
     */
    public static void openAudioConnection(VoiceChannel channel, Guild guild) {
        audioManager = jda.getAudioManager(guild);
        audioManager.openAudioConnection(channel);

    }


    /**
     * Executes the necessary methods in order to play an audio file in a voice channel
     * @param event The event of the command message that was sent
     * @param fileName The extension of the file to play
     */
    public static void voiceCommandExecution(MessageReceivedEvent event, String fileName, float volume) {
        if (audioManager != null && audioManager.isConnected()) {
            leave(event);
        }
        // The guild of the player who sent the message
        Guild guild = event.getGuild();

        // The voice channel of the person who called the command
        VoiceChannel channel = Main.getVoiceChannel(event, guild);

        // Opens the audio connection
        openAudioConnection(channel, guild);

        // Plays the file
        playFile(channel, fileName, event, guild, (float) (volume * 0.8));



    }


    /**
     * Stops the audio from playing and disconnects from the current voice channel
     * @param event The event that the message with the command contained
     */
    public static void leave(MessageReceivedEvent event){
        Main.getPlayer().stop();
        event.getGuild().getAudioManager().closeAudioConnection();
    }






}
