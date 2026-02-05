package net.pozzums.salvation.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.pozzums.salvation.screen.ContractScreenHandler;

public class ContractScrollItem extends Item {

    public ContractScrollItem(Settings settings) { super(settings); }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ContractScreenHandler.open(user);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
