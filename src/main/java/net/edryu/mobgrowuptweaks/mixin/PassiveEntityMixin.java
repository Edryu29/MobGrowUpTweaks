package net.edryu.mobgrowuptweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.edryu.mobgrowuptweaks.MobGrowUpTweaksMain;
import net.minecraft.entity.passive.PassiveEntity;

@Mixin(PassiveEntity.class)
public abstract class PassiveEntityMixin{
	
	@ModifyConstant(
		method = "initialize(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/LocalDifficulty;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/EntityData;)Lnet/minecraft/entity/EntityData;", 
		constant = @Constant(intValue = -24000)
	)
	private int setAgeWild(int value) {
		return -1 * MobGrowUpTweaksMain.CONFIG.AnimalSpawnedGrowUpTime;
	}

	@ModifyConstant(
		method = "setBaby(Z)V", 
		constant = @Constant(intValue = -24000)
	)
	private int setAgeBreed(int value) {
		return -1 * MobGrowUpTweaksMain.CONFIG.AnimalBredGrowUpTime;
	}

}
