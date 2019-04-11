package com.pluginsx.dungeons.entity;

import org.bukkit.Bukkit;

public  abstract class CustomEntity

{

    public CustomEntity()
    {
        Bukkit.getConsoleSender().sendMessage("Summoning entity: " + this.getName() +
        " using data from: " + this.getFile());
    }

    public abstract void update();

    public abstract String getName();

    public abstract String getFile();



}
