package coloryr.tntlimit.side.sideBukkit;

import coloryr.tntlimit.side.ISide;
import org.bukkit.command.CommandSender;

public class SideBukkit implements ISide {
    @Override
    public void send(Object sender, String message) {
        CommandSender temp = (CommandSender) sender;
        temp.sendMessage(message);
    }

}
