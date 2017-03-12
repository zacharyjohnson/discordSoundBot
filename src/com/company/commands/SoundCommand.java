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
                int number = r.nextInt(5);
                System.out.println(number);
                if (number == 3){
                    voiceCommandExecution(event, "rickRoll.mp3", 0.4f);
                } else if(number == 4){
                    voiceCommandExecution(event, "neverHitNotes.mp3", 0.5f);
                } else {
                    voiceCommandExecution(event, "rickHarrison.mp3", 0.4f);
                }
                break;
            case "spoopy":
                voiceCommandExecution(event, "Spooky.mp3", 0.2f);
                event.getTextChannel().sendMessage("http://i.makeagif.com/media/10-09-2015/KH29IN.gif");
                break;
            case "airhorn":
                voiceCommandExecution(event, "airHorn.mp3", 1f);
                break;
            case "allwin":
                voiceCommandExecution(event, "allIDoIsWin.mp3", 0.75f);
                break;
            case "fart":
                voiceCommandExecution(event, "fart.mp3", 1f);
                break;
            case "getoff":
                voiceCommandExecution(event, "getOffMyBoard.mp3", 0.1f);
                break;
            case "johncena":
                voiceCommandExecution(event, "johnCena.mp3", 0.2f);
                break;
            case "ready":
                voiceCommandExecution(event, "Ready.mp3", 1f);
                break;
            case "sad":
                voiceCommandExecution(event, "sadViolin.mp3", 0.7f);
                break;
            case "sada":
                voiceCommandExecution(event, "sadViolinAirhorn.mp3", 0.4f);
                break;
            case "scream":
                voiceCommandExecution(event, "wilhelmScream.mp3", 1f);
                break;
            case "clap":
                voiceCommandExecution(event, "applause.mp3", 0.7f);
                break;
            case "rimshot":
                voiceCommandExecution(event, "rimshot.mp3", 1f);
                break;
            case "benny":
                voiceCommandExecution(event, "bennyhill.mp3", 0.8f);
                break;
            case "damn":
                voiceCommandExecution(event, "damnson.mp3", 0.7f);
                break;
            case "doit":
                voiceCommandExecution(event, "justDoIt.mp3", 0.4f);
                break;
            case "drama":
                voiceCommandExecution(event, "dramaKill.mp3", 0.5f);
                break;
            case "mumscar":
                voiceCommandExecution(event, "willThisFrigginWork.mp3", 0.9f);
                break;
            case "ogre":
                voiceCommandExecution(event, "itAllOgreNow.mp3", 0.3f);
                break;
            case "lile":
                voiceCommandExecution(event, "littleEinsteins.mp3", 0.5f);
                break;
            case "ohh":
                voiceCommandExecution(event, "ohh.mp3", 0.3f);
                break;
            case "psycho":
                voiceCommandExecution(event, "psycho.mp3", 0.2f);
                break;
            case "shia":
                voiceCommandExecution(event, "newShia.mp3", 0.5f);
                break;
            case "shotsfired":
                voiceCommandExecution(event, "shotsFired.mp3", 0.7f);
                break;
            case "xfiles":
                voiceCommandExecution(event, "xfiles.mp3", 0.8f);
                break;
            case "cancer":
                voiceCommandExecution(event, "cancer.mp3", 0.5f);
                break;
            case "never":
                voiceCommandExecution(event, "neverHitNotes.mp3", 0.5f);
                break;
            case "notime":
                voiceCommandExecution(event, "aintNobodyGotTimeForThat.mp3", 0.5f);
                break;
            case "boo":
                voiceCommandExecution(event, "booingCrowd.mp3", 0.7f);
                break;
            case "bell":
                voiceCommandExecution(event, "boxingBell.mp3", 0.7f);
                break;
            case "challengea":
                voiceCommandExecution(event, "challengeAccepted.mp3", 0.7f);
                break;
            case "crickets":
                voiceCommandExecution(event, "crickets.mp3", 0.7f);
                break;
            case "cheer":
                voiceCommandExecution(event, "cheeringCrowd.mp3", 0.8f);
                break;
            case "bumbum":
                voiceCommandExecution(event, "dramaticChipmunk.mp3", 1f);
                break;
            case "drumroll":
                voiceCommandExecution(event, "drumRoll.mp3", 0.7f);
                break;
            case "dundun":
                voiceCommandExecution(event, "dunDun.mp3", 0.7f);
                break;
            case "letitgo":
                voiceCommandExecution(event, "letItGo.mp3", 0.6f);
                break;
            case "sax":
                voiceCommandExecution(event, "carelessWhisper.mp3", 0.6f);
                break;
            case "harlemshake":
                voiceCommandExecution(event, "harlemShake.mp3", 0.5f);
                break;
            case "yea":
                voiceCommandExecution(event, "HEYYEYAAEYAAAEYAEYAA.mp3", 0.5f);
                break;
            case "no":
                voiceCommandExecution(event, "howAboutNo.mp3", 0.7f);
                break;
            case "smell":
                voiceCommandExecution(event, "iCanSmellYou.mp3", 0.7f);
                break;
            case "killyou":
                voiceCommandExecution(event, "iWillKillYou.mp3", 0.9f);
                break;
            case "yee":
                voiceCommandExecution(event, "yee.mp3", 0.7f);
                break;
            case "taps":
                voiceCommandExecution(event, "taps.mp3", 0.8f);
                break;
            case "nogod":
                voiceCommandExecution(event, "noGodNo.mp3", 0.8f);
                break;
            case "pokemon":
                voiceCommandExecution(event, "iPlayPokemonGo.mp3", 0.5f);
                break;
            case "dumbass":
                voiceCommandExecution(event, "redFormanDumbass.mp3", 0.8f);
                break;
            case "aintmusic":
                voiceCommandExecution(event, "aintGotTimeRemix.mp3", 0.6f);
                break;
            case "gummybear":
                voiceCommandExecution(event, "gummBearSong.mp3", 0.6f);
                break;
            case "regional":
                voiceCommandExecution(event, "regionalAtBest.mp3", 0.6f);
                break;
            case "disgusting":
                voiceCommandExecution(event, "digusting.mp3", 0.7f);
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