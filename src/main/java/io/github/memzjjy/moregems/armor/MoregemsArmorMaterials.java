package io.github.memzjjy.moregems.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

import static io.github.memzjjy.moregems.MoregemsMod.BLUE_GEM_ITEM;

public enum MoregemsArmorMaterials implements ArmorMaterial {
   BLUE_GEM_ARMOR("blue_gem_armor", 50, new int[]{5, 8, 10, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F, () -> {
      return Ingredient.ofItems(BLUE_GEM_ITEM);
   });

   private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
   private final String name;
   private final int durabilityMultiplier;
   private final int[] protectionAmounts;
   private final int enchantability;
   private final SoundEvent equipSound;
   private final float toughness;
   private final Lazy<Ingredient> repairIngredientSupplier;

   private MoregemsArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, Supplier<Ingredient> ingredientSupplier) {
      this.name = name;
      this.durabilityMultiplier = durabilityMultiplier;
      this.protectionAmounts = protectionAmounts;
      this.enchantability = enchantability;
      this.equipSound = equipSound;
      this.toughness = toughness;
      this.repairIngredientSupplier = new Lazy(ingredientSupplier);
   }

   public int getDurability(EquipmentSlot slot) {
      return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
   }

   public int getProtectionAmount(EquipmentSlot slot) {
      return this.protectionAmounts[slot.getEntitySlotId()];
   }

   public int getEnchantability() {
      return this.enchantability;
   }

   public SoundEvent getEquipSound() {
      return this.equipSound;
   }

   public Ingredient getRepairIngredient() {
      return (Ingredient)this.repairIngredientSupplier.get();
   }

   @Environment(EnvType.CLIENT)
   public String getName() {
      return this.name;
   }

   public float getToughness() {
      return this.toughness;
   }
}
