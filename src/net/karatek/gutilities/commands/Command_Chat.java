package net.karatek.gutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Chat implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String s1 = "";
        int counted = 0;
        while (counted < strings.length) {
            s1 = s1 + strings[counted] + " ";
            counted++;
        }
        Player p = (Player) commandSender;
        p.chat(s1);
        if(p.hasMetadata("tclogin")) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                if(all.hasMetadata("tclogin")) {
                    all.sendMessage("§f[§4§lTEAMCHAT§r§f] " + p.getDisplayName() + " §8>> §r" + s1);
                }
            }
        }
        return true;
    }
}
