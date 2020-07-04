package net.karatek.gutilities.commands;

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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Info implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length < 1) {
                sender.sendMessage("§cVerwendung: /ginfo <Spieler>");
                return false;
            }
            Player t = Bukkit.getPlayer(args[0]);
            if (!t.isOnline()) {
                sender.sendMessage("§cDer Spieler ist nicht online!");
                return false;
            }
            sender.sendMessage(Main.prefix + "Zeige Informationen über §7" + t.getUniqueId().toString());
            sender.sendMessage("Name: " + t.getDisplayName() + "\n" +
                    "OP: §6" + t.isOp() + "\n" +
                    "§rFliegt: §6" + t.isFlying() + "\n" +
                    "§rIP: §6" + t.getAddress().toString().replace("/", "") + "\n" +
                    "§rXP: §6" + t.getExp() + "\n" +
                    "§rHunger: §6" + t.getFoodLevel() + "\n" +
                    "§rGesundheit: §6" + t.getHealthScale() + "\n" +
                    "§rGamemode: §6" + t.getGameMode().toString() + "\n" +
                    "§rLocale: §6" + t.getLocale() + "\n" +
                    "§Walkspeed: §6" + t.getWalkSpeed() + "\n" +
                    "§rFlyspeed: §6" + t.getFlySpeed() + "\n" +
                    "§rFacing: §6" + t.getFacing().toString() + "\n" +
                    "§rLocation: §6 X=" + t.getLocation().getX() + " Y=" + t.getLocation().getY() + " Z=" + t.getLocation().getZ());
            return true;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("gamelmc.info")) {
            p.sendMessage("§cDazu hast du keine Rechte!");
            return false;
        }
        if (args.length < 1) {
            p.sendMessage("§cVerwendung: /ginfo <Spieler>");
            return false;
        }
        Player t = Bukkit.getPlayer(args[0]);
        if (!t.isOnline()) {
            p.sendMessage("§cDer Spieler ist nicht online!");
            return false;
        }
        p.sendMessage(Main.prefix + "Zeige Informationen über §7" + t.getUniqueId().toString());
        p.sendMessage("Name: " + t.getDisplayName() + "\n" +
                "OP: §6" + t.isOp() + "\n" +
                "§rFliegt: §6" + t.isFlying() + "\n" +
                "§rIP: §6" + t.getAddress().toString().replace("/", "") + "\n" +
                "§rXP: §6" + t.getExp() + "\n" +
                "§rHunger: §6" + t.getFoodLevel() + "\n" +
                "§rGesundheit: §6" + t.getHealthScale() + "\n" +
                "§rGamemode: §6" + t.getGameMode().toString() + "\n" +
                "§rLocale: §6" + t.getLocale() + "\n" +
                "§Walkspeed: §6" + t.getWalkSpeed() + "\n" +
                "§rFlyspeed: §6" + t.getFlySpeed() + "\n" +
                "§rFacing: §6" + t.getFacing().toString() + "\n" +
                "§rLocation: §6 X=" + t.getLocation().getX() + " Y=" + t.getLocation().getY() + " Z=" + t.getLocation().getZ());
        return true;
    }
}
