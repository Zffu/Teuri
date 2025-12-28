package net.zffu.teuri.item.filters;

import net.zffu.teuri.item.TeuriItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * A simple class for filtering items. Acts as a builder for a simple {@link ItemFilterable}.
 * Intentionally uses simple filter techniques in order to be lightweight.
 * @since 1.0.0
 */
public class SimpleItemFilter implements ItemFilterable {

    private Material matchMaterial;
    private String matchDisplayName;
    private int matchDamage;
    private int matchAmount;

    SimpleItemFilter() {
        this.matchMaterial = null;
        this.matchDisplayName = null;
        this.matchDamage = -1;
        this.matchAmount = -1;
    }

    SimpleItemFilter(ItemStack stack) {
        this.matchMaterial = stack.getType();
        this.matchDisplayName = stack.getItemMeta().getDisplayName();
        this.matchDamage = -1;
        this.matchAmount = -1;
    }

    @Override
    public boolean matches(@NotNull ItemStack stack) {
        if(!stack.getType().equals(this.matchMaterial)) return false;
        if(!stack.getItemMeta().getDisplayName().equals(this.matchDisplayName)) return false;
        if(this.matchDamage > -1 && TeuriItem.getDurability(stack) != this.matchDamage) return false;
        if(this.matchAmount > -1 && stack.getAmount() != this.matchAmount) return false;

        return true;
    }

    public SimpleItemFilter material(Material material) {
        this.matchMaterial = material;
        return this;
    }

    public SimpleItemFilter displayName(String displayName) {
        this.matchDisplayName = displayName;
        return this;
    }

    public SimpleItemFilter damage(int damage) {
        this.matchDamage = damage;
        return this;
    }

    public SimpleItemFilter amount(int amount) {
        this.matchAmount = amount;
        return this;
    }

}
