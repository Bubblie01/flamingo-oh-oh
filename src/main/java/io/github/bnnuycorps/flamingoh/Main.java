package io.github.bnnuycorps.flamingoh;

import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "flamingoh";
	@Override
	public void onInitialize(ModContainer mod) {
		FlamingoEntity.registerFlamingoEntityAttributes();
		FlamingohRegistry.registerItems();
		FlamingohRegistry.registerRecipies();
		FlamingohRegistry.registerStatusEffects();
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SWAMP, Biomes.MANGROVE_SWAMP), SpawnGroup.CREATURE, FlamingoEntity.FLAMINGO_ENTITY_TYPE, 15, 4, 4);
		SpawnRestriction.register(FlamingoEntity.FLAMINGO_ENTITY_TYPE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, FlamingoEntity::isValidNaturalSpawn);

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if(LootTables.FISHING_GAMEPLAY.equals(id)) {
				tableBuilder.modifyPools(poolBuilder -> poolBuilder.with(ItemEntry.builder(FlamingohRegistry.SHRIMP_ITEM).weight(25)));
			}
		});
	}
}
