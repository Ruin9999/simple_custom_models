package dev.shunjieyong.simple_custom_models.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.shunjieyong.simple_custom_models.Simple_custom_models;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
  private final CommandDispatcher<ServerCommandSource> dispatcher;
  private final List<BaseCommand> commandList = new ArrayList<>();

  public CommandRegistry(CommandDispatcher<ServerCommandSource> dispatcher) {
    this.dispatcher = dispatcher;

    // Add commands here.
    this.commandList.add(new UploadCommand());
  }

  public void registerAll() {
    LiteralArgumentBuilder<ServerCommandSource> mainCommand = CommandManager.literal(Simple_custom_models.MOD_NAME);

    commandList.forEach((command) -> mainCommand.then(command.register()));
    dispatcher.register(mainCommand);
  }
}
