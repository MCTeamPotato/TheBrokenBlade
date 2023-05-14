package com.teampotato.broken_blade.mixin;

import com.bobmowzie.mowziesmobs.client.render.entity.RenderWroughtnaut;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import com.teampotato.broken_blade.BrokenBlade;

import java.util.Objects;

@Mixin(value = RenderWroughtnaut.class, remap = false)
public abstract class MixinRenderWroughtnaut {
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/bobmowzie/mowziesmobs/client/render/entity/layer/ItemLayer;<init>(Lnet/minecraft/client/renderer/entity/IEntityRenderer;Lcom/ilexiconn/llibrary/client/model/tools/AdvancedModelRenderer;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/model/ItemCameraTransforms$TransformType;)V"))
    private ItemStack getItemStack(ItemStack itemStack) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(BrokenBlade.ITEM.get()))).getDefaultInstance();
    }
}
