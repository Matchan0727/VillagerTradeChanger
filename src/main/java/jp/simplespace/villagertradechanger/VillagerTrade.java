package jp.simplespace.villagertradechanger;

import jp.simplespace.matchanpluginutilities.api.config.Config;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class VillagerTrade extends JavaPlugin {
    private static Config config;
    private static Plugin plugin;
    private static ItemStack mendingBook;
    private static ItemStack fortuneBook;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
        config=new Config(plugin,plugin.getDataFolder(),"config.yml");
        //エンチャント本
        mendingBook=new ItemStack(Material.ENCHANTED_BOOK);
        mendingBook.addEnchantment(Enchantment.MENDING,1);
        fortuneBook=new ItemStack(Material.ENCHANTED_BOOK);
        fortuneBook.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS,3);
        loadConfig(config.getConfig());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static void loadConfig(FileConfiguration config){
        //修繕
        Material mendingMaterial = (Material) config.get("recipes.mending.material");
        ArrayList<Integer> mendingCount = (ArrayList<Integer>) config.getIntegerList("recipes.mending.count");
        ArrayList<ItemStack> mendingIngredients = new ArrayList<>();
        mendingIngredients.add(new ItemStack(mendingMaterial,mendingCount.get(0)));
        mendingIngredients.add(new ItemStack(mendingMaterial,mendingCount.get(1)));
        RecipeManager.putRecipe(mendingBook,mendingIngredients);
        //幸運Ⅲ
        Material fortuneMaterial = (Material) config.get("recipes.fortune.material");
        ArrayList<Integer> fortuneCount = (ArrayList<Integer>) config.getIntegerList("recipes.fortune.count");
        ArrayList<ItemStack> fortuneIngredients = new ArrayList<>();
        mendingIngredients.add(new ItemStack(mendingMaterial,fortuneCount.get(0)));
        mendingIngredients.add(new ItemStack(mendingMaterial,fortuneCount.get(1)));
        RecipeManager.putRecipe(fortuneBook,mendingIngredients);
    }
}
