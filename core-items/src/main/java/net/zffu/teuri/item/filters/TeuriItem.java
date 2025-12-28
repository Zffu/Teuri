package net.zffu.teuri.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.jetbrains.annotations.NotNull;

/**
 * Simple utility class to handle Spigot items better.
 */
public class TeuriItem {

    /**
     * Get the durability of the item stack.
      * @param stack the item stack.
     * @return the damage of the item or 0 if the item is unbreakable.
     */
    public static int getDurability(@NotNull ItemStack stack) {
        if(stack.getItemMeta() instanceof Damageable) {
            Damageable damageable = (Damageable) stack.getItemMeta();
            return damageable.getDamage();
        }

        return 0;
    }

}
