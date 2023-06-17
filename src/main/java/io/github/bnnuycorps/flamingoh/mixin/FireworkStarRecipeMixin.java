package io.github.bnnuycorps.flamingoh.mixin;

import com.google.common.collect.Maps;
import io.github.bnnuycorps.flamingoh.FlamingohRegistry;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.FireworkStarRecipe;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(FireworkStarRecipe.class)
public class FireworkStarRecipeMixin {

	@Shadow @Final
	static
	Map<Item, FireworkRocketItem.Type> TYPE_MODIFIERS;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void flamingoh$_pinkFeatherRecipe(CallbackInfo ci) {
		TYPE_MODIFIERS.put(FlamingohRegistry.PINK_FEATHER, FireworkRocketItem.Type.BURST);
	}
}
