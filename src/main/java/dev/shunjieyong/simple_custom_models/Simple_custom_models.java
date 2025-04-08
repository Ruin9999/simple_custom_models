package dev.shunjieyong.simple_custom_models;

import dev.shunjieyong.simple_custom_models.commands.CommandRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Simple_custom_models implements ModInitializer {

  public static final String MOD_NAME = "simplecustommodels";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

  @Override
  public void onInitialize() {
    registerCommands();
  }

  private void registerCommands() {
    CommandRegistrationCallback.EVENT.register(((commandDispatcher, commandRegistryAccess, registrationEnvironment) -> {
      CommandRegistry commandRegistry = new CommandRegistry(commandDispatcher);
      commandRegistry.registerAll();
    }));
  }
}
