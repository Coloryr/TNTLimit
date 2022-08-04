package coloryr.tntlimit;

import coloryr.tntlimit.config.ConfigOBJ;
import coloryr.tntlimit.side.ISide;
import coloryr.tntlimit.side.IMyLogger;
import com.google.gson.Gson;
import org.bukkit.Material;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public class TNTLimit {
    public final static String NAME = "TNTLimit";
    public final static String NAME_LOW = "tntlimit";
    public final static String COMMAND = "tnt";
    public final static String Version = "1.0.0";
    public static ConfigOBJ config;
    public static ISide side;
    public static IMyLogger log;
    private static File fileName;

    public static Set<Material> blocks = new HashSet<>();

    public static void load() {
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
            BufferedReader bf = new BufferedReader(reader);
            config = new Gson().fromJson(bf, ConfigOBJ.class);
            if (config == null || config.check()) {
                config = new ConfigOBJ();
                warning("§c配置文件出错，已覆盖");
                save();
            }
            for (String item : config.Blocks) {
                Material material = Material.matchMaterial(item);
                if (material != null && material.isBlock()) {
                    blocks.add(material);
                }
            }
        } catch (Exception e) {
            warning("配置文件读取发生错误");
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            String data = new Gson().toJson(config);
            if (fileName.exists()) {
                FileOutputStream out = new FileOutputStream(fileName);
                OutputStreamWriter write = new OutputStreamWriter(
                        out, StandardCharsets.UTF_8);
                write.write(data);
                write.close();
                out.close();
            }
        } catch (Exception e) {
            warning("配置文件保存错误");
            e.printStackTrace();
        }
    }

    public static void info(String str) {
        log.info("[" + NAME + "]" + str);
    }

    public static void warning(String str) {
        log.warning("[" + NAME + "]" + str);
    }

    public static void start() {
        info("已启动-" + TNTLimit.Version);
    }

    public static void stop() {
        info("已停止，感谢使用");
    }

    public void init(File file) {
        try {
            info("正在启动，感谢使用，本插件交流群：571239090");
            if (fileName == null) {
                fileName = new File(file, "config.json");
                if (!file.exists()) {
                    file.mkdir();
                }
            }
            if (!fileName.exists()) {
                Files.copy(this.getClass().getResourceAsStream("/config.json"), fileName.toPath());
            }
            load();
        } catch (Exception e) {
            info("配置文件初始化错误");
            e.printStackTrace();
        }
    }
}