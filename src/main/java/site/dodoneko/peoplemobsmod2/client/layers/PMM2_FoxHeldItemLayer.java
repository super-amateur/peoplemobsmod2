package site.dodoneko.peoplemobsmod2.client.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import site.dodoneko.peoplemobsmod2.client.model.PMM2_FoxModel;

import com.mojang.blaze3d.platform.GlStateManager;

@SuppressWarnings ("deprecation") @OnlyIn(Dist.CLIENT)
public class PMM2_FoxHeldItemLayer<T extends FoxEntity> extends LayerRenderer < T, PMM2_FoxModel < T >> {

    public PMM2_FoxHeldItemLayer(IEntityRenderer < T, PMM2_FoxModel < T >> p_i50949_1_) {
        super(p_i50949_1_);
    }

    public void render(T entityIn, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
        ItemStack itemstack = entityIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
        if (!itemstack.isEmpty()) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();

//            GlStateManager.translatef(0.0F, 0.6875F, -0.75F);
            PMM2_FoxModel<T> model = this.getEntityModel();

            boolean flag1 = entityIn.isChild();
            if (flag1) {
                GlStateManager.translatef(0.0F, 1.5F * (1F-model.modelScale) +3F/16F, 0.0F);
                GlStateManager.scalef(0.5F * model.modelScale, 0.5F * model.modelScale, 0.5F * model.modelScale);
                GlStateManager.translatef(0.0F, 24.0F * model.scaleFactor * model.modelScale, 0.0F);
            }


            GlStateManager.translatef(0, 1/16, 0);
            model.bipedRightHand.setMatrix(1/16, true);
//            GlStateManager.translatef(4F/16F, 11F/16F, 2F/16F);


//            GlStateManager.rotatef( (arm.rotateAngleX+body.rotateAngleX)*0.3f *PMM2_Math.Rad2deg, 1.0F, 0.0F, 0.0F);
//            GlStateManager.translatef(0.25F, 0.1875F, 0.25F);

//            GlStateManager.scalef(0.01F, 0.01F, 0.01F);
            Minecraft.getInstance().getItemRenderer().renderItem(itemstack, entityIn, ItemCameraTransforms.TransformType.GROUND, false);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}
