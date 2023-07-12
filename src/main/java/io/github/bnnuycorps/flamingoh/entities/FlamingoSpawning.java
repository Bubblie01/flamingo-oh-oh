package io.github.bnnuycorps.flamingoh.entities;

import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectionContext;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;

public class FlamingoSpawning {
	public static void addSpawnEntries() {
		BiomeModifications.addSpawn(
			BiomeSelectors.spawnsOneOf(EntityType.FROG),
			SpawnGroup.AMBIENT,
			FlamingoEntity.FLAMINGO_ENTITY_TYPE,
			17, 4,8);
		SpawnRestriction.register(FlamingoEntity.FLAMINGO_ENTITY_TYPE, SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING, FlamingoEntity::canSpawn);
	}
}
