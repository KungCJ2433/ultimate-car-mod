package de.maxhenkel.car.entity.model.transporter;

import de.maxhenkel.car.Main;
import de.maxhenkel.car.entity.car.EntityCarTransporter;
import de.maxhenkel.car.entity.model.RenderCarBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTransporter extends RenderCarBase<EntityCarTransporter> {

	private ModelBase modelTransporter;
	
	public RenderTransporter(RenderManager renderManagerIn) {
		super(renderManagerIn);
		this.shadowSize = 0.5F;
		this.modelTransporter=new ModelTransporter();
	}
	
	@Override
	public ModelBase getModel(EntityCarTransporter entity) {
		return modelTransporter;
	}

	@Override
	public float getHeightOffset() {
		return 1.35F;
	}
	
	@Override
	public void setupRotation(EntityCarTransporter entity, float f1, float f2) {
		GlStateManager.rotate(180.0F - f1, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.scale(-1.0F, -1.0F, 1.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCarTransporter entity) {
		return new ResourceLocation(Main.MODID, "textures/entity/car_transporter.png");
	}
}
