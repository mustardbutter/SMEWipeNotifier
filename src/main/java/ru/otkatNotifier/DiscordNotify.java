package ru.otkatNotifier;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;


import java.util.List;

public class DiscordNotify extends ListenerAdapter {

    public void DiscConnect() {

        String token = "MTE5NjUyMzA3NjQyMzI2NjMzNA.G7BC0G.rNxdb0YzrEXFRaibbzmkPBC8lgPCYBAfuR6PDA";

        JDABuilder.createLight(token).addEventListeners(this).addEventListeners(new ListenerAdapter() {
                    @Override
                    public void onReady(ReadyEvent event) {
                        new DiscEventChannel(event.getJDA()).start();
                    }
                }
                )
                .enableIntents(List.of(
                                GatewayIntent.MESSAGE_CONTENT
                        )
                ).setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.playing("Survival Minecraft Extreme"))
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String messageRecieved = event.getMessage().getContentRaw();

        if (event.getAuthor().isBot()) {
            return;
        }

        if (messageRecieved.equalsIgnoreCase("ARE YOU READY KIDS?")) {
            event.getChannel().sendMessage("AI AI CAPTAIN").queue();
            event.getGuild().createTextChannel("sme-wipes");

            System.out.println("INITIALISED CHANNEL");

        }

    }

    public void NotifyAboutWipe() {


    }


    public void NotifyAboutServerStatus() {

        System.out.println("NIGGER");

    }


}
