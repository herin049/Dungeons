package com.pluginsx.dungeons.entity.v1_13_2;

import com.pluginsx.dungeons.entity.IFlyingControllerEntity;
import net.minecraft.server.v1_13_R2.*;
import org.bukkit.entity.Flying;

public class FlyingControllerEntity extends EntityLiving implements IFlyingControllerEntity {

    protected FlyingControllerEntity(EntityTypes<?> entitytypes, World world) {
        super(entitytypes, world);
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquipment(EnumItemSlot enumItemSlot) {
        return null;
    }

    @Override
    public void setSlot(EnumItemSlot enumItemSlot, ItemStack itemStack) {

    }

    @Override
    public EnumMainHand getMainHand() {
        return null;
    }
}
