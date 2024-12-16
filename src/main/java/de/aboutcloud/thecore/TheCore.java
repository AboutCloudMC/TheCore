package de.aboutcloud.thecore;

import de.aboutcloud.thecore.commands.PInfoCommand;
import de.aboutcloud.thecore.commands.RankCommand;
import de.aboutcloud.thecore.file.ConfigFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class TheCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().log(Level.ALL, Constants.PREFIX.toString() + "The Core was loaded.");

        //ConfigFile config = new ConfigFile("./config.yml");

        new PInfoCommand(this, "pinfo");
        new RankCommand(this, "rank");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
