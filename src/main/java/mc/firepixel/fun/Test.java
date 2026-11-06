package mc.firepixel.fun;

import mc.firepixel.fun.commands.TestGui;
import mc.firepixel.fun.commands.TestMessage;
import mc.firepixel.fun.commands.TestStats;
import mc.firepixel.fun.commands.TestWorld;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Test extends JavaPlugin {

    private Logger logger = getLogger();

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled!");
        getCommand("test").setExecutor(new TestMessage());
        TestGui gui = new  TestGui();
        getCommand("testgui").setExecutor(gui);
        getServer().getPluginManager().registerEvents(gui, this);
        getCommand("teststats").setExecutor(new TestStats());
        getCommand("testworld").setExecutor(new TestWorld());
    }

    @Override
    public void onDisable() {
        super.onDisable();
        logger.info("you are not just kidding :>");
    }

    private void loadcommands() {

    }

}
