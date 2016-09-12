package com.company;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by Zach on 9/8/16.
 */
public interface Command {

    public boolean called(String[] args, MessageReceivedEvent event);
    public void action(String[] args, MessageReceivedEvent event);
    public String help();
    public void executed(boolean success, MessageReceivedEvent event);

}
