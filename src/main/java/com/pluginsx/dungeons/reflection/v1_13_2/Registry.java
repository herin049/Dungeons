package com.pluginsx.dungeons.reflection.v1_13_2;

import com.mojang.datafixers.types.Type;
import com.pluginsx.dungeons.reflection.IEntityRegistry;
import com.pluginsx.dungeons.util.Logger;
import net.minecraft.server.v1_13_R2.*;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

public class Registry implements IEntityRegistry {

    static {
        try {
            Field entityClass = EntityTypes.class.getDeclaredField("aS");
            entityClass.setAccessible(true);
            Field entityFunction = EntityTypes.class.getDeclaredField("aT");
            entityFunction.setAccessible(true);
        } catch (NoSuchFieldException ignored) {
        }
    }

    @Override
    public EntityTypes load(String name, Class<? extends Entity> clazz, Function<? super World, ? extends Entity> constructor) {
        Map<Object, Type<?>> dataTypes = (Map<Object, Type<?>>) DataConverterRegistry.a().getSchema(15190).findChoiceType(DataConverterTypes.n).types();
        EntityTypes type = EntityTypes.a(name, EntityTypes.a.a(clazz, constructor));
        Logger.info(String.format("Added Entity %s into the registry",name));
        return type;
    }

    @Override
    public void unload(Class clazz) {

    }
}
