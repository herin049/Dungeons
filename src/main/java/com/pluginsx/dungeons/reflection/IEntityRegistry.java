package com.pluginsx.dungeons.reflection;
import com.pluginsx.dungeons.reflection.v1_13_2.Registry;
import com.pluginsx.dungeons.util.Logger;
import net.minecraft.server.v1_13_R2.Entity;
import net.minecraft.server.v1_13_R2.EntityTypes;
import net.minecraft.server.v1_13_R2.World;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface IEntityRegistry {
    Map<String,IEntityRegistry> versionRegistry = new HashMap<String,IEntityRegistry>()
    {
        {
            put("1_13_2_R2",new Registry());
        }
    };

    //We cant have generic constraints because that would require importing each package in for each NMS version
    public EntityTypes load(
            String name,
            Class<? extends Entity> clazz,
            Function<? super World,? extends Entity> constructor
    );

    public void unload(
            Class clazz
    );

    static IEntityRegistry getRegistry()
    {
        final String version = Bukkit.getServer().getClass().getPackage()
                .getName().replace(".", ",").split(",")[3];
        Logger.debug(version);

        return versionRegistry.get(version);
    }
}
