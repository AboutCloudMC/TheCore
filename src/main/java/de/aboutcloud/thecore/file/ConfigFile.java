package de.aboutcloud.thecore.file;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile {

    private File file;
    private YamlConfiguration cfg;

    public ConfigFile(String path) {
        this.file = new File(path);
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
    }

    public void addDefault(String path, String value) {
        try {
            cfg.options().copyDefaults(true);
            cfg.addDefault(path, value);
            cfg.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() {
        try {
            this.cfg.save(this.file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void set(String path, String value) {
        cfg.set(path, value);
    }

    public String get(String path) {
        return cfg.getString(path);
    }

}
