package io.github.bnnuycorps.flamingoh;

import io.github.bnnuycorps.flamingoh.effects.ShrimpStatusEffect;
import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import io.github.bnnuycorps.flamingoh.items.FlamingoEggItem;
import io.github.bnnuycorps.flamingoh.items.ShrimpItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class FlamingohRegistry {

	public static final Identifier SHRIMP_EFFECT_TEXTURE = new Identifier(Main.MOD_ID, "textures/effects/shrimp_effect.png");

	public static final Item FLAMINGO_SPAWN_EGG = new SpawnEggItem
		(FlamingoEntity.FLAMINGO_ENTITY_TYPE,0xF87C65, 0xFECEC8, new Item.Settings());

	private static final FoodComponent SHRIMP_COMPONENT = new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).build();
	public static final Item FLAMINGO_COCKTAIL = new MushroomStewItem(new Item.Settings());
	public static final Item SHRIMP_ITEM = new ShrimpItem(new Item.Settings().food(SHRIMP_COMPONENT));

	public static final Item SUSPICIOUS_CHICKEN = new Item(new Item.Settings().food(FoodComponents.CHICKEN));
	public static final Item COOKED_SUSPICIOUS_CHICKEN = new Item(new Item.Settings().food(FoodComponents.COOKED_CHICKEN));

	public static final Item PINK_FEATHER = new Item(new Item.Settings());
	public static final Item FLAMINGO_EGG_ITEM = new FlamingoEggItem(new Item.Settings());

	public static final StatusEffect SHRIMP_STATUS_EFFECT = new ShrimpStatusEffect();

	public static final Identifier FLAMINGO_AMBIENT_SOUND_ID = new Identifier(Main.MOD_ID, "flamingo_ambient");
	public static final SoundEvent FLAMINGO_AMBIENT_SOUND_EVENT = SoundEvent.createVariableRangeEvent(FLAMINGO_AMBIENT_SOUND_ID);

	public static final Identifier FLAMINGO_HURT_SOUND_ID = new Identifier(Main.MOD_ID, "flamingo_hurt");
	public static final SoundEvent FLAMINGO_HURT_SOUND_EVENT = SoundEvent.createVariableRangeEvent(FLAMINGO_HURT_SOUND_ID);
	public static void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "shrimp_cocktail"), FLAMINGO_COCKTAIL);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "pink_feather"), PINK_FEATHER);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "flamingo_egg"), FLAMINGO_EGG_ITEM);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "shrimp"), SHRIMP_ITEM);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "flamingo_spawn_egg"), FLAMINGO_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "suspicious_chicken"), SUSPICIOUS_CHICKEN);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "cooked_suspicious_chicken"), COOKED_SUSPICIOUS_CHICKEN);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(entries -> entries.addAfter(
			Items.RABBIT_STEW, FLAMINGO_COCKTAIL));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(
			Items.EGG, FLAMINGO_EGG_ITEM));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(entries -> entries.addAfter(
			Items.COOKED_CHICKEN, SUSPICIOUS_CHICKEN, COOKED_SUSPICIOUS_CHICKEN));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(entries -> entries.addAfter(
			Items.RABBIT_STEW, FLAMINGO_COCKTAIL));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(entries -> entries.addAfter(
			Items.PUFFERFISH, SHRIMP_ITEM));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(
			Items.FEATHER, PINK_FEATHER));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addAfter(
			Items.ALLAY_SPAWN_EGG, FLAMINGO_SPAWN_EGG));
	}

	public static void registerStatusEffects() {
		Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.MOD_ID, "shrimp_effect"), SHRIMP_STATUS_EFFECT);
	}

	public static void registerSounds() {
		Registry.register(Registries.SOUND_EVENT, FLAMINGO_AMBIENT_SOUND_ID, FLAMINGO_AMBIENT_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, FLAMINGO_HURT_SOUND_ID, FLAMINGO_HURT_SOUND_EVENT);
	}
}
