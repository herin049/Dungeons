package com.pluginsx.dungeons.entity.mobs;


import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Silverfish;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.EulerAngle;

import com.pluginsx.dungeons.entity.CustomEntity;
import org.bukkit.Bukkit;

public class TestMob extends CustomEntity
{

    private String name = "testmob";
    private String file = "testmob.txt";


    public TestMob(double x, double y, double z)
    {
        Bukkit.getConsoleSender().sendMessage("Summoning entity: " + this.getName() +
                " using data from: " + this.getFile());
        Bukkit.getConsoleSender().sendMessage(x +" " + y +" " + z);

    }

    public void update()
    {

    }

    public String getName()
    {
        return name;
    }

    public String getFile()
    {
        return file;
    }
}
