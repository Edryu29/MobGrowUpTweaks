package net.edryu.mobgrowuptweaks;

import net.fabricmc.api.ModInitializer;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class MobGrowUpTweaksMain implements ModInitializer {
    public static MobGrowUpTweaksConfig CONFIG = new MobGrowUpTweaksConfig();

	@Override
	public void onInitialize() {
        AutoConfig.register(MobGrowUpTweaksConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MobGrowUpTweaksConfig.class).getConfig();
	}
}