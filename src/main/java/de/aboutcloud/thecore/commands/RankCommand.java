package de.aboutcloud.thecore.commands;

import de.aboutcloud.thecore.Constants;
import de.aboutcloud.thecore.CorePlayer;
import de.aboutcloud.thecore.TheCore;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RankCommand extends CoreCommand{

    private TheCore instance;

    public RankCommand(TheCore instance, String command) {
        super(instance, command);
        this.instance = instance;
    }


    //  /rank 0<User> 1[set] 2[rank]

    @Override
    public boolean execute(@NotNull CommandSender sender, boolean isPlayer, @NotNull String[] args) {
        if(args.length > 3 || args.length == 0) {
            sender.sendMessage(Constants.PREFIX + "Invalid syntax.");
            return false;
        }
        Player p = instance.getServer().getPlayer(args[0]);
        CorePlayer cp = new CorePlayer(p);
        Group rank = cp.getRank();
        User user = cp.getLuckUser();
        if(args.length == 1) {
            sender.sendMessage(Constants.PREFIX + "§b" + p.getName() + " §7has the rank " + rank.getDisplayName());
        } else if(args.length == 3) {
            if(!args[1].toLowerCase().equals("set")) {
                sender.sendMessage(Constants.PREFIX + "Invalid syntax.");
                return false;
            }
            if(LuckPermsProvider.get().getGroupManager().getGroup(args[2]) == null) {
                sender.sendMessage(Constants.PREFIX + "The group §b" + args[2] + "§7 does not exist.");
                return false;
            }
            user.setPrimaryGroup(args[2]);
            rank = cp.getRank();
            p.sendMessage(Constants.PREFIX + "§b" + p.getName() + " §7was promoted the rank " + rank.getDisplayName());
        }

        return true;
    }



}
