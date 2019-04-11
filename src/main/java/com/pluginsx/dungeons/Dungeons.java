package com.pluginsx.dungeons;

import com.pluginsx.dungeons.commands.CommandManager;
import com.pluginsx.dungeons.entity.CustomEntity;
import com.pluginsx.dungeons.entity.mobs.TestMob;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.EulerAngle;

import java.util.Iterator;

public final class Dungeons extends JavaPlugin
{



    @Override
    public void onEnable()
    {
        //Initializing command manager
        this.getCommand("dungeons").setExecutor(new CommandManager(this));
        //Test
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
            public void run()
            {
                Dungeons.this.onTick();
            }
        }, 0L, 1L);
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }

    public void onTick()
    {
        Parrot parrot = null;
        ArmorStand head = null;

        for(World w: getServer().getWorlds())
        {
            for(Entity e: w.getEntities())
            {

                if(e.getCustomName() != null && e.getCustomName().equals("taylorsasser1234"))
                {
                    parrot = (Parrot) e;
                }

                if(e.getCustomName() != null && e.getCustomName().equals("taylorsasser1235"))
                {
                    head = (ArmorStand) e;
                }
            }
        }

        if(parrot != null && head != null)
        {
            Location b = parrot.getLocation().clone();
            b.add(0.0, -1.4, 0.0);
            head.teleport(b);
            parrot.setTarget(Bukkit.getPlayer("BigL"));

            //head.setHeadPose(new EulerAngle(0 , parrot.getLocation().getYaw() + 90.0, 0));

        }
    }


}
