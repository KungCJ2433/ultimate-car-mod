package de.maxhenkel.car.items;

import de.maxhenkel.car.Main;
import de.maxhenkel.tools.ItemTools;
import de.maxhenkel.car.ModCreativeTabs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;

public class ItemCanolaCake extends Item {

    public ItemCanolaCake() {
        super(new Item.Properties().group(ModCreativeTabs.TAB_CAR));
        setRegistryName(new ResourceLocation(Main.MODID, "canola_cake"));

    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        if (!(target instanceof AnimalEntity)) {
            return super.itemInteractionForEntity(stack, playerIn, target, hand);
        }

        AnimalEntity animal = (AnimalEntity) target;

        if (!animal.isBreedingItem(new ItemStack(Items.WHEAT))) {
            return super.itemInteractionForEntity(stack, playerIn, target, hand);
        }

        if (stack == null) {
            return super.itemInteractionForEntity(stack, playerIn, target, hand);
        }

        if (animal.getGrowingAge() == 0 && !animal.isInLove()) {
            ItemTools.decrItemStack(stack, playerIn);
            animal.setInLove(playerIn);
            return true;
        }

        if (animal.isChild()) {
            ItemTools.decrItemStack(stack, playerIn);
            animal.ageUp((int) ((float) (-animal.getGrowingAge() / 20) * 0.1F), true);
            return true;
        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }

}