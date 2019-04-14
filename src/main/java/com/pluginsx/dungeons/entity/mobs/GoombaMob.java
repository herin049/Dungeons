package com.pluginsx.dungeons.entity.mobs;

import com.pluginsx.dungeons.entity.CustomEntity;
import com.pluginsx.dungeons.skulls.SkullCreator;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootTables;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class GoombaMob extends CustomEntity
{

    private ArmorStand stand;
    private Zombie base;
    private Slime bounding;

    private ItemStack head;

    public GoombaMob(Location loc)
    {
        head = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVjZjk0ZjRiY2JiZjZlYWRjYjI1YWEzZDA2OWFhNjc4ZWJkYjUyNDFlYjgyZThlMjY4ODljYWYzMjc1NTcwIn19fQ==");

        bounding = (Slime) loc.getWorld().spawn(loc, Slime.class);
        bounding.setSize(2);
        bounding.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
        bounding.setAI(false);
        bounding.setSilent(true);


        base = (ZombieVillager) loc.getWorld().spawn(loc, ZombieVillager.class);
        base.setCanPickupItems(false);
        base.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
        base.setBaby(true);
        base.setShouldBurnInDay(false);
        base.setSilent(true);
        base.setLootTable(LootTables.EMPTY.getLootTable());

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
        bounding.teleport(base.getLocation());
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
        base.remove();
        bounding.remove();
        stand.remove();
    }

    public boolean hasSlime(Slime slime)
    {
        return slime == bounding;
    }

    public void applyVelocity(Vector vel)
    {
        double magnifier = 0.75;

        double dx = vel.getX() - base.getLocation().getX();
        double dy = vel.getY() - base.getLocation().getY();
        double dz = vel.getZ() - base.getLocation().getZ();

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
