package ru.otkatNotifier;

import net.dv8tion.jda.api.JDA;

public class DiscEventChannel {
    private final JDA api;
    DiscordNotify notify = new DiscordNotify();
    public DiscEventChannel(JDA jda) {
        this.api = jda;
    }


    public void start() {
        if (isWiping.isHappening == true){
            notify.NotifyAboutServerStatus();
        }
    }
}
