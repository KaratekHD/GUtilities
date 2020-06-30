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

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class FlyListener implements Listener {

    @EventHandler
    public void onFlight(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("gamelmc.fly")) {
            e.setCancelled(true);
            p.kickPlayer("§4§b GamelMC Anti-Cheat\n" +
                    "§rDu wurdest gekickt, da du fliegst, ohne Rechte dafür zu haben.");
            Bukkit.broadcast("Der Spieler §a" + p.getDisplayName() + " §r fliegt, ohne die notwendigen Rechte zu besitzen", "gamelmc.teamchat");
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("gamelmc.fly") && p.isFlying()) {
            e.setCancelled(true);
            p.kickPlayer("§4§b GamelMC Anti-Cheat\n" +
                    "§rDu wurdest gekickt, da du fliegst, ohne Rechte dafür zu haben.");
            Bukkit.broadcast("Der Spieler §a" + p.getDisplayName() + " §r fliegt, ohne die notwendigen Rechte zu besitzen", "gamelmc.teamchat");
        }
    }

}
