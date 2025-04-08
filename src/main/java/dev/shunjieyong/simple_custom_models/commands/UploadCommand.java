package dev.shunjieyong.simple_custom_models.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.net.URI;
import java.util.UUID;

public class UploadCommand extends BaseCommand {
  @Override
  public int execute(CommandContext<ServerCommandSource> context) {
    UUID uuid = UUID.randomUUID();
    String uuidAsString = uuid.toString();

    Text uploadText = buildUploadText(uuidAsString);
    context.getSource().sendMessage(uploadText);
    return 1;
  }

  private Text buildUploadText(String uuidAsString) {
    URI filebinURI = URI.create("https://filebin.net/" + uuidAsString);
    return Text.literal("Click ").append(Text.literal("here").styled(style -> style.withBold(true)
        .withUnderline(true)
        .withColor(Formatting.GREEN)
        .withHoverEvent(new HoverEvent.ShowText(Text.literal(filebinURI.toString())))
        .withClickEvent(new ClickEvent.OpenUrl(filebinURI))))
        .append(Text.literal(" to upload files."))
        .append(Text.literal("\n"))
        .append(Text.literal("Click ").append(Text.literal("here").styled(style -> style.withBold(true)
            .withUnderline(true)
            .withColor(Formatting.GREEN)
            .withHoverEvent(new HoverEvent.ShowText(Text.literal("Download to server.")))
            .withClickEvent(new ClickEvent.RunCommand("download " + uuidAsString)))))
        .append(Text.literal(" once you have uploaded all your files."));
  }
}
