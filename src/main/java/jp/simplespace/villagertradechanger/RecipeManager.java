package jp.simplespace.villagertradechanger;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class RecipeManager {
    private static Map<ItemStack, List<ItemStack>> map = new HashMap<>();

    public static void putRecipe(ItemStack result,List<ItemStack> ingredients){
        map.put(result,ingredients);
    }
    public static void convertRecipe(MerchantRecipe recipe){
        //MerchantRecipe newRecipe = new MerchantRecipe(recipe.getResult(),recipe.getUses(),recipe.getMaxUses(),recipe.hasExperienceReward(),recipe.getVillagerExperience(),recipe.getPriceMultiplier());
        if(map.containsKey(recipe.getResult())){
            recipe.setIngredients(map.get(recipe.getResult()));
        }
    }
}
