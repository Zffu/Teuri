package net.zffu.teuri.item.filters;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class to create preset implementations for {@link ItemFilterable}.
 * @since 1.0.0
 */
public class ItemFilters {

    /**
     * Creates an item filter that only accepts the provided {@link ItemStack}.
     * @param item the item.
     * @return the item filter as an {@link ItemFilterable}.
     */
    public static ItemFilterable createExactFilter(@NotNull ItemStack item) {
        return new ItemFilterable() {
            @Override
            public boolean matches(@NotNull ItemStack stack) {
                return item == stack;
            }
        };
    }

    /***
     * Creates an item filter that only accepts similar items to the provided {@link ItemStack}
     * @param item the item.
     * @return the item filter as an {@link ItemFilterable}.
     */
    public static ItemFilterable createSimilarFilter(@NotNull ItemStack item) {
        return new ItemFilterable() {
            @Override
            public boolean matches(@NotNull ItemStack stack) {
                return item.isSimilar(stack);
            }
        };
    }

}
