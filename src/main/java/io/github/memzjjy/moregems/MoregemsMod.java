/*
 * Copyright (c) 2021 [MEMZJJY of copyright owner]
 * Licensed under the GNU General Public License v3.0
 *  (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.memzjjy.moregems;

import io.github.memzjjy.moregems.armor.MoregemsArmorMaterials;
import io.github.memzjjy.moregems.item.BlueGemItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoregemsMod implements ModInitializer {
    public static final BlueGemItem BLUE_GEM_ITEM = new BlueGemItem(new FabricItemSettings());//创建蓝宝石实例
    public static final ArmorItem BLUE_GEM_ARMOR_HEAD = new ArmorItem(MoregemsArmorMaterials.BLUE_GEM_ARMOR, EquipmentSlot.HEAD, new Item.Settings());//蓝宝石头
    public static final ArmorItem BLUE_GEM_ARMOR_CHEST = new ArmorItem(MoregemsArmorMaterials.BLUE_GEM_ARMOR, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem BLUE_GEM_ARMOR_LEGS = new ArmorItem(MoregemsArmorMaterials.BLUE_GEM_ARMOR, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem BLUE_GEM_ARMOR_FEET = new ArmorItem(MoregemsArmorMaterials.BLUE_GEM_ARMOR, EquipmentSlot.FEET, new Item.Settings());
    public static final Block BLUE_GEM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));//创建蓝宝石方块
    public static final ItemGroup MOREGEMS_GROUP = FabricItemGroupBuilder.create(
            new Identifier("moregems", "moregems_group"))
            .icon(() -> new ItemStack(BLUE_GEM_ITEM))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(BLUE_GEM_ITEM));
                stacks.add(new ItemStack(BLUE_GEM_ARMOR_HEAD));
                stacks.add(new ItemStack(BLUE_GEM_ARMOR_CHEST));
                stacks.add(new ItemStack(BLUE_GEM_ARMOR_LEGS));
                stacks.add(new ItemStack(BLUE_GEM_ARMOR_FEET));
                stacks.add(new ItemStack(BLUE_GEM_BLOCK));
            })
            .build();


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("moregems", "blue_gem_item"), BLUE_GEM_ITEM);//注册蓝宝石
        Registry.register(Registry.ITEM, new Identifier("moregems", "blue_gem_armor_head_item"), BLUE_GEM_ARMOR_HEAD);
        Registry.register(Registry.ITEM, new Identifier("moregems", "blue_gem_armor_chest_item"), BLUE_GEM_ARMOR_CHEST);
        Registry.register(Registry.ITEM, new Identifier("moregems", "blue_gem_armor_legs_item"), BLUE_GEM_ARMOR_LEGS);
        Registry.register(Registry.ITEM, new Identifier("moregems", "blue_gem_armor_fee_item"), BLUE_GEM_ARMOR_FEET);
        Registry.register(Registry.BLOCK, new Identifier("moregems", "blue_gem_block"), BLUE_GEM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("moregems", "blue_gem_block_item"), new BlockItem(BLUE_GEM_BLOCK, new Item.Settings()));

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
