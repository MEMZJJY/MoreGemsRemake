package io.github.memzjjy.moregems;

import io.github.memzjjy.moregems.item.BlueGemItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoregemsMod implements ModInitializer {
    public static final BlueGemItem BLUE_GEM_ITEM = new BlueGemItem(new FabricItemSettings());//创建蓝宝石实例
    public static final ItemGroup MOREGEMS_GROUP = FabricItemGroupBuilder.create(
            new Identifier("moregems","moregems_group"))
            .icon(() -> new ItemStack(BLUE_GEM_ITEM))
            .appendItems(stacks ->{
                stacks.add(new ItemStack(BLUE_GEM_ITEM));
            })
            .build();


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("moregems", "blue_gem_item"), BLUE_GEM_ITEM);//注册蓝宝石
        System.out.println("\n       　  　▃▆█▇▄▖\n" +
                "　 　 　 ▟◤▖　　　◥█▎\n" +
                "   　 ◢◤　 ▐　　　 　▐▉\n" +
                "　 ▗◤　　　▂　▗▖　　▕█▎\n" +
                "　◤　▗▅▖◥▄　▀◣　　█▊\n" +
                "▐　▕▎◥▖◣◤　　　　◢██\n" +
                "█◣　◥▅█▀　　　　▐██◤\n" +
                "▐█▙▂　　     　◢██◤\n" +
                "◥██◣　　　　◢▄◤\n" +
                " 　　▀██▅▇▀");
    }
}
