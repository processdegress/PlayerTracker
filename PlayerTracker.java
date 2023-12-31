public class PlayerTracker extends Func {

    public PlayerTracker() {
        super(FuncType.Test, "PlayerTracker");
    }

    @SubscribeEvent
    public void onPlayerTickEvent(RenderGameOverlayEvent e) {
        assert mc.level != null;
        for (Entity entity : mc.level.players()) {
            int X = (int) entity.getX();
            int Y = (int) entity.getY();
            int Z = (int) entity.getZ();
            if (!entity.getName().getString().startsWith("§") && !entity.getName().getString().startsWith("ID-") && !entity.getName().getString().startsWith("ID") && !entity.getName().getString().startsWith("CIT-") && !entity.getName().getString().startsWith("CITIZEN") && entity != Minecraft.getInstance().player && e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                if (entity.distanceTo(Minecraft.getInstance().player) < mc.options.renderDistance) {
                    Minecraft.getInstance().player.displayClientMessage(new StringTextComponent("§f[§7Parsing is §aenabled§f]"), true);
                    ChatUtils.sendMessage("Найден игрок: " + TextFormatting.RED + entity.getName().getString() + " (§fX: " + X + " Z: " + Z + " Y: " + Y + TextFormatting.RED + ")");
                }
            }
        }
    }
}
