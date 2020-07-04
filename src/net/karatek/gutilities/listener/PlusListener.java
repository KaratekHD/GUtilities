package net.karatek.gutilities.listener;

/*
 * GUtilities Reloaded
 * Copyright (C) 2020 Karatek_HD
 * Copyright (C) 2019 GamelMC Developers / Karatek_HD
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
                case "++crash":
                    if (Bukkit.getServer().getPluginManager().getPlugin("ClientCrasher") == null) {
                        p.sendMessage(Main.devprefix + " Das §aClientCrasher§r Plugin ist nicht installiert!");
                    } else {
                        p.sendMessage(Main.devprefix + "Leite Anfrage an das §aClientCrash§r Plugin weiter...");
                        e.setCancelled(false);
                    }
                    break;
                case "++spybps":
                    if (p.hasMetadata("cmdspybypass")) {
                        p.sendMessage(Main.devprefix + "Commandspy Bypass: §cdeativiert§r.");
                        p.removeMetadata("cmdspybypass", Main.getInstance());
                    } else {
                        p.sendMessage(Main.devprefix + "Commandspy Bypass: §aaktiviert§r.");
                        p.setMetadata("cmdspybypass", new FixedMetadataValue(Main.getInstance(), 0));
                    }
                    break;
                default:
                    if(msg.startsWith("++crash")) return;
                    p.sendMessage(Main.devprefix + "Unbekannter Befehl. Veruche §a++help§r!");
            }

        }

    }

    public void sendHelp(Player p) {
        p.sendMessage("§7---------------------- " + Main.devprefix + "§7---------------------\n" +
                "§7§l• §6++test §r-§7 Prüft, ob der DevMode aktiviert ist.\n" +
                checkActive(p, "reloadmsg") + " §6++reloadmsg §r-§7 Schaltet Debug Informationen zum Laden von GUtilities ein oder aus.\n" +
                checkActive(p, "cmdspybypass") + " §6++spybps §r-§7 Macht dich unsichtbar gegenüber dem CommandSpy.\n" +
                devlockChecker() + " §6++devlocker §r-§7 Schaltet den DevLocker ein/aus.\n" +
                checkActive(p, "devmode") + " §6++dev §r-§7 Schaltet den Entwicklermodus aus.");
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
