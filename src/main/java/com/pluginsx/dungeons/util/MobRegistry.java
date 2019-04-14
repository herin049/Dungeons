package com.pluginsx.dungeons.util;

import com.mojang.datafixers.types.Type;
import net.minecraft.server.v1_13_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

public class MobRegistry
{
    private static Field entityClass;
    private static Field entityFunction;
    private static Method biomebase_addSpawn;

    static {
        try {
            entityClass = EntityTypes.class.getDeclaredField("aS");
            entityClass.setAccessible(true);
            entityFunction = EntityTypes.class.getDeclaredField("aT");
            entityFunction.setAccessible(true);
            biomebase_addSpawn = BiomeBase.class.getDeclaredMethod("a", EnumCreatureType.class, BiomeBase.BiomeMeta.class);
            biomebase_addSpawn.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException ignore) {
        }
    }

    public static void injectNewEntityTypes(String name, String extend_from, Class<? extends Entity> clazz, Function<? super World, ? extends Entity> function) {
        Map<Object, Type<?>> dataTypes = (Map<Object, Type<?>>) DataConverterRegistry.a().getSchema(15190).findChoiceType(DataConverterTypes.n).types();
        dataTypes.put("minecraft:" + name, dataTypes.get("minecraft:" + extend_from));
        EntityTypes.a(name, EntityTypes.a.a(clazz, function));
        System.out.println("Successfully injected new entity: &a" + name);
    }

}
