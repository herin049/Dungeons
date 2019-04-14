package com.pluginsx.dungeons.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Slime;
import org.bukkit.util.Vector;


public  abstract class CustomEntity

{

    public CustomEntity() { }

    public abstract void update();

    public abstract String getName();

    public abstract String getFile();

    public abstract boolean isDead();

    public abstract void kill();

    public abstract boolean hasSlime(Slime slime);

    public abstract void applyVelocity(Vector vel);

    public abstract void damage(double dmg);


}
