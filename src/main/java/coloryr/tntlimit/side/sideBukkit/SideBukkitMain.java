package coloryr.tntlimit.side.sideBukkit;

import coloryr.tntlimit.TNTLimit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SideBukkitMain extends JavaPlugin {

    public static Plugin plugin;
    public static Logger log_b;

    @Override
    public void onEnable() {
        plugin = this;
        log_b = getLogger();
        TNTLimit.log = new BukkitLog(log_b);
        TNTLimit.side = new SideBukkit();
        new TNTLimit().init(getDataFolder());

        Bukkit.getPluginManager().registerEvents(new EventBukkit(), this);

        Bukkit.getPluginCommand(TNTLimit.COMMAND).setExecutor(new CommandBukkit());
        Bukkit.getPluginCommand(TNTLimit.COMMAND).setTabCompleter(new CommandBukkit());

        TNTLimit.start();
    }

    @Override
    public void onDisable() {
        TNTLimit.stop();
    }
}
