package ru.otkatNotifier;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class isWiping extends ListenerAdapter {
    public static int trycount = 0;
    public static boolean wasWiped = false;
    static McServerChecker mcServerChecker = new McServerChecker();
    static DayOfWeek day = LocalDate.now().getDayOfWeek();
    static LocalTime time = LocalTime.now();

    public static boolean isHappening;

    public static void IsWiping() throws InterruptedException, IOException  {

        DiscordNotify disc = new DiscordNotify();

        disc.DiscConnect();

        while (true){
            if ((day.getValue() == 7) && (time.getHour() >= 10 && time.getHour() <= 22)) {
                while (wasWiped == false) {
                    trycount++;
                    System.out.println("try - " + trycount);

                    Thread.sleep(1000);

                    if (!mcServerChecker.isServerOff()) {
                        //WIPE
                        System.out.println("WIPE WIPE WIPE WIPE " + time + " " + LocalDate.now());
                        java.awt.Toolkit.getDefaultToolkit().beep();
                        java.awt.Toolkit.getDefaultToolkit().beep();
                        java.awt.Toolkit.getDefaultToolkit().beep();

                        isHappening = true;
                        Thread.sleep(10);
                        isHappening = false;

                        wasWiped = true;



                    } else {
                        //SERVER IS OK

                        System.out.println("Server is ON :)");


                        Thread.sleep(500);
                    }

                }
            }
            else {
                wasWiped = false;
                System.out.println("Another day at work...");
                Thread.sleep(60000);
                System.out.println("Status now");

                isHappening = true;
                Thread.sleep(10);
                isHappening = false;

                Thread.sleep(3600000);
            }
        }
    }
}
