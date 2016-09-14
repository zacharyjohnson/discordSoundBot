package com.company.commands;

import com.company.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.util.Random;

import static com.company.Main.voiceCommandExecution;


/**
 * Has a 1 in 4 chance of playing a Rick Roll. The other opportunities play the audio from the Pawn Shop introduction.
 * Created by Zach on 9/8/16.
 */
public class SoundCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String sound = args[1];
        String[] soundList =
                {"rick",
                "spoopy"};
        switch (sound){
            case "rick":
                Random r = new Random();
                int number = r.nextInt(4);
                System.out.println(number);
                if (number != 3){
                    voiceCommandExecution(event, "I'm%20Rick%20Harrison%2C%20and%20this%20is%20my%20Pawn%20Shop..mp3");
                } else {
                    voiceCommandExecution(event, "Rick%20Astley%20-%20Never%20Gonna%20Give%20You%20Up.mp3");
                }
                break;
            case "spoopy":
                voiceCommandExecution(event, "Spooky.mp3");
                event.getTextChannel().sendMessage("http://i.makeagif.com/media/10-09-2015/KH29IN.gif");
                break;
        }



    }




    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}