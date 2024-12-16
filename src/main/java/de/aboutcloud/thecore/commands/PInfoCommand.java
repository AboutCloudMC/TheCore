package de.aboutcloud.thecore.commands;


import de.aboutcloud.thecore.Constants;
import de.aboutcloud.thecore.CorePlayer;
import de.aboutcloud.thecore.TheCore;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class PInfoCommand extends CoreCommand {

    private TheCore instance;

    public PInfoCommand(TheCore instance, String command) {
        super(instance, command);
        this.instance = instance;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, boolean isPlayer, @NotNull String[] args) {
        if(args.length > 1) {
            sender.sendMessage(Constants.PREFIX + "Invalid syntax.");
        }
        if(args.length == 0 && isPlayer) {
            Player p = (Player) sender;
            sender.sendMessage(getInfo(p.getName()));
        }
        return false;
    }

    private String getInfo(String name) {

        Player player = instance.getServer().getPlayer(name);
        String rank = new CorePlayer(player).getRank().getDisplayName();

        String status = "§aOnline";

        String info = "§7-----[§cInfo§7]-----\n" +
                "§7Name: §b" + player.getName() + "\n" +
                "§7UUID: §b" + player.getUniqueId() + "\n" +
                "§7Rank: §b" + rank + "\n" +
                "§7Status: §b" + status + "\n" +
                "§7----------------";
        return info;
    }

}
