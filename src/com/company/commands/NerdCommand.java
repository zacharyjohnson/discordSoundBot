package com.company.commands;

import com.company.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.io.File;

/**
 * Created by Zach on 9/13/16.
 */
public class NerdCommand implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        File file = new File("/Users/Zach/Documents/discordSoundBot/discordSoundBot/src/com/company/Images/nerd_80_anim_gif-1.gif");

        event.getTextChannel().sendFile(file, null);
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
