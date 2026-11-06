package mc.firepixel.fun.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestStats implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        player.sendMessage(ChatColor.YELLOW + "=======================================");
        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "       PLAYER PROFILE");
        player.sendMessage(ChatColor.YELLOW + "=======================================");

        // UUID
        player.sendMessage(
                ChatColor.GREEN + "UUID: "
                + ChatColor.WHITE + player.getUniqueId()
        );

        // Health
        player.sendMessage(
                ChatColor.GREEN + "Health: "
                + ChatColor.WHITE + player.getHealth() + "/20"
        );

        // Level
        player.sendMessage(
                ChatColor.GREEN + "GameMode: "
                        + ChatColor.WHITE + player.getLevel()
        );

        // GameMode
        player.sendMessage(
                ChatColor.GREEN + "GameMode: "
                + ChatColor.WHITE + player.getGameMode()
        );

        // Food Level
        player.sendMessage(
                ChatColor.GREEN + "Food Level: "
                + ChatColor.WHITE + player.getFoodLevel()
        );

        // Coordinates:
        player.sendMessage(
                ChatColor.GREEN + "Coordinates: "
                + ChatColor.WHITE
                + "X: " + player.getLocation().getBlockX()
                + "Y: " + player.getLocation().getBlockY()
                + "Z: " + player.getLocation().getBlockZ()
        );

        player.sendMessage(ChatColor.DARK_GRAY + "=======================================");

        return true;
    }
}
