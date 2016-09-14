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

        switch (sound){
            case "rick":
                Random r = new Random();
                int number = r.nextInt(4);
                System.out.println(number);
                if (number != 3){
                    voiceCommandExecution(event, "rickHarrison.mp3");
                } else {
                    voiceCommandExecution(event, "rickRoll.mp3");
                }
                break;
            case "spoopy":
                voiceCommandExecution(event, "Spooky.mp3");
                event.getTextChannel().sendMessage("http://i.makeagif.com/media/10-09-2015/KH29IN.gif");
                break;
            case "airhorn":
                voiceCommandExecution(event, "airHorn.mp3");
                break;
            case "allwin":
                voiceCommandExecution(event, "allIDoIsWin.mp3");
                break;
            case "fart":
                voiceCommandExecution(event, "fart.mp3");
                break;
            case "getOff":
                voiceCommandExecution(event, "getOffMyBoard.mp3");
                break;
            case "johncena":
                voiceCommandExecution(event, "johnCena.mp3");
                break;
            case "ready":
                voiceCommandExecution(event, "ready.mp3");
                break;
            case "sad":
                voiceCommandExecution(event, "sadViolin.mp3");
                break;
            case "sadv":
                voiceCommandExecution(event, "sadViolinAirhorn");
                break;
            case "scream":
                voiceCommandExecution(event, "wilhelmScream.mp3");
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