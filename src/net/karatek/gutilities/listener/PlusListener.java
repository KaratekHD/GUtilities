package net.karatek.gutilities.listener;

/*
 * GUtilities
 * Copyright (C) 2019 GamelMC Developers
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */


import net.karatek.gutilities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class PlusListener implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        if(!msg.startsWith("++dev")) {
            e.setCancelled(false);
            return;
        }
        if(msg.equalsIgnoreCase("++dev")) {
            if(!p.hasPermission("gamelmc.devmode")) return;
            e.setCancelled(true);
            if(p.hasMetadata("devmode")) {
                p.removeMetadata("devmode", Main.getInstance());
                p.sendMessage(Main.devprefix + "Entwicklungsmodus: §cdeaktiviert.");
                return;
            } else {
                p.setMetadata("devmode", new FixedMetadataValue(Main.getInstance(), 0));
                p.sendMessage(Main.devprefix + "Entwicklungsmodus: §aaktiviert.");
                return;
            }
        }

        if(msg.startsWith("++") && p.hasMetadata("devmode")) {
            e.setCancelled(true);
            boolean used = false;
            switch (msg) {
                case "++help":
                    sendHelp(p);
                    break;
                case "++reloadmsg":
                    if (p.hasMetadata("reloadmsg")) {
                        p.sendMessage(Main.devprefix + "Reload Debug Modus: §cdeativiert§r.");
                        p.removeMetadata("reloadmsg", Main.getInstance());
                    } else {
                        p.sendMessage(Main.devprefix + "Reload Debug Modus: §aaktiviert§r.");
                        p.setMetadata("reloadmsg", new FixedMetadataValue(Main.getInstance(), 0));
                    }
                    break;
                case "++off":
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.kickPlayer("§4§lDer Server fährt herunter...");
                    }
                    Bukkit.getServer().getConsoleSender().sendMessage("§4§lDer Server wurde von " + p.getDisplayName() + " §4§lherunter gefahren.");
                    Bukkit.shutdown();
                    break;
                case "++scoremsg":
                    if (p.hasMetadata("scoremsg")) {
                        p.sendMessage(Main.devprefix + "Scoreboard Debug Modus: §cdeativiert§r.");
                        p.removeMetadata("scoremsg", Main.getInstance());
                    } else {
                        p.sendMessage(Main.devprefix + "Scoreboard Debug Modus: §aaktiviert§r.");
                        p.setMetadata("scoremsg", new FixedMetadataValue(Main.getInstance(), 0));
                    }
                    break;
                case "++test":
                    p.sendMessage(Main.devprefix + "Der Entwicklermodus ist aktiviert!");
                    break;
                case "++devlocker":
                    if(Main.devlock) {
                        Main.devlock = false;
                        p.sendMessage(Main.devprefix + "DevLocker: §causgeschltet§r.");
                        Bukkit.broadcastMessage(Main.prefix + "§rDer §cDevLocker §rist wieder ausgeschaltet.");
                        Bukkit.getServer().getConsoleSender().sendMessage(Main.devprefix + "DevLocker: §causgeschltet§r.");
                    } else {
                        Main.devlock = true;
                        p.sendMessage(Main.devprefix + "DevLocker: §aeingeschltet§r.");
                        Bukkit.broadcastMessage(Main.prefix + "§rDer §cDevLocker §rist derzeit §aaktiviert§r. Nur noch §bDeveloper§r können derzeit Änderungen durchführen!");
                        Bukkit.getServer().getConsoleSender().sendMessage(Main.devprefix + "DevLocker: §aeingeschltet§r.");
                    }
                    break;
                case "++joinmsg":
                    if(p.hasMetadata("joinmsg")) {
                        p.sendMessage(Main.devprefix + "Join Debugger: §cdeativiert§r.");
                        p.removeMetadata("joinmsg", Main.getInstance());
                    } else {
                        p.sendMessage(Main.devprefix + "Join Debugger: §aaktiviert§r.");
                        p.setMetadata("joinmsg", new FixedMetadataValue(Main.getInstance(), 0));
                    }
                    break;
                case "++crash":
                    if(Bukkit.getServer().getPluginManager().getPlugin("ClientCrasher") == null) {
                        p.sendMessage(Main.devprefix + " Das §aClientCrasher§r Plugin ist nicht installiert!");
                    } else {
                        p.sendMessage(Main.devprefix + "Leite Anfrage an das §aClientCrash§r Plugin weiter...");
                        e.setCancelled(false);
                    }
                    break;
                case "++spybps":

                    break;
                case "++joininfo":
                    if(p.hasMetadata("joininfo")) {
                        p.sendMessage(Main.devprefix + "Erweiterte Join Informationen: §cdeativiert§r.");
                        p.removeMetadata("joininfo", Main.getInstance());
                    } else {
                        p.sendMessage(Main.devprefix + "Erweiterte Join Informationen: §aaktiviert§r.");
                        p.setMetadata("joininfo", new FixedMetadataValue(Main.getInstance(), 0));
                    }
                    used = true;

                default:
                    if(msg.startsWith("++crash")) return;
                    if(used) return;
                    p.sendMessage(Main.devprefix + "Unbekannter Befehl. Veruche §a++help§r!");
            }

        }

    }

    public void sendHelp(Player p) {
        p.sendMessage("§7---------------------- " + Main.devprefix + "§7---------------------\n" +
                "§7§l• §6++test §r-§7 Prüft, ob der DevMode aktiviert ist.\n" +
                checkActive(p, "reloadmsg") + " §6++reloadmsg §r-§7 Schaltet Debug Informationen zum Laden von GUtilities ein oder aus.\n" +
                checkActive(p, "joinmsg") + " §6++joinmsg §r-§7 Schaltet Debug Informationen zum Joinen von Spielern ein oder aus.\n" +
                checkActive(p, "cmdspybypass") +" §6++spybps §r-§7 Macht dich unsichtbar gegenüber dem CommandSpy.\n" +
                checkActive(p,"scoremsg") + " §6++scoremsg §r-§7 Schaltet Debug Informationen zum Scoreboard an oder aus.\n" +
                devlockChecker() + " §6++devlocker §r-§7 Schaltet den DevLocker ein/aus.\n" +
                checkActive(p, "devmode") + " §6++dev §r-§7 Schaltet den Entwicklermodus aus.\n" +
                checkActive(p, "joininfo") + "Schaltet erweiterte JoinInformationen ein oder aus.");
        if(Bukkit.getServer().getPluginManager().getPlugin("ClientCrasher") != null) {
            p.sendMessage("§7§l• §6++crash §r-§7 Lässt das Spiel eines Spielers abstürzen (experimentell)\n");
        }
    }

    public String checkActive(Player player, String metadata) {
        if(player.hasMetadata(metadata)) return "§a§l•";
        else return "§c§l•";
    }

    public String devlockChecker() {
        if(Main.devlock) return "§a§l•";
        else return "§c§l•";
    }


}
