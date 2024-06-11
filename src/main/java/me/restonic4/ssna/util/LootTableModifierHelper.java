package me.restonic4.ssna.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNbtFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.Nullable;

public class LootTableModifierHelper {
    public static void modify(ResourceLocation lootTableLocation, Item item, int rolls, float chance, int minAmount, int maxAmount) {
        modify(lootTableLocation, item, null, rolls, chance, minAmount, maxAmount);
    }

    public static void modify(ResourceLocation lootTableLocation, Item item, @Nullable CompoundTag compoundTag, int rolls, float chance, int minAmount, int maxAmount) {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(lootTableLocation.equals(id)) {
                LootPool.Builder poolBuilder;

                if (compoundTag == null) {
                    poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(rolls))
                            .conditionally(LootItemRandomChanceCondition.randomChance(chance).build())
                            .with(LootItem.lootTableItem(item).build())
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(minAmount, maxAmount)).build());
                }
                else {
                    poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(rolls))
                            .conditionally(LootItemRandomChanceCondition.randomChance(chance).build())
                            .with(
                                    LootItem.lootTableItem(item)
                                            .apply(SetNbtFunction.setTag(compoundTag))
                                            .build()
                            )
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(minAmount, maxAmount)).build());
                }

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
