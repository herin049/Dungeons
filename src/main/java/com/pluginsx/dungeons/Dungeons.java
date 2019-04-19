package com.pluginsx.dungeons;

import com.pluginsx.dungeons.commands.CommandManager;
import com.pluginsx.dungeons.entity.CustomEntity;
import com.pluginsx.dungeons.entity.nmsmobs.BoundingBox;
import com.pluginsx.dungeons.handlers.AttackHandler;
import com.pluginsx.dungeons.util.MobRegistry;
import net.minecraft.server.v1_13_R2.EntitySlime;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;

public final class Dungeons extends JavaPlugin
{
    public LinkedList<CustomEntity> entities;


    @Override
    public void onEnable()
    {

        new MobRegistry().registerEntity("BoundingBox", 55, EntitySlime.class, BoundingBox.class);

        PluginManager pluginmanager = getServer().getPluginManager();

        pluginmanager.registerEvents(new AttackHandler(this), this);

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
        for(int i = 0; i < entities.size(); i++)
        {
            entities.get(i).kill();
        }
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
