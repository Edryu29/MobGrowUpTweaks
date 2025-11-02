package net.edryu.mobgrowuptweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.edryu.mobgrowuptweaks.MobGrowUpTweaksMain;
import net.minecraft.entity.passive.PassiveEntity;

@Mixin(PassiveEntity.class)
public abstract class PassiveEntityMixin{

  @Shadow
  protected int breedingAge;

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

	@Inject(method = "setBreedingAge", at = @At(value = "HEAD"), cancellable = true)
	public void setBreedingAge(int age, CallbackInfo info) {
		PassiveEntity self = ((PassiveEntity) (Object) this);
		if (self.getBreedingAge() < 0 && self.hasCustomName() && MobGrowUpTweaksMain.CONFIG.AlwaysBabyCustomName && age >= 0) {
			this.breedingAge = -1 * MobGrowUpTweaksMain.CONFIG.AnimalBredGrowUpTime;
			info.cancel();
		}
	}

}
