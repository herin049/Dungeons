package com.pluginsx.dungeons.entity.mobs;

import com.pluginsx.dungeons.entity.CustomEntity;
import com.pluginsx.dungeons.skulls.SkullCreator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;


public class BeeMob extends CustomEntity
{
    private ArmorStand stand;
    private Bat base;

    private ItemStack head;

    public BeeMob(Location loc)
    {
        head = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQ3MzIyZjgzMWUzYzE2OGNmYmQzZTI4ZmU5MjUxNDRiMjYxZTc5ZWIzOWM3NzEzNDlmYWM1NWE4MTI2NDczIn19fQ==");

        base = (Bat) loc.getWorld().spawn(loc, Bat.class);
        base.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
        base.setSilent(true);


        stand = (ArmorStand)loc.getWorld().spawn(loc, ArmorStand.class);
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

    public boolean hasSlime(Slime slime)
    {
        return false;
    }

    public void applyVelocity(Vector vel)
    {

    }

}
