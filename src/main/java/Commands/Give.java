package Commands;

import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Ataloumpak on 26/08/2017.
 */
public class Give extends CommandBase {

    @Override
    public String getName() {
        return "giveall";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "macommande.help";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

    }


}
