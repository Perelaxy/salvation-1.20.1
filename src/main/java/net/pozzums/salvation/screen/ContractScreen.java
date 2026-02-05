package net.pozzums.salvation.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.pozzums.salvation.registry.ModNetworking;

public class ContractScreen extends HandledScreen<ContractScreenHandler> {

    public ContractScreen(ContractScreenHandler handler, PlayerInventory inv, Text title) {
        super(handler, inv, title);
    }

    @Override
    protected void init() {
        super.init();

        int cx = width / 2;
        int cy = height / 2;

        addDrawableChild(ButtonWidget.builder(
                Text.literal("Change Target"),
                b -> ModNetworking.sendCycleTarget()
        ).dimensions(cx - 60, cy + 30, 120, 20).build());

        addDrawableChild(ButtonWidget.builder(
                Text.literal("Change Judgment"),
                b -> ModNetworking.sendCycleType()
        ).dimensions(cx - 60, cy + 55, 120, 20).build());
    }

    @Override
    protected void drawBackground(DrawContext ctx, float delta, int mouseX, int mouseY) {
        // parchment texture later
    }

    @Override
    protected void drawForeground(DrawContext ctx, int mouseX, int mouseY) {
        ctx.drawText(textRenderer,
                "Judgment: " + handler.getDraft().getType().displayName(),
                20, 20, 0x3A2A1A, false);

        if (handler.getDraft().getTarget() != null) {
            ctx.drawText(textRenderer,
                    "Target set",
                    20, 35, 0x3A2A1A, false);
        }
    }
}
