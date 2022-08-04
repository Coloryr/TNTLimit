package coloryr.tntlimit.command;

import coloryr.tntlimit.TNTLimit;

public class CommandEX {

    public static void Ex(Object sender, String name, String[] args, boolean hasPermission) {
        if (args.length == 0) {
            TNTLimit.side.send(sender, "§c错误的指令参数，输入/" + TNTLimit.COMMAND + " help获取帮助");
        } else if (args[0].equalsIgnoreCase("help")) {
        } else if (!hasPermission) {
            TNTLimit.side.send(sender, "§c你没有权限使用该指令");
        } else if (args[0].equalsIgnoreCase("reload")) {
            TNTLimit.load();
            TNTLimit.side.send(sender, "§d配置文件已重读");
        } else if (args[0].equalsIgnoreCase("test")) {
        }
    }
}
