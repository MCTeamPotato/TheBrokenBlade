package com.teampotato.broken_blade.mixin;

import com.bobmowzie.mowziesmobs.client.render.entity.RenderWroughtnaut;
import com.teampotato.broken_blade.BrokenBlade;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Objects;

@Mixin(value = RenderWroughtnaut.class, remap = false)
public abstract class MixinRenderWroughtnaut {
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/bobmowzie/mowziesmobs/client/render/entity/layer/ItemLayer;<init>(Lnet/minecraft/client/renderer/entity/RenderLayerParent;Lcom/ilexiconn/llibrary/client/model/tools/AdvancedModelRenderer;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;)V"))
    private ItemStack getItemStack(ItemStack itemStack) {
        if (BrokenBlade.BROKEN_BLADE == null) BrokenBlade.BROKEN_BLADE = Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(BrokenBlade.ITEM.get()))).getDefaultInstance();
        return BrokenBlade.BROKEN_BLADE;
    }
}
