package com.pluginsx.dungeons.handlers;

import com.pluginsx.dungeons.Dungeons;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

public class AttackHandler implements Listener
{
    private final Dungeons dungeons;

    public AttackHandler(Dungeons instance)
    {
        dungeons = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
    {
        if(event.getEntity() instanceof Slime && event.getEntity().isSilent() && !((Slime) event.getEntity()).hasAI())
        {
            for(int i = 0; i < dungeons.entities.size(); i++)
            {
                if(dungeons.entities.get(i).hasSlime((Slime)event.getEntity()))
                {
                    System.out.println(event.getEntity().isInvulnerable());
                    event.setCancelled(true);

                    double dx = event.getEntity().getLocation().getX() - event.getDamager().getLocation().getX();
                    double dy = event.getEntity().getLocation().getY() - event.getDamager().getLocation().getY();
                    double dz = event.getEntity().getLocation().getZ() - event.getDamager().getLocation().getZ();

                    double mag = Math.sqrt(dx * dx + dy * dy + dz * dz);

                    dungeons.entities.get(i).applyVelocity(new Vector(dx/mag, dy/mag, dz/mag));
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onEntityDamage(EntityDamageEvent event)
    {
        if(event.getEntity() instanceof Slime && event.getEntity().isSilent() && !((Slime) event.getEntity()).hasAI())
        {
            for(int i = 0; i < dungeons.entities.size(); i++)
            {
                if(dungeons.entities.get(i).hasSlime((Slime)event.getEntity()))
                {
                    event.setCancelled(true);
                }
            }
        }
    }

}
