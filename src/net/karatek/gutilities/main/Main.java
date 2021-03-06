package net.karatek.gutilities.main;

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

import net.karatek.gutilities.commands.*;
import net.karatek.gutilities.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {

    public static String prefix = "§r[§6§lkaratek.net§r] ";
    public static String devprefix = "§r[§b§lkaratek.net§r] ";
    public static String pre = prefix;
    public static boolean unstable = true;
    public static String version = "1.0 for 1.16.2";
    public static boolean devlock = false;


    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        for(Player all : Bukkit.getOnlinePlayers()) {
            if(all.hasMetadata("reloadmsg")) {
                all.sendMessage(Main.devprefix + "Das §aGUtilties§r Plugn wurde neu geladen. Die geladene Version ist §a" + version + "§r.");
            }
        }
        Bukkit.getConsoleSender().sendMessage(prefix + "§aDas GUtilities Plugin wurde aktiviert.");

        instance = this;

        //register Commands
        this.getCommand("kick").setExecutor(new Command_Kick());

        // This command is not activated since it needs to be completly rewritten for the new versions.
        //
        // this.getCommand("kopf").setExecutor(new Command_Kopf());

        this.getCommand("chatclear").setExecutor(new Command_ChatClear());
        this.getCommand("cc").setExecutor(new Command_ChatClear());
        this.getCommand("gversion").setExecutor(new Command_Version());
        this.getCommand("tc").setExecutor(new Command_TeamChat());
        this.getCommand("spy").setExecutor(new Command_Spy());
        this.getCommand("kkick").setExecutor(new Command_Kick());
        this.getCommand("chat").setExecutor(new Command_Chat());
        this.getCommand("ginfo").setExecutor(new Command_Info());

        //get PluginManager
        PluginManager pm = Bukkit.getPluginManager();

        //register Events
        pm.registerEvents(new PlayerSignListener(), this);
        pm.registerEvents(new SignColorEvent(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new PrefixListener(), this);
        pm.registerEvents(new BroadcastListener(), this);
        pm.registerEvents(new PlayerJoinEvent(), this);
        pm.registerEvents(new TeamChatListener(), this);
        pm.registerEvents(new UpperCaseListener(), this);
        pm.registerEvents(new CommandListener(), this);
        pm.registerEvents(new PlusListener(), this);
        pm.registerEvents(new SneakListener(), this);
        pm.registerEvents(new DevLockerListener(), this);
        pm.registerEvents(new FlyListener(), this);

    }



}
