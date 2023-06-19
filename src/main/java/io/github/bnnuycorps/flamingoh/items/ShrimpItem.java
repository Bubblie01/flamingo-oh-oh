package io.github.bnnuycorps.flamingoh.items;

import io.github.bnnuycorps.flamingoh.FlamingohRegistry;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ShrimpItem extends Item {

	public ShrimpItem(Settings settings) {
		super(settings);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		PlayerEntity player = (PlayerEntity) user;
		StatusEffectInstance effectInstance = player.getStatusEffect(FlamingohRegistry.FLAMINGO_STATUS_EFFECT);
		int duration = 600;
		if(effectInstance == null) {
			player.addStatusEffect(new StatusEffectInstance(FlamingohRegistry.FLAMINGO_STATUS_EFFECT,duration, 0));
		}
		else {
			int amplifier = effectInstance.getAmplifier();
			if(effectInstance.getAmplifier() < 2) {
				player.addStatusEffect(new StatusEffectInstance(FlamingohRegistry.FLAMINGO_STATUS_EFFECT, duration * 2, amplifier + 1));
			}
		}
		return super.finishUsing(stack, world, user);
	}
}
