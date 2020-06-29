package net.karatek.gutilities.listener;

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
