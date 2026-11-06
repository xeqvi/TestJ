
package mc.firepixel.fun.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import java.util.Arrays;

public class TestGui implements Listener, CommandExecutor {

    public void openTestMenu(Player player) {

        Inventory menu = Bukkit.createInventory(
                null,
                27,
                ChatColor.DARK_GRAY + "Test GUI"
        );
        
        // bookshelf item (test)
        ItemStack bookshelf = new ItemStack(Material.BOOKSHELF);
        ItemMeta bookshelfMeta = bookshelf.getItemMeta();
        bookshelfMeta.setDisplayName(ChatColor.GREEN + "Main Lobby Test");
        bookshelfMeta.setLore(Arrays.asList(
                "",
                ChatColor.GRAY + "Return to the Main Lobby."
        ));
        bookshelf.setItemMeta(bookshelfMeta);
        menu.setItem(4, bookshelf);

        // barrier item (test)
        ItemStack barrier = new ItemStack(Material.BARRIER);
        ItemMeta barrierMeta = barrier.getItemMeta();
        barrierMeta.setDisplayName(ChatColor.RED + "Close");
        menu.setItem(22, barrier);

        player.openInventory(menu);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        event.setCancelled(true);

        if (event.getRawSlot() == 22) {
            Player player = (Player) event.getWhoClicked();
            if (event.isLeftClick())
                player.closeInventory();
                if (event.isLeftClick());
                player.sendMessage(
                        ChatColor.RED + "You Closed the Test Menu!"
                );
        }
    }
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {

        event.setCancelled(true);

    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            openTestMenu(player);
        } else {
            sender.sendMessage("Only players can use this command! Nigga");
        }

        return true;
    }
}
