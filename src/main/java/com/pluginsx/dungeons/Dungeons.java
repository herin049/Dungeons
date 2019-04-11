package com.pluginsx.dungeons;

import com.pluginsx.dungeons.entity.CustomEntity;
import org.bukkit.plugin.java.JavaPlugin;

public final class Dungeons extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        CustomEntity f = new CustomEntity(0, 0, 0);
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}
