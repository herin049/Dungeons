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
import java.util.LinkedList;

public final class Dungeons extends JavaPlugin
{
    public LinkedList<CustomEntity> entities;


    @Override
    public void onEnable()
    {
        entities = new LinkedList<>();
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

    private void onTick()
    {
        for(int i = 0; i < entities.size(); i++)
        {
            CustomEntity e = entities.get(i);
            if(e != null) {
                if (e.isDead())
                {
                    e.kill();
                    entities.remove(i);
                }
                else
                {
                    e.update();
                }
            }
        }
    }


}
