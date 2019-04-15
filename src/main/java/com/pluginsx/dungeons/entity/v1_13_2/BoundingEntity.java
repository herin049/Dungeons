package com.pluginsx.dungeons.entity.v1_13_2;

import com.pluginsx.dungeons.entity.IBoundingEntity;
import com.pluginsx.dungeons.reflection.IEntityRegistry;
import net.minecraft.server.v1_13_R2.*;

public class BoundingEntity extends EntityLiving implements IBoundingEntity {

    private static final EntityTypes<BoundingEntity> BOUNDING_ENTITY =
            IEntityRegistry.getRegistry().load("bounding_box",BoundingEntity.class,BoundingEntity::new);

    public BoundingEntity(World world) {
        super(BOUNDING_ENTITY, world);
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
