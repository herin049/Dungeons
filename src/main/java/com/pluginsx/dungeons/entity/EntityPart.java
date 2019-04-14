package com.pluginsx.dungeons.entity;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class EntityPart
{
    private Slime bounding;
    private ArmorStand part;
    private ItemStack part_item;
    private Vector position;

    public EntityPart(Vector pos, Location loc, ItemStack item)
    {
        part = (ArmorStand) loc.getWorld().spawn(loc, ArmorStand.class);
        part.setGravity(false);
        part.setVisible(false);
        part.setHelmet(item);
        part.setInvulnerable(true);
        part.setCollidable(false);

        bounding = (Slime) loc.getWorld().spawn(loc, Slime.class);
        bounding.setSize(2);
        bounding.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
        bounding.setAI(false);
        bounding.setSilent(true);
        bounding.setCollidable(false);

        position = pos;
    }

    public Slime getSlime()
    {
        return bounding;
    }

    public Vector getPosition()
    {
        return position;
    }

    public Location getLocation()
    {
        return part.getLocation();
    }

    public void updateLocation(double x, double y, double z, float yaw)
    {
        Location current_bounding = bounding.getLocation().clone();

        current_bounding.setX(x);
        current_bounding.setY(y);
        current_bounding.setZ(z);

        current_bounding.setYaw(yaw);

        bounding.teleport(current_bounding);

        current_bounding.setY(y - 1.4);

        part.teleport(current_bounding);
    }

    public void killPart()
    {
        part.remove();
        bounding.remove();
    }

}
