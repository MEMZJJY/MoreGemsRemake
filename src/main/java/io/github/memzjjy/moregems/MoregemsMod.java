package io.github.memzjjy.moregems;

import io.github.memzjjy.moregems.armor.MoregemsArmorMaterials;
import io.github.memzjjy.moregems.item.BlueGemItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoregemsMod implements ModInitializer {
    public static final BlueGemItem BLUE_GEM_ITEM = new BlueGemItem(new FabricItemSettings());//创建蓝宝石实例
    public static final ArmorItem BLUE_GEM_ARMOR_HEAD = new ArmorItem(MoregemsArmorMaterials.BLUE_GEM_ARMOR, EquipmentSlot.HEAD,new Item.Settings());//蓝宝石头
    public static final ArmorItem BLUE_GEM_ARMOR_CHEST = new ArmorItem(MoregemsArmorMaterials.BLUE_GEM_ARMOR, EquipmentSlot.CHEST,new Item.Settings());
    public static final ArmorItem BLUE_GEM_ARMOR_LEGS = new ArmorItem(MoregemsArmorMaterials.BLUE_GEM_ARMOR, EquipmentSlot.LEGS,new Item.Settings());
    public static final ArmorItem BLUE_GEM_ARMOR_FEET = new ArmorItem(MoregemsArmorMaterials.BLUE_GEM_ARMOR, EquipmentSlot.FEET,new Item.Settings());
    public static final ItemGroup MOREGEMS_GROUP = FabricItemGroupBuilder.create(
            new Identifier("moregems","moregems_group"))
            .icon(() -> new ItemStack(BLUE_GEM_ITEM))
            .appendItems(stacks ->{
                stacks.add(new ItemStack(BLUE_GEM_ITEM));
                stacks.add(new ItemStack(BLUE_GEM_ARMOR_HEAD));
                stacks.add(new ItemStack(BLUE_GEM_ARMOR_CHEST));
                stacks.add(new ItemStack(BLUE_GEM_ARMOR_LEGS));
                stacks.add(new ItemStack(BLUE_GEM_ARMOR_FEET));
            })
            .build();


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("moregems", "blue_gem_item"), BLUE_GEM_ITEM);//注册蓝宝石
        Registry.register(Registry.ITEM,new Identifier("moregems","blue_gem_armor_head_item"),BLUE_GEM_ARMOR_HEAD);
        Registry.register(Registry.ITEM,new Identifier("moregems","blue_gem_armor_chest_item"),BLUE_GEM_ARMOR_CHEST);
        Registry.register(Registry.ITEM,new Identifier("moregems","blue_gem_armor_legs_item"),BLUE_GEM_ARMOR_LEGS);
        Registry.register(Registry.ITEM,new Identifier("moregems","blue_gem_armor_fee_item"),BLUE_GEM_ARMOR_FEET);

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
