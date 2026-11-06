package mc.firepixel.fun.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class TestMessage implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("test")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.GREEN + "Test Command Works!");
            } else {
                sender.sendMessage(ChatColor.RED + "You are a nigga (jk) :>");
            }
            return true;
        }
        return false;
    }
}