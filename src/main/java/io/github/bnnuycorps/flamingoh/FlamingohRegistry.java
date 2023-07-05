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
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.recipe.api.RecipeManagerHelper;
import org.quiltmc.qsl.recipe.api.builder.VanillaRecipeBuilders;

public class FlamingohRegistry {

	public static final Identifier SHRIMP_EFFECT_TEXTURE = new Identifier(Main.MOD_ID, "textures/effects/shrimp_effect.png");
	public static final Item FLAMINGO_SPAWN_EGG = new SpawnEggItem(FlamingoEntity.FLAMINGO_ENTITY_TYPE,0xF87C65,
			0xFECEC8, new Item.Settings());
	private static final FoodComponent SHRIMP_COMPONENT = new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).build();
	public static final Item FLAMINGO_COCKTAIL = new MushroomStewItem(new Item.Settings());
	public static final Item PINK_FEATHER = new Item(new Item.Settings());
	public static final Item FLAMINGO_EGG_ITEM = new FlamingoEggItem(new Item.Settings());
	public static final Item SHRIMP_ITEM = new ShrimpItem(new Item.Settings().food(SHRIMP_COMPONENT));

	public static final Item SUSPICIOUS_CHICKEN = new Item(new Item.Settings().food(FoodComponents.CHICKEN));

	public static final Item SUSPICIOUS_COOKED_CHICKEN = new Item(new Item.Settings().food(FoodComponents.COOKED_CHICKEN));


	public static final StatusEffect SHRIMP_STATUS_EFFECT = new ShrimpStatusEffect();
	public static void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "shrimp_cocktail"), FLAMINGO_COCKTAIL);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "pink_feather"), PINK_FEATHER);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "flamingo_egg"), FLAMINGO_EGG_ITEM);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "shrimp"), SHRIMP_ITEM);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "flamingo_spawn_egg"), FLAMINGO_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "suspicious_chicken"), SUSPICIOUS_CHICKEN);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "suspicious_cooked_chicken"), SUSPICIOUS_COOKED_CHICKEN);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(content -> {
			content.addItem(FLAMINGO_COCKTAIL);
			content.addItem(FLAMINGO_EGG_ITEM);
			content.addItem(SUSPICIOUS_CHICKEN);
			content.addItem(SUSPICIOUS_COOKED_CHICKEN);
			content.addItem(SHRIMP_ITEM);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addItem(PINK_FEATHER);
		});
	}

	public static void registerRecipies() {

		RecipeManagerHelper.addRecipes(handler -> {
			handler.register(new Identifier(Main.MOD_ID, "arrow_item"),
					id -> VanillaRecipeBuilders.shapedRecipe("X", "#", "Y")
							.ingredient('#', Items.STICK)
							.ingredient('X', Items.FLINT)
							.ingredient('Y', FlamingohRegistry.PINK_FEATHER)
							.output(new ItemStack(Items.ARROW, 4))
							.build(id, "equipment"));
		});
		RecipeManagerHelper.addRecipes(handler -> {
			handler.register(new Identifier(Main.MOD_ID, "writable_book"),
					id -> VanillaRecipeBuilders.shapelessRecipe(Items.WRITABLE_BOOK.getDefaultStack())
							.ingredient(FlamingohRegistry.PINK_FEATHER)
							.ingredient(Items.INK_SAC)
							.ingredient(Items.BOOK)
							.output(new ItemStack(Items.WRITABLE_BOOK))
							.build(id, "misc"));
		});
	}

	public static void registerStatusEffects() {
		Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.MOD_ID, "shrimp_effect"), SHRIMP_STATUS_EFFECT);
	}
}
