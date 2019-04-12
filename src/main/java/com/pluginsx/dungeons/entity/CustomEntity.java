package com.pluginsx.dungeons.entity;

import org.bukkit.Bukkit;

public  abstract class CustomEntity

{

    public CustomEntity() { }

    public abstract void update();

    public abstract String getName();

    public abstract String getFile();

    public abstract boolean isDead();

    public abstract void kill();


}
