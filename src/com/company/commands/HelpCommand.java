package com.company.commands;

import com.company.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by Zach on 9/14/16.
 */
public class HelpCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("!help  - Lists all available commands" +
                    "\n!ping - replies with PONG" +
                    "\nSounds:");
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
