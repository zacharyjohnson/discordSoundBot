package com.company.commands;

import com.company.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by Zach on 9/8/16.
 */
public class BrenCommand implements Command {
    private final String HELP = "USAGE: !bling";


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Bren omg we're waiting hurry up!!!!!!!!");
        event.getTextChannel().sendMessage("jk we love you take ur time ");
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }
}