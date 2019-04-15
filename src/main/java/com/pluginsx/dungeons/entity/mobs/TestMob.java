package com.pluginsx.dungeons.entity.mobs;


import com.pluginsx.dungeons.entity.EntityPart;
import com.pluginsx.dungeons.math.Rotations;
import com.pluginsx.dungeons.skulls.SkullCreator;
import org.bukkit.*;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.*;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.EulerAngle;

import com.pluginsx.dungeons.entity.CustomEntity;
import org.bukkit.util.Vector;

import java.util.LinkedList;
import java.util.List;

public class TestMob extends CustomEntity
{

    private LinkedList<EntityPart> parts;

    private Zombie base;

    private ItemStack head;

    public TestMob(Location loc)
    {
        parts = new LinkedList<>();

        ItemStack alien_head = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTVmMjdkNDZhZGIzOGZmZWNhMzUxMWZkNWE1MzEzYzg3ZWVmZjc4YTM2OTVmNDQ2YWNlZmVlOTQxY2YyYzIifX19");
        ItemStack slime_head = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzkyMjdmY2FkYzM3NzZkNDI2ZTU2YjU3ODgyZWRjZjliMDhlYTFjZThiYTJhNmRhMmNjY2FjM2U2NWI1In19fQ==");

        head = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVjZjk0ZjRiY2JiZjZlYWRjYjI1YWEzZDA2OWFhNjc4ZWJkYjUyNDFlYjgyZThlMjY4ODljYWYzMjc1NTcwIn19fQ==");

        /*
        parts.add(new EntityPart(new Vector(0,0,0), loc, slime_head, false));
        parts.add(new EntityPart(new Vector(0,0.5,0), loc, slime_head, false));
        parts.add(new EntityPart(new Vector(0,0.85,0), loc, alien_head, true));
        parts.add(new EntityPart(new Vector(0.5,0,0), loc, slime_head, false));
        parts.add(new EntityPart(new Vector(0.5,0.5,0), loc, slime_head, false));
        parts.add(new EntityPart(new Vector(-0.5,0,0), loc, slime_head, false));
        parts.add(new EntityPart(new Vector(-0.5,0.5,0), loc, slime_head, false));
        */

        parts.add(new EntityPart(new Vector(0,0,0), loc, slime_head, false));
        parts.add(new EntityPart(new Vector(0,0.4375,0), loc, slime_head, false));
        parts.add(new EntityPart(new Vector(0,0.875,0), loc, alien_head, true));
        parts.add(new EntityPart(new Vector(0.34375,0.23438,0.28125), loc, slime_head, true));
        parts.add(new EntityPart(new Vector(-0.34375,0.23438,0.28125), loc, slime_head, true));
        parts.add(new EntityPart(new Vector(0.34375,0.51563,0), loc, slime_head, true));
        parts.add(new EntityPart(new Vector(-0.34375,0.51563,0), loc, slime_head, true));

        base = (ZombieVillager) loc.getWorld().spawn(loc, ZombieVillager.class);
        base.setCollidable(false);
        base.setCanPickupItems(false);
        base.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
        base.setBaby(true);
        base.setShouldBurnInDay(false);
        base.setSilent(true);
        base.setLootTable(LootTables.EMPTY.getLootTable());
    }

    public void update()
    {
        Location b = base.getLocation().clone();

        double posx = base.getLocation().getX();
        double posy = base.getLocation().getY();
        double posz = base.getLocation().getZ();

        float yaw = base.getLocation().getYaw();
        for(int i = 0; i < parts.size(); i++)
        {
            double[] newpos = Rotations.rotate(parts.get(i).getPosition().getX(), parts.get(i).getPosition().getZ(), Math.toRadians(yaw));
            parts.get(i).updateLocation(posx + newpos[0], posy + parts.get(i).getPosition().getY(), posz + newpos[1], yaw);
        }

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
        return base.isDead() || base.getHealth() <= 0;
    }

    public void kill()
    {
        base.getLocation().getWorld().spawnParticle(Particle.CRIT_MAGIC, base.getLocation(), 100);
        for(int i = 0; i < parts.size(); i++)
        {
            parts.get(i).killPart();
        }
        base.remove();
    }

    public boolean hasSlime(Slime slime)
    {
        for(int i = 0; i < parts.size(); i++)
        {
            if(parts.get(i).getSlime() == slime)
            {
                return true;
            }
        }
        return false;
    }

    public void applyVelocity(Vector vel)
    {
        double magnifier = 0.75;

        double dx =  base.getLocation().getX() - vel.getX();
        double dy = base.getLocation().getY() - vel.getY();
        double dz = base.getLocation().getZ() - vel.getZ();

        double magnitude = Math.sqrt(dx * dx + dy * dy + dz * dz);

        vel.setX((dx * magnifier)/magnitude);
        vel.setY((dy * magnifier)/magnitude);
        vel.setZ((dz * magnifier)/magnitude);

        base.setVelocity(base.getVelocity().add(vel));
    }

    public void damage(double dmg)
    {
        double currenthealth = base.getHealth();
        base.setHealth(Math.max(currenthealth - dmg, 0));
    }

}
