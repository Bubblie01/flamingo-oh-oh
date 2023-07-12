package io.github.bnnuycorps.flamingoh;

import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import io.github.bnnuycorps.flamingoh.entities.FlamingoSpawning;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "flamingoh";
	@Override
	public void onInitialize(ModContainer mod) {
		FlamingoEntity.registerFlamingoEntityAttributes();
		FlamingohRegistry.registerItems();
		FlamingohRegistry.registerStatusEffects();
		FlamingohRegistry.registerSounds();
		FlamingoSpawning.addSpawnEntries();

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if(LootTables.FISHING_GAMEPLAY.equals(id)) {
				tableBuilder.modifyPools(poolBuilder -> poolBuilder.with(ItemEntry.builder(FlamingohRegistry.SHRIMP_ITEM).weight(25)));
			}
		});
	}
}
