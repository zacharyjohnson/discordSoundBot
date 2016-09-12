package com.company;

import com.company.commands.*;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class Main {

    // Initializes the Java Discord Api (JDA) to be used for the program
    public static JDA jda;

    // Initialize the command parser object
    public static final CommandParser PARSER = new CommandParser();

    // Initialize the HashMap for the commands
    public static HashMap<String, Command> commands = new HashMap<String, Command>();


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
        commands.put("rick", new RickCommand());
        commands.put("leave", new LeaveCommand());
        commands.put("ready", new ReadyCommand());
        commands.put("bren", new BrenCommand());
        commands.put("spoopy", new SpoopyCommand());
    }


    /**
     * Executes commands if they contain a correct key
     * @param cmd the command that will be executed
     */
    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if(commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
        }
    }


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


}
