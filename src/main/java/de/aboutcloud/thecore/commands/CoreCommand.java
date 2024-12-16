package de.aboutcloud.thecore.commands;

import de.aboutcloud.thecore.Constants;
import de.aboutcloud.thecore.TheCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class CoreCommand implements CommandExecutor {

    private @NotNull String command;
    private TheCore instance;

    public CoreCommand(TheCore instance, String command) {
        this.command = command;
        this.instance = instance;
        instance.getCommand(this.command).setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        boolean isPlayer = false;
        if(!label.equalsIgnoreCase(this.command)) {
            sender.sendMessage(Constants.PREFIX + "Test");
            return false;
        }
        if(sender instanceof Player) {
            isPlayer = true;
        }
        return execute(sender, isPlayer, args);
    }

    public abstract boolean execute(@NotNull CommandSender sender, boolean isPlayer, @NotNull String[] args);

    public TheCore getInstance() {
        return instance;
    }

    public @NotNull String getCommand() {
        return command;
    }
}
