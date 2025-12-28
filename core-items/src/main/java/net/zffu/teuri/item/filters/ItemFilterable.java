package net.zffu.teuri.item.filters;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Represents any kind of Item that can be filtered.
 * @since 1.0.0
 */
public interface ItemFilterable {

    /**
     * Determines whether an item matches the filter.
     * @param stack the item stack.
     * @return true if the item passed the filter, false if it didn't
     */
    boolean matches(@NotNull ItemStack stack);

}
