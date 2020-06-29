package net.karatek.gutilities.listener;

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
