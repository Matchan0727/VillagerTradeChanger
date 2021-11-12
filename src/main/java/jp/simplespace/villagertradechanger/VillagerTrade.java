package jp.simplespace.villagertradechanger;

import jp.simplespace.matchanpluginutilities.api.config.Config;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerTrade extends JavaPlugin {
    private static Config config;
    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
        config=new Config(plugin,plugin.getDataFolder(),"config.yml");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
