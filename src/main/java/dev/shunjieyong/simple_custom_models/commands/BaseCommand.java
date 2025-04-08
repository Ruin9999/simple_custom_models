package dev.shunjieyong.simple_custom_models.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.shunjieyong.simple_custom_models.Simple_custom_models;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public abstract class BaseCommand {
  public int execute(CommandContext<ServerCommandSource> context) {
    context.getSource().sendMessage(Text.literal("This command has not been implemented."));
    return 0;
  }

  public LiteralArgumentBuilder<ServerCommandSource> register() {
    return CommandManager.literal(getName()).executes(this::execute);
  }

  public String getName() {
    String packageClassName = this.getClass().getName();
    String[] splitClassName = packageClassName.split("\\.");
    String className = splitClassName[splitClassName.length - 1];

    Simple_custom_models.LOGGER.warn(className.substring(0, className.length() - "Command".length()));

    if (className.endsWith("Command")) return className.substring(0, className.length() - "Command".length()).toLowerCase();
    else return className.toLowerCase();
  }
}
