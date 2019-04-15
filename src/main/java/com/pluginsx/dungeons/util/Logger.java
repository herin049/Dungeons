package com.pluginsx.dungeons.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {

    public static void debug(String str) {
        log("&3[&aDEBUG&3]&d " + str);
    }

    public static void info(String str) {
        log("&e" + str);
    }

    public static void warn(String str) {
        log("&6" + str);
    }

    public static void error(String str) {
        log("&c" + str);
    }

    private static void log(String str) {
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "&e[&3Dungeons&e]&r " + str + "&r")
        );
    }
}
