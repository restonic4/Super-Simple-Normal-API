package me.restonic4.ssna.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EnchantedBookHelper {
    public static CompoundTag createEnchantedBookCompoundTag(ResourceLocation location, int level) {
        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);

        CompoundTag enchantmentTag = new CompoundTag();
        enchantmentTag.putString("id", location.toString());
        enchantmentTag.putShort("lvl", (short) level);

        ListTag enchantmentsList = new ListTag();
        enchantmentsList.add(enchantmentTag);

        CompoundTag storedEnchantmentsTag = new CompoundTag();
        storedEnchantmentsTag.put("StoredEnchantments", enchantmentsList);

        enchantedBook.setTag(storedEnchantmentsTag);

        return enchantedBook.getOrCreateTag();
    }
}
