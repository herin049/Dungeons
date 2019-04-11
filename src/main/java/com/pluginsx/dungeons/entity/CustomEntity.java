package com.pluginsx.dungeons.entity;

import org.bukkit.Bukkit;

public class CustomEntity

{
    private String name = "Null";
    private String file = "Null.txt";

    public CustomEntity(double x, double y, double z)
    {
        Bukkit.getConsoleSender().sendMessage("Summoning entity: " + name +
        " using data from: " + file);
    }

    void update()
    {

    }



}
