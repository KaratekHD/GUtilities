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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class DevLockerListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if(!Main.devlock) return;
        if(e.getPlayer().hasPermission("gamelmc.devmode")) return;
        else {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.prefix + "§rDer §cDevLocker §rist derzeit §aaktiviert§r. Nur noch §bDeveloper§r können Änderungen durchführen!");
        }
    }

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e) {
        if(!Main.devlock) return;
        if(e.getWhoClicked().hasPermission("gamelmc.devmode")) return;
        else {
            e.setCancelled(true);
            e.getWhoClicked().sendMessage(Main.prefix + "§rDer §cDevLocker §rist derzeit §aaktiviert§r. Nur noch §bDeveloper§r können Änderungen durchführen!");
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(!Main.devlock) return;
        if(e.getPlayer().hasPermission("gamelmc.devmode")) return;
        else {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.prefix + "§rDer §cDevLocker §rist derzeit §aaktiviert§r. Nur noch §bDeveloper§r können Änderungen durchführen!");
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(!Main.devlock) return;
        if(e.getPlayer().hasPermission("gamelmc.devmode")) return;
        else {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.prefix + "§rDer §cDevLocker §rist derzeit §aaktiviert§r. Nur noch §bDeveloper§r können Änderungen durchführen!");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(!Main.devlock) return;
        if(e.getPlayer().hasPermission("gamelmc.devmode")) return;
        else {
            e.getPlayer().sendMessage(Main.prefix + "§rDer §cDevLocker §rist derzeit §aaktiviert§r. Nur noch §bDeveloper§r können Änderungen durchführen!");
        }

    }


}
