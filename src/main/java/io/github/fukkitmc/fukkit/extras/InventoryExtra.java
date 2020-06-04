package io.github.fukkitmc.fukkit.extras;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import org.bukkit.craftbukkit.entity.CraftHumanEntity;

/**
 * Extra for {@link net.minecraft.inventory.Inventory}
 */
public interface InventoryExtra {

    // CraftBukkit start
    java.util.List<ItemStack> getContents();

    void onOpen(CraftHumanEntity who);

    void onClose(CraftHumanEntity who);

    java.util.List<org.bukkit.entity.HumanEntity> getViewers();

    org.bukkit.inventory.InventoryHolder getOwner();

    void setMaxStackSize(int size);

    org.bukkit.Location getLocation();

    default Recipe<?> getCurrentRecipe() {
        return null;
    }

    default void setCurrentRecipe(Recipe<?> recipe) {
    }
}
