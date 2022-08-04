package coloryr.tntlimit.config;

import coloryr.tntlimit.TNTLimit;

import java.util.ArrayList;
import java.util.List;

public class ConfigOBJ {
    public String Version;
    public List<String> Blocks;

    public boolean check() {
        boolean save = false;
        if (Blocks == null) {
            Blocks = new ArrayList<>();
            save = true;
        }
        return save;
    }

    public ConfigOBJ() {
        Version = TNTLimit.Version;
    }

}
