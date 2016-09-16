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

        switch (sound.toLowerCase()){
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
            case "getoff":
                voiceCommandExecution(event, "getOffMyBoard.mp3");
                break;
            case "johncena":
                voiceCommandExecution(event, "johnCena.mp3");
                break;
            case "ready":
                voiceCommandExecution(event, "Ready.mp3");
                break;
            case "sad":
                voiceCommandExecution(event, "sadViolin.mp3");
                break;
            case "sada":
                voiceCommandExecution(event, "sadViolinAirhorn.mp3");
                break;
            case "scream":
                voiceCommandExecution(event, "wilhelmScream.mp3");
                break;
            case "clap":
                voiceCommandExecution(event, "applause.mp3");
                break;
            case "rimshot":
                voiceCommandExecution(event, "rimshot.mp3");
                break;
            case "benny":
                voiceCommandExecution(event, "bennyhill.mp3");
                break;
            case "damn":
                voiceCommandExecution(event, "damnson.mp3");
                break;
            case "doit":
                voiceCommandExecution(event, "justDoIt.mp3");
                break;
            case "drama":
                voiceCommandExecution(event, "dramaticChipmonk.mp3");
                break;
            case "mumscar":
                voiceCommandExecution(event, "inMeMumsCar.mp3");
                break;
            case "ogre":
                voiceCommandExecution(event, "itAllOgreNow.mp3");
                break;
            case "lile":
                voiceCommandExecution(event, "littleEinsteins.mp3");
                break;
            case "ohh":
                voiceCommandExecution(event, "ohh.mp3");
                break;
            case "psycho":
                voiceCommandExecution(event, "psycho.mp3");
                break;
            case "shia":
                voiceCommandExecution(event, "shia.mp3");
                break;
            case "shotsfired":
                voiceCommandExecution(event, "shotsFired.mp3");
                break;
            case "xfiles":
                voiceCommandExecution(event, "xfiles.mp3");
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