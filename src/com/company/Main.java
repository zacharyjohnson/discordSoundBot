package com.company;

import com.company.commands.*;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class Main {

    public static JDA jda;
    public static final CommandParser PARSER = new CommandParser();

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
        commands.put("bling", new BlingCommand());
        commands.put("hello", new HelloCommand());
        commands.put("rick", new RickCommand());
        commands.put("fuck", new JoinChannelCommand());
        commands.put("leave", new LeaveCommand());
        commands.put("ready", new ReadyCommand());
        commands.put("bren", new BrenCommand());
        commands.put("spoopy", new SpoopyCommand());
    }

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
}
