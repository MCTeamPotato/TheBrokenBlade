package com.teampotato.broken_blade;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod("broken_blade")
public class BrokenBlade {
    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec.ConfigValue<String> ITEM;

    static {
        ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
        BUILDER.push("Mowzie's Mobs: The Broken Blade");
        ITEM = BUILDER.define("WroughtnautBackSword", "minecraft:diamond_sword");
        BUILDER.pop();
        CLIENT_CONFIG = BUILDER.build();
    }

    public BrokenBlade() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }
}
