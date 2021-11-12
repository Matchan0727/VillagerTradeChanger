package jp.simplespace.villagertradechanger.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.MerchantRecipe;
/*
修繕本・幸運本・ダイヤ防具などの希少品が出回るのを防ぐために、
紙1stでエメラルド1個
エメラルド2stで修繕本1冊
など、交換レートを改悪する。
(可能であれば、ゾンビ治療の割引の方も改悪していただきたいです。)

もしくは、
・1日3回までしか交易できないように制限する
・1回交換しただけで"×"（取引不可能)が出てくる
等でも構いません。

10/27 追記
フースマとそれ以外の国で改悪割合を変更する。
 */

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

        }
    }
}
