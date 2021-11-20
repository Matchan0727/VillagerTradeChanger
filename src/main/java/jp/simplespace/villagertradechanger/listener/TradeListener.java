package jp.simplespace.villagertradechanger.listener;

import jp.simplespace.villagertradechanger.RecipeManager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.MerchantRecipe;


public class TradeListener implements Listener {
    @EventHandler
    public void onAcquire(VillagerAcquireTradeEvent e){

    }
    @EventHandler
    public void onSpawnVillager(EntitySpawnEvent e){
        //村人以外だったら処理抜け
        if(!e.getEntityType().equals(EntityType.VILLAGER)){
            return;
        }
        if(!(e.getEntity() instanceof Villager)){
            return;
        }
        Villager villager = (Villager) e.getEntity();
        for(MerchantRecipe recipe : villager.getRecipes()){
            RecipeManager.convertRecipe(recipe);
        }
    }
}
