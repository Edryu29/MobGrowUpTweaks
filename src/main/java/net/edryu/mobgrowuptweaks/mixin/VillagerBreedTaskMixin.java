package net.edryu.mobgrowuptweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.edryu.mobgrowuptweaks.MobGrowUpTweaksMain;
import net.minecraft.entity.ai.brain.task.VillagerBreedTask;

@Mixin(VillagerBreedTask.class)
public abstract class VillagerBreedTaskMixin{

	@ModifyConstant(
		method = "createChild(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/VillagerEntity;Lnet/minecraft/entity/passive/VillagerEntity;)Ljava/util/Optional;", 
		constant = @Constant(intValue = -24000))
	private int injected(int value) {
		return -1 * MobGrowUpTweaksMain.CONFIG.VillagerGrowUpTime;
	}
	
}