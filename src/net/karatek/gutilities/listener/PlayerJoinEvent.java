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

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        e.setJoinMessage("§7[§a+§7] " + e.getPlayer().getDisplayName());
        Player p = e.getPlayer();

        /*
        PermissionUser pu = PermissionsEx.getUser(p);
        if(pu.inGroup("Developer") || pu.inGroup("MainDeveloper")) {
            boolean devmode = p.hasMetadata("devmode");
            if(devmode) {
                p.sendMessage(Main.devprefix + "Entwicklungsmodus: §aaktiviert.");
                //Send messgeas about the dev modules
                if(p.hasMetadata("joinmsg")) {
                    p.sendMessage(Main.devprefix + "Join Debugger: §aaktiviert..");
                } else {
                    p.sendMessage(Main.devprefix + "Join Debugger: §cdeaktiviert..");
                }

                if(p.hasMetadata("scoremsg")) {
                    p.sendMessage(Main.devprefix + "Scoreboard Debugger: §aaktiviert..");
                } else {
                    p.sendMessage(Main.devprefix + "Scoreboard Debugger: §cdeaktiviert..");
                }

                if(p.hasMetadata("reloadmsg")) {
                    p.sendMessage(Main.devprefix + "Reload Debugger: §aaktiviert..");
                } else {
                    p.sendMessage(Main.devprefix + "Reload Debugger: §cdeaktiviert..");
                }

                if(p.hasMetadata("cmdspybypass")) {
                    p.sendMessage(Main.devprefix + "CommandSpy Bypass: §aaktiviert.§r.");
                }

                if(Main.devlock) {
                    p.sendMessage(Main.devprefix + "DevLocker: §aeingeschltet§r.");
                } else {
                    p.sendMessage(Main.devprefix + "DevLocker: §causgeschltet§r.");
                }




            } else {
                p.sendMessage(Main.devprefix + "Entwicklungsmodus: §cdeaktiviert.");
            }

         */
        }


    }



