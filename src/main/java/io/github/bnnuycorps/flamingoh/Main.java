package io.github.bnnuycorps.flamingoh;

import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
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
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.PLAINS), SpawnGroup.CREATURE, FlamingoEntity.FLAMINGO_ENTITY_TYPE, 2, 4, 4);
	}
}
