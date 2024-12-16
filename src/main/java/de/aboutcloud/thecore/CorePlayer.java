package de.aboutcloud.thecore;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;

public class CorePlayer {

    private Player player;

    private Group rank;
    private User luckUser;

    public CorePlayer(Player player) {
        this.player = player;
        this.luckUser = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId());
        this.rank = LuckPermsProvider.get().getGroupManager().getGroup(luckUser.getPrimaryGroup());
    }

    public Group getRank() {
        return rank;
    }

    public User getLuckUser() {
        return luckUser;
    }
}
