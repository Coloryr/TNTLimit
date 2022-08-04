package coloryr.tntlimit.side.sideBukkit;

import coloryr.tntlimit.command.CommandEX;
import coloryr.tntlimit.command.CommandTab;
import coloryr.tntlimit.TNTLimit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class CommandBukkit implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase(TNTLimit.COMMAND)) {
            CommandEX.Ex(sender, sender.getName(), args, sender.isOp());
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase(TNTLimit.COMMAND)) {
            return CommandTab.getList(sender.isOp(), args);
        }
        return null;
    }
}
