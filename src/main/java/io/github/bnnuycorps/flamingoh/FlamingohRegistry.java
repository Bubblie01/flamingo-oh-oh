package io.github.bnnuycorps.flamingoh;

import io.github.bnnuycorps.flamingoh.items.FlamingoEggItem;
import io.github.bnnuycorps.flamingoh.items.ShrimpItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.recipe.api.RecipeManagerHelper;
import org.quiltmc.qsl.recipe.api.builder.VanillaRecipeBuilders;

public class FlamingohRegistry {

	public static final Item FLAMINGO_COCKTAIL = new MushroomStewItem(new Item.Settings());
	public static final Item PINK_FEATHER = new Item(new Item.Settings());
	public static final Item FLAMINGO_EGG_ITEM = new FlamingoEggItem(new Item.Settings());
	public static final Item SHRIMP_ITEM = new ShrimpItem(new Item.Settings());
	public static void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "shrimp_cocktail"), FLAMINGO_COCKTAIL);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "pink_feather"), PINK_FEATHER);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "flamingo_egg"), FLAMINGO_EGG_ITEM);
		Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, "shrimp"), SHRIMP_ITEM);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(content -> {
			content.addItem(FLAMINGO_COCKTAIL);
			content.addItem(FLAMINGO_EGG_ITEM);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addItem(PINK_FEATHER);
		});
	}

	public static void registerRecipies() {
		/*
		RecipeManagerHelper.modifyRecipes(handler -> {
			handler.replace(VanillaRecipeBuilders.shapedRecipe(new ItemStack(Items.ARROW)).ingredient());
		});

		 */
	}
}
