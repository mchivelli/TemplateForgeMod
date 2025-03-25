package com.lothrazar.examplemod;

import com.lothrazar.library.config.ConfigTemplate;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

/* [Guide: ConfigManager.java handles your mod’s configuration settings.
   - It uses ForgeConfigSpec to create a configuration file that users can modify.
   - The static block initializes the configuration options.
   - "TESTING" is an example boolean option. You can add more options following this pattern.
   - The constructor loads the configuration for the mod using the setup method.
   - IMPORTANT: Do not modify the builder(), push(), pop(), and build() steps as they are crucial for proper configuration initialization.
] */
public class ConfigManager extends ConfigTemplate {

  private static ForgeConfigSpec CONFIG;
  public static BooleanValue TESTING;
  static {
    final ForgeConfigSpec.Builder BUILDER = builder();
    // [Guide: Define a new configuration category for your mod settings using your mod ID.]
    BUILDER.comment("Mod settings").push(ModMain.MODID);
    // [Guide: Define a boolean configuration option named "doesNothing". Its default value is true.]
    TESTING = BUILDER.comment("Testing boolean config").define("doesNothing", true);
    // [Guide: End the configuration category. Every push must be followed by a pop.]
    BUILDER.pop(); // one pop for every push
    // [Guide: Build the complete configuration specification.]
    CONFIG = BUILDER.build();
  }

  public ConfigManager() {
    // [Guide: Load and apply the configuration using the setup method from ConfigTemplate.]
    CONFIG.setConfig(setup(ModMain.MODID));
  }
}
