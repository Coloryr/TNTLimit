package coloryr.tntlimit.side.sideBukkit;

import coloryr.tntlimit.TNTLimit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;
import java.util.List;

public class EventBukkit implements Listener {
    @EventHandler
    public void onEntityExplodeEvent(EntityExplodeEvent event) {
        if (event.isCancelled())
            return;
        List<Block> list = event.blockList();
        List<Block> remove = new ArrayList<>(list);
        list.clear();
        for (Block item : remove) {
            if (TNTLimit.blocks.contains(item.getType())) {
                list.add(item);
            }
        }
    }
}