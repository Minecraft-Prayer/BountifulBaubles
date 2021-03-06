package cursedflames.bountifulbaubles.common.datagen.loot;

import java.util.Map.Entry;

import cursedflames.bountifulbaubles.common.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.ConstantRange;
import net.minecraft.world.storage.loot.EmptyLootEntry;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTable.Builder;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraft.world.storage.loot.RandomValueRange;

public class LootTablesChests extends BaseLootTableProvider<ResourceLocation> {
	public LootTablesChests(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}

	@Override
	protected void addTables() {
		lootTables.put(LootTables.CHESTS_SIMPLE_DUNGEON, new LootTable.Builder()
				.addLootPool(LootPool.builder()
						.rolls(ConstantRange.of(1))
						.acceptCondition(RandomChance.builder(0.35f))
						.addEntry(ItemLootEntry.builder(ModItems.balloon)
								.weight(10))
						.addEntry(ItemLootEntry.builder(ModItems.shield_cobalt)
								.weight(10))
						.addEntry(ItemLootEntry.builder(ModItems.magic_mirror)
								.weight(10))
						.addEntry(ItemLootEntry.builder(ModItems.lucky_horseshoe)
								.weight(10))
						.addEntry(ItemLootEntry.builder(ModItems.broken_heart)
								.weight(10))
						.addEntry(ItemLootEntry.builder(ModItems.sunglasses)
								.weight(10))
						.addEntry(ItemLootEntry.builder(ModItems.amulet_cross)
								.weight(10))
						.addEntry(ItemLootEntry.builder(ModItems.broken_black_dragon_scale)
								.weight(3))
						.addEntry(ItemLootEntry.builder(ModItems.amulet_sin_empty)
								.weight(3)))
				.addLootPool(LootPool.builder()
						.rolls(new RandomValueRange(1, 6))
						.acceptCondition(RandomChance.builder(0.75f))
						.addEntry(EmptyLootEntry.func_216167_a()
								.weight(25))
						.addEntry(ItemLootEntry.builder(ModItems.potion_recall)
								.weight(50))
						.addEntry(ItemLootEntry.builder(ModItems.potion_recall) //FIXME change to wormhole
								.weight(25))));
		
	}

	@Override
	protected ResourceLocation getResourceLocation(Entry<ResourceLocation, Builder> entry) {
		return entry.getKey();
	}

	@Override
	protected LootTable getLootTable(Entry<ResourceLocation, Builder> entry) {
		return entry.getValue().setParameterSet(LootParameterSets.CHEST).build();
	}
}
