package net.edryu.mobgrowuptweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.edryu.mobgrowuptweaks.MobGrowUpTweaksMain;
import net.minecraft.entity.projectile.thrown.EggEntity;;

@Mixin(EggEntity.class)
public abstract class EggEntityMixin{
    
	@ModifyConstant(
		method = "onCollision(Lnet/minecraft/util/hit/HitResult;)V", 
		constant = @Constant(intValue = -24000)
	)
	private int setAgeBreed(int value) {
		return -1 * MobGrowUpTweaksMain.CONFIG.AnimalBredGrowUpTime;
	}

}
