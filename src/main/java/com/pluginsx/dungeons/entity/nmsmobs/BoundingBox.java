package com.pluginsx.dungeons.entity.nmsmobs;

import com.pluginsx.dungeons.entity.CustomEntity;
import net.minecraft.server.v1_13_R2.*;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class BoundingBox extends EntitySlime
{
    private CustomEntity parent;

    public BoundingBox(World world)
    {
        super(world);
    }

    private void setParentObject(CustomEntity parentObject)
    {
        parent = parentObject;
    }

    @Override
    public Item getLoot()
    {
        return null;
    }

    @Override
    public boolean damageEntity(DamageSource damagesource, float f)
    {

        return false;
    }


    public static Slime spawn(Location location, CustomEntity parent, int size)
    {
        World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
        final BoundingBox customEntity = new BoundingBox(mcWorld);
        customEntity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);

        customEntity.setNoAI(true);
        customEntity.setNoGravity(true);

        customEntity.setSize(size, false);
        customEntity.setParentObject(parent);


        return (Slime) customEntity.getBukkitEntity();
    }
}
