package net.pozzums.salvation.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.pozzums.salvation.contract.ContractDraft;
import net.pozzums.salvation.registry.ModScreens;

public class ContractScreenHandler extends ScreenHandler {

    private final ContractDraft draft;
    public final PlayerEntity player;

    public ContractScreenHandler(int syncId, PlayerInventory inv) {
        super(ModScreens.CONTRACT, syncId);
        this.player = inv.player;
        this.draft = new ContractDraft(player.getUuid());
    }

    public ContractDraft getDraft() { return draft; }

    @Override
    public boolean canUse(PlayerEntity player) { return true; }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        return ItemStack.EMPTY;
    }

    public static void open(PlayerEntity player) {
        player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, inv, p) -> new ContractScreenHandler(syncId, inv),
                Text.literal("Contract")
        ));
    }
}
