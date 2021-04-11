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

package io.github.memzjjy.moregems.item;

import io.github.memzjjy.moregems.tag.MoregemsItemTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum MoregemsToolMaterials implements ToolMaterial {
   BLUE_GEM(3, 5000, 10.0F, 5.0F, 10, () -> {
      return Ingredient.fromTag(MoregemsItemTags.BLUE_GEM);
   });

   private final int miningLevel;
   private final int itemDurability;
   private final float miningSpeed;
   private final float attackDamage;
   private final int enchantability;
   private final Lazy<Ingredient> repairIngredient;

   MoregemsToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantibility, Supplier<Ingredient> repairIngredient) {
      this.miningLevel = miningLevel;
      this.itemDurability = itemDurability;
      this.miningSpeed = miningSpeed;
      this.attackDamage = attackDamage;
      this.enchantability = enchantibility;
      this.repairIngredient = new Lazy(repairIngredient);
   }

   public int getDurability() {
      return this.itemDurability;
   }

   public float getMiningSpeed() {
      return this.miningSpeed;
   }

   public float getAttackDamage() {
      return this.attackDamage;
   }

   public int getMiningLevel() {
      return this.miningLevel;
   }

   public int getEnchantability() {
      return this.enchantability;
   }

   public Ingredient getRepairIngredient() {
      return this.repairIngredient.get();
   }
}
