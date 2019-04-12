package com.pluginsx.dungeons.entity.mobs;


import com.pluginsx.dungeons.skulls.SkullCreator;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.EulerAngle;

import com.pluginsx.dungeons.entity.CustomEntity;
import org.bukkit.Bukkit;

public class TestMob extends CustomEntity
{

    private ArmorStand stand;
    private Zombie base;

    private ItemStack head;

    public TestMob(Location loc)
    {
        head = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVjZjk0ZjRiY2JiZjZlYWRjYjI1YWEzZDA2OWFhNjc4ZWJkYjUyNDFlYjgyZThlMjY4ODljYWYzMjc1NTcwIn19fQ==");

        base = (Zombie) loc.getWorld().spawn(loc, Zombie.class);
        base.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
        base.setBaby(true);
        base.setShouldBurnInDay(false);
        base.setCanPickupItems(false);
        base.setSilent(true);

        stand = (ArmorStand) loc.getWorld().spawn(loc, ArmorStand.class);
        stand.setGravity(false);
        stand.setVisible(false);
        stand.setHelmet(head);
        stand.setInvulnerable(true);

    }

    public void update()
    {
        Location b = base.getLocation().clone();
        b.add(0.0, -1.4, 0.0);
        stand.teleport(b);
    }

    public String getName()
    {
        return null;
    }

    public String getFile()
    {
        return null;
    }

    public boolean isDead()
    {
        return base.getHealth() <= 0 || base.isDead() || base == null || stand == null;
    }

    public void kill()
    {
        stand.remove();
    }
}
