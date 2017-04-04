package de.maxhenkel.car.entity.model.transporter;

import de.maxhenkel.car.entity.car.base.EntityCarBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTransporter extends ModelBase {

	private ModelRenderer bottom;
	private ModelRenderer wheel1a;
	private ModelRenderer wheel1b;
	private ModelRenderer wheel1c;
	private ModelRenderer wheel1d;
	private ModelRenderer wheel1e;
	private ModelRenderer wheel1f;
	private ModelRenderer wheel1g;
	private ModelRenderer wheel2a;
	private ModelRenderer wheel2b;
	private ModelRenderer wheel2c;
	private ModelRenderer wheel2d;
	private ModelRenderer wheel2e;
	private ModelRenderer wheel2f;
	private ModelRenderer wheel2g;
	private ModelRenderer wheel3a;
	private ModelRenderer wheel3b;
	private ModelRenderer wheel3c;
	private ModelRenderer wheel3d;
	private ModelRenderer wheel3e;
	private ModelRenderer wheel3f;
	private ModelRenderer wheel3g;
	private ModelRenderer wheel4a;
	private ModelRenderer wheel4b;
	private ModelRenderer wheel4c;
	private ModelRenderer wheel4d;
	private ModelRenderer wheel4e;
	private ModelRenderer wheel4f;
	private ModelRenderer wheel4g;
	private ModelRenderer wheel5a;
	private ModelRenderer wheel5b;
	private ModelRenderer wheel5c;
	private ModelRenderer wheel5d;
	private ModelRenderer wheel5e;
	private ModelRenderer wheel5f;
	private ModelRenderer wheel5g;
	private ModelRenderer wheel6a;
	private ModelRenderer wheel6b;
	private ModelRenderer wheel6c;
	private ModelRenderer wheel6d;
	private ModelRenderer wheel6e;
	private ModelRenderer wheel6f;
	private ModelRenderer wheel6g;
	private ModelRenderer front;
	private ModelRenderer frontWindow;
	private ModelRenderer backWindow;
	private ModelRenderer topLoader;
	private ModelRenderer back;
	private ModelRenderer right;
	private ModelRenderer left;
	private ModelRenderer leftFront;
	private ModelRenderer rightFront;
	private ModelRenderer rightTop;
	private ModelRenderer leftTop;
	private ModelRenderer topFront;
	private ModelRenderer hood;
	private ModelRenderer cabinLower;

	public ModelTransporter() {
		textureWidth = 128;
		textureHeight = 256;

		bottom = new ModelRenderer(this, 34, 0);
		bottom.mirror = true;
		bottom.addBox(0.0F, -1.0F, -28.0F, 28, 1, 38);
		bottom.setRotationPoint(-14.0F, -18.0F, 11.0F);
		bottom.setTextureSize(128, 256);

		wheel1a = new ModelRenderer(this, 8, 2);
		wheel1a.mirror = true;
		wheel1a.addBox(0.0F, -3.0F, 1.0F, 1, 6, 1);
		wheel1a.setRotationPoint(14.0F, -18.0F, -5.0F);
		wheel1a.setTextureSize(128, 256);

		wheel1b = new ModelRenderer(this, 12, 0);
		wheel1b.mirror = true;
		wheel1b.addBox(0.0F, -4.0F, -1.0F, 1, 8, 2);
		wheel1b.setRotationPoint(14.0F, -18.0F, -5.0F);
		wheel1b.setTextureSize(128, 256);

		wheel1c = new ModelRenderer(this, 4, 3);
		wheel1c.mirror = true;
		wheel1c.addBox(0.0F, -2.0F, 2.0F, 1, 4, 1);
		wheel1c.setRotationPoint(14.0F, -18.0F, -5.0F);
		wheel1c.setTextureSize(128, 256);

		wheel1d = new ModelRenderer(this, 0, 4);
		wheel1d.mirror = true;
		wheel1d.addBox(0.0F, -1.0F, 3.0F, 1, 2, 1);
		wheel1d.setRotationPoint(14.0F, -18.0F, -5.0F);
		wheel1d.setTextureSize(128, 256);

		wheel1e = new ModelRenderer(this, 26, 4);
		wheel1e.mirror = true;
		wheel1e.addBox(0.0F, -1.0F, -4.0F, 1, 2, 1);
		wheel1e.setRotationPoint(14.0F, -18.0F, -5.0F);
		wheel1e.setTextureSize(128, 256);

		wheel1f = new ModelRenderer(this, 22, 3);
		wheel1f.mirror = true;
		wheel1f.addBox(0.0F, -2.0F, -3.0F, 1, 4, 1);
		wheel1f.setRotationPoint(14.0F, -18.0F, -5.0F);
		wheel1f.setTextureSize(128, 256);

		wheel1g = new ModelRenderer(this, 18, 2);
		wheel1g.mirror = true;
		wheel1g.addBox(0.0F, -3.0F, -2.0F, 1, 6, 1);
		wheel1g.setRotationPoint(14.0F, -18.0F, -5.0F);
		wheel1g.setTextureSize(128, 256);

		wheel2a = new ModelRenderer(this, 18, 2);
		wheel2a.mirror = true;
		wheel2a.addBox(0.0F, -3.0F, -2.0F, 1, 6, 1);
		wheel2a.setRotationPoint(-15.0F, -18.0F, -5.0F);
		wheel2a.setTextureSize(128, 256);

		wheel2b = new ModelRenderer(this, 12, 0);
		wheel2b.mirror = true;
		wheel2b.addBox(0.0F, -4.0F, -1.0F, 1, 8, 2);
		wheel2b.setRotationPoint(-15.0F, -18.0F, -5.0F);
		wheel2b.setTextureSize(128, 256);

		wheel2c = new ModelRenderer(this, 22, 3);
		wheel2c.mirror = true;
		wheel2c.addBox(0.0F, -2.0F, -3.0F, 1, 4, 1);
		wheel2c.setRotationPoint(-15.0F, -18.0F, -5.0F);
		wheel2c.setTextureSize(128, 256);

		wheel2d = new ModelRenderer(this, 0, 4);
		wheel2d.mirror = true;
		wheel2d.addBox(0.0F, -1.0F, 3.0F, 1, 2, 1);
		wheel2d.setRotationPoint(-15.0F, -18.0F, -5.0F);
		wheel2d.setTextureSize(128, 256);

		wheel2e = new ModelRenderer(this, 26, 4);
		wheel2e.mirror = true;
		wheel2e.addBox(0.0F, -1.0F, -4.0F, 1, 2, 1);
		wheel2e.setRotationPoint(-15.0F, -18.0F, -5.0F);
		wheel2e.setTextureSize(128, 256);

		wheel2f = new ModelRenderer(this, 4, 3);
		wheel2f.mirror = true;
		wheel2f.addBox(0.0F, -2.0F, 2.0F, 1, 4, 1);
		wheel2f.setRotationPoint(-15.0F, -18.0F, -5.0F);
		wheel2f.setTextureSize(128, 256);

		wheel2g = new ModelRenderer(this, 8, 2);
		wheel2g.mirror = true;
		wheel2g.addBox(0.0F, -3.0F, 1.0F, 1, 6, 1);
		wheel2g.setRotationPoint(-15.0F, -18.0F, -5.0F);
		wheel2g.setTextureSize(128, 256);

		wheel3a = new ModelRenderer(this, 26, 4);
		wheel3a.mirror = true;
		wheel3a.addBox(0.0F, -1.0F, -4.0F, 1, 2, 1);
		wheel3a.setRotationPoint(14.0F, -18.0F, 13.0F);
		wheel3a.setTextureSize(128, 256);

		wheel3b = new ModelRenderer(this, 4, 3);
		wheel3b.mirror = true;
		wheel3b.addBox(0.0F, -2.0F, -3.0F, 1, 4, 1);
		wheel3b.setRotationPoint(14.0F, -18.0F, 13.0F);
		wheel3b.setTextureSize(128, 256);

		wheel3c = new ModelRenderer(this, 18, 2);
		wheel3c.mirror = true;
		wheel3c.addBox(0.0F, -3.0F, -2.0F, 1, 6, 1);
		wheel3c.setRotationPoint(14.0F, -18.0F, 13.0F);
		wheel3c.setTextureSize(128, 256);

		wheel3d = new ModelRenderer(this, 12, 0);
		wheel3d.mirror = true;
		wheel3d.addBox(0.0F, -4.0F, -1.0F, 1, 8, 2);
		wheel3d.setRotationPoint(14.0F, -18.0F, 13.0F);
		wheel3d.setTextureSize(128, 256);

		wheel3e = new ModelRenderer(this, 18, 2);
		wheel3e.mirror = true;
		wheel3e.addBox(0.0F, -3.0F, 1.0F, 1, 6, 1);
		wheel3e.setRotationPoint(14.0F, -18.0F, 13.0F);
		wheel3e.setTextureSize(128, 256);

		wheel3f = new ModelRenderer(this, 4, 3);
		wheel3f.mirror = true;
		wheel3f.addBox(0.0F, -2.0F, 2.0F, 1, 4, 1);
		wheel3f.setRotationPoint(14.0F, -18.0F, 13.0F);
		wheel3f.setTextureSize(128, 256);

		wheel3g = new ModelRenderer(this, 26, 4);
		wheel3g.mirror = true;
		wheel3g.addBox(0.0F, -1.0F, 3.0F, 1, 2, 1);
		wheel3g.setRotationPoint(14.0F, -18.0F, 13.0F);
		wheel3g.setTextureSize(128, 256);

		wheel4a = new ModelRenderer(this, 26, 4);
		wheel4a.mirror = true;
		wheel4a.addBox(0.0F, -1.0F, -4.0F, 1, 2, 1);
		wheel4a.setRotationPoint(-15.0F, -18.0F, 13.0F);
		wheel4a.setTextureSize(128, 256);

		wheel4b = new ModelRenderer(this, 22, 3);
		wheel4b.mirror = true;
		wheel4b.addBox(0.0F, -2.0F, -3.0F, 1, 4, 1);
		wheel4b.setRotationPoint(-15.0F, -18.0F, 13.0F);
		wheel4b.setTextureSize(128, 256);

		wheel4c = new ModelRenderer(this, 8, 2);
		wheel4c.mirror = true;
		wheel4c.addBox(0.0F, -3.0F, -2.0F, 1, 6, 1);
		wheel4c.setRotationPoint(-15.0F, -18.0F, 13.0F);
		wheel4c.setTextureSize(128, 256);

		wheel4d = new ModelRenderer(this, 12, 0);
		wheel4d.mirror = true;
		wheel4d.addBox(0.0F, -4.0F, -1.0F, 1, 8, 2);
		wheel4d.setRotationPoint(-15.0F, -18.0F, 13.0F);
		wheel4d.setTextureSize(128, 256);

		wheel4e = new ModelRenderer(this, 8, 2);
		wheel4e.mirror = true;
		wheel4e.addBox(0.0F, -3.0F, 1.0F, 1, 6, 1);
		wheel4e.setRotationPoint(-15.0F, -18.0F, 13.0F);
		wheel4e.setTextureSize(128, 256);

		wheel4f = new ModelRenderer(this, 22, 3);
		wheel4f.mirror = true;
		wheel4f.addBox(0.0F, -2.0F, 2.0F, 1, 4, 1);
		wheel4f.setRotationPoint(-15.0F, -18.0F, 13.0F);
		wheel4f.setTextureSize(128, 256);

		wheel4g = new ModelRenderer(this, 0, 4);
		wheel4g.mirror = true;
		wheel4g.addBox(0.0F, -1.0F, 3.0F, 1, 2, 1);
		wheel4g.setRotationPoint(-15.0F, -18.0F, 13.0F);
		wheel4g.setTextureSize(128, 256);

		wheel5a = new ModelRenderer(this, 18, 2);
		wheel5a.mirror = true;
		wheel5a.addBox(0.0F, -3.0F, -2.0F, 1, 6, 1);
		wheel5a.setRotationPoint(-15.0F, -18.0F, -13.0F);
		wheel5a.setTextureSize(128, 256);

		wheel5b = new ModelRenderer(this, 12, 0);
		wheel5b.mirror = true;
		wheel5b.addBox(0.0F, -4.0F, -1.0F, 1, 8, 2);
		wheel5b.setRotationPoint(-15.0F, -18.0F, -13.0F);
		wheel5b.setTextureSize(128, 256);

		wheel5c = new ModelRenderer(this, 22, 3);
		wheel5c.mirror = true;
		wheel5c.addBox(0.0F, -2.0F, -3.0F, 1, 4, 1);
		wheel5c.setRotationPoint(-15.0F, -18.0F, -13.0F);
		wheel5c.setTextureSize(128, 256);

		wheel5d = new ModelRenderer(this, 0, 4);
		wheel5d.mirror = true;
		wheel5d.addBox(0.0F, -1.0F, 3.0F, 1, 2, 1);
		wheel5d.setRotationPoint(-15.0F, -18.0F, -13.0F);
		wheel5d.setTextureSize(128, 256);

		wheel5e = new ModelRenderer(this, 26, 4);
		wheel5e.mirror = true;
		wheel5e.addBox(0.0F, -1.0F, -4.0F, 1, 2, 1);
		wheel5e.setRotationPoint(-15.0F, -18.0F, -13.0F);
		wheel5e.setTextureSize(128, 256);

		wheel5f = new ModelRenderer(this, 4, 3);
		wheel5f.mirror = true;
		wheel5f.addBox(0.0F, -2.0F, 2.0F, 1, 4, 1);
		wheel5f.setRotationPoint(-15.0F, -18.0F, -13.0F);
		wheel5f.setTextureSize(128, 256);

		wheel5g = new ModelRenderer(this, 8, 2);
		wheel5g.mirror = true;
		wheel5g.addBox(0.0F, -3.0F, 1.0F, 1, 6, 1);
		wheel5g.setRotationPoint(-15.0F, -18.0F, -13.0F);
		wheel5g.setTextureSize(128, 256);

		wheel6a = new ModelRenderer(this, 8, 2);
		wheel6a.mirror = true;
		wheel6a.addBox(0.0F, -3.0F, 1.0F, 1, 6, 1);
		wheel6a.setRotationPoint(14.0F, -18.0F, -13.0F);
		wheel6a.setTextureSize(128, 256);

		wheel6b = new ModelRenderer(this, 12, 0);
		wheel6b.mirror = true;
		wheel6b.addBox(0.0F, -4.0F, -1.0F, 1, 8, 2);
		wheel6b.setRotationPoint(14.0F, -18.0F, -13.0F);
		wheel6b.setTextureSize(128, 256);

		wheel6c = new ModelRenderer(this, 4, 3);
		wheel6c.mirror = true;
		wheel6c.addBox(0.0F, -2.0F, 2.0F, 1, 4, 1);
		wheel6c.setRotationPoint(14.0F, -18.0F, -13.0F);
		wheel6c.setTextureSize(128, 256);

		wheel6d = new ModelRenderer(this, 0, 4);
		wheel6d.mirror = true;
		wheel6d.addBox(0.0F, -1.0F, 3.0F, 1, 2, 1);
		wheel6d.setRotationPoint(14.0F, -18.0F, -13.0F);
		wheel6d.setTextureSize(128, 256);

		wheel6e = new ModelRenderer(this, 26, 4);
		wheel6e.mirror = true;
		wheel6e.addBox(0.0F, -1.0F, -4.0F, 1, 2, 1);
		wheel6e.setRotationPoint(14.0F, -18.0F, -13.0F);
		wheel6e.setTextureSize(128, 256);

		wheel6f = new ModelRenderer(this, 22, 3);
		wheel6f.mirror = true;
		wheel6f.addBox(0.0F, -2.0F, -3.0F, 1, 4, 1);
		wheel6f.setRotationPoint(14.0F, -18.0F, -13.0F);
		wheel6f.setTextureSize(128, 256);

		wheel6g = new ModelRenderer(this, 18, 2);
		wheel6g.mirror = true;
		wheel6g.addBox(0.0F, -3.0F, -2.0F, 1, 6, 1);
		wheel6g.setRotationPoint(14.0F, -18.0F, -13.0F);
		wheel6g.setTextureSize(128, 256);

		front = new ModelRenderer(this, 0, 242);
		front.mirror = true;
		front.addBox(0.0F, 0.0F, 0.0F, 28, 10, 1);
		front.setRotationPoint(-14.0F, -18.0F, 20.0F);
		front.setTextureSize(128, 256);

		frontWindow = new ModelRenderer(this, 0, 15);
		frontWindow.mirror = true;
		frontWindow.addBox(0.0F, 0.0F, 0.0F, 28, 9, 1);
		frontWindow.setRotationPoint(-14.0F, -8.0F, 17.0F);
		frontWindow.setTextureSize(128, 256);

		backWindow = new ModelRenderer(this, 0, 41);
		backWindow.mirror = true;
		backWindow.addBox(0.0F, 0.0F, 0.0F, 28, 13, 1);
		backWindow.setRotationPoint(-14.0F, -12.0F, 4.0F);
		backWindow.setTextureSize(128, 256);

		topLoader = new ModelRenderer(this, 0, 59);
		topLoader.mirror = true;
		topLoader.addBox(0.0F, 0.0F, 0.0F, 26, 1, 20);
		topLoader.setRotationPoint(-13.0F, -13.0F, -16.0F);
		topLoader.setTextureSize(128, 256);

		back = new ModelRenderer(this, 0, 28);
		back.mirror = true;
		back.addBox(0.0F, 0.0F, 0.0F, 26, 6, 1);
		back.setRotationPoint(-13.0F, -18.0F, -17.0F);
		back.setTextureSize(128, 256);

		right = new ModelRenderer(this, 0, 81);
		right.mirror = true;
		right.addBox(0.0F, 0.0F, 0.0F, 1, 13, 21);
		right.setRotationPoint(-14.0F, -18.0F, -17.0F);
		right.setTextureSize(128, 256);

		left = new ModelRenderer(this, 47, 81);
		left.mirror = true;
		left.addBox(0.0F, 0.0F, 0.0F, 1, 13, 21);
		left.setRotationPoint(13.0F, -18.0F, -17.0F);
		left.setTextureSize(128, 256);

		leftFront = new ModelRenderer(this, 47, 142);
		leftFront.mirror = true;
		leftFront.addBox(0.0F, 0.0F, 0.0F, 1, 10, 15);
		leftFront.setRotationPoint(13.0F, -18.0F, 5.0F);
		leftFront.setTextureSize(128, 256);

		rightFront = new ModelRenderer(this, 0, 142);
		rightFront.mirror = true;
		rightFront.addBox(0.0F, 0.0F, 0.0F, 1, 10, 15);
		rightFront.setRotationPoint(-14.0F, -18.0F, 5.0F);
		rightFront.setTextureSize(128, 256);

		rightTop = new ModelRenderer(this, 47, 118);
		rightTop.mirror = true;
		rightTop.addBox(0.0F, 0.0F, 0.0F, 1, 9, 12);
		rightTop.setRotationPoint(-14.0F, -8.0F, 5.0F);
		rightTop.setTextureSize(128, 256);

		leftTop = new ModelRenderer(this, 0, 118);
		leftTop.mirror = true;
		leftTop.addBox(0.0F, 0.0F, 0.0F, 1, 9, 12);
		leftTop.setRotationPoint(13.0F, -8.0F, 5.0F);
		leftTop.setTextureSize(128, 256);

		topFront = new ModelRenderer(this, 0, 180);
		topFront.mirror = true;
		topFront.addBox(0.0F, 0.0F, 0.0F, 26, 1, 12);
		topFront.setRotationPoint(-13.0F, 0.0F, 5.0F);
		topFront.setTextureSize(128, 256);

		hood = new ModelRenderer(this, 0, 237);
		hood.mirror = true;
		hood.addBox(0.0F, 0.0F, 0.0F, 26, 1, 2);
		hood.setRotationPoint(-13.0F, -9.0F, 18.0F);
		hood.setTextureSize(128, 256);
		
		cabinLower = new ModelRenderer(this, 0, 170);
		cabinLower.mirror = true;
		cabinLower.addBox(0.0F, 0.0F, 0.0F, 28, 6, 1);
		cabinLower.setRotationPoint(-14.0F, -18.0F, 4.0F);
		cabinLower.setTextureSize(128, 256);
		
	}

	public void setWheelRotation(float rot) {
		
		setRotation(wheel1a, rot, 0F, 0F);
		setRotation(wheel1b, rot, 0F, 0F);
		setRotation(wheel1c, rot, 0F, 0F);
		setRotation(wheel1d, rot, 0F, 0F);
		setRotation(wheel1e, rot, 0F, 0F);
		setRotation(wheel1f, rot, 0F, 0F);
		setRotation(wheel1g, rot, 0F, 0F);
		setRotation(wheel2a, rot, 0F, 0F);
		setRotation(wheel2b, rot, 0F, 0F);
		setRotation(wheel2c, rot, 0F, 0F);
		setRotation(wheel2d, rot, 0F, 0F);
		setRotation(wheel2e, rot, 0F, 0F);
		setRotation(wheel2f, rot, 0F, 0F);
		setRotation(wheel2g, rot, 0F, 0F);
		setRotation(wheel3a, rot, 0F, 0F);
		setRotation(wheel3b, rot, 0F, 0F);
		setRotation(wheel3c, rot, 0F, 0F);
		setRotation(wheel3d, rot, 0F, 0F);
		setRotation(wheel3e, rot, 0F, 0F);
		setRotation(wheel3f, rot, 0F, 0F);
		setRotation(wheel3g, rot, 0F, 0F);
		setRotation(wheel4a, rot, 0F, 0F);
		setRotation(wheel4b, rot, 0F, 0F);
		setRotation(wheel4c, rot, 0F, 0F);
		setRotation(wheel4d, rot, 0F, 0F);
		setRotation(wheel4e, rot, 0F, 0F);
		setRotation(wheel4f, rot, 0F, 0F);
		setRotation(wheel4g, rot, 0F, 0F);
		setRotation(wheel5a, rot, 0F, 0F);
		setRotation(wheel5b, rot, 0F, 0F);
		setRotation(wheel5c, rot, 0F, 0F);
		setRotation(wheel5d, rot, 0F, 0F);
		setRotation(wheel5e, rot, 0F, 0F);
		setRotation(wheel5f, rot, 0F, 0F);
		setRotation(wheel5g, rot, 0F, 0F);
		setRotation(wheel6a, rot, 0F, 0F);
		setRotation(wheel6b, rot, 0F, 0F);
		setRotation(wheel6c, rot, 0F, 0F);
		setRotation(wheel6d, rot, 0F, 0F);
		setRotation(wheel6e, rot, 0F, 0F);
		setRotation(wheel6f, rot, 0F, 0F);
		setRotation(wheel6g, rot, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);

		EntityCarBase car = (EntityCarBase) entity;

		setWheelRotation(car.updateWheelRotation(f5));

		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		bottom.render(f5);
		wheel1a.render(f5);
		wheel1b.render(f5);
		wheel1c.render(f5);
		wheel1d.render(f5);
		wheel1e.render(f5);
		wheel1f.render(f5);
		wheel1g.render(f5);
		wheel2a.render(f5);
		wheel2b.render(f5);
		wheel2c.render(f5);
		wheel2d.render(f5);
		wheel2e.render(f5);
		wheel2f.render(f5);
		wheel2g.render(f5);
		wheel3a.render(f5);
		wheel3b.render(f5);
		wheel3c.render(f5);
		wheel3d.render(f5);
		wheel3e.render(f5);
		wheel3f.render(f5);
		wheel3g.render(f5);
		wheel4a.render(f5);
		wheel4b.render(f5);
		wheel4c.render(f5);
		wheel4d.render(f5);
		wheel4e.render(f5);
		wheel4f.render(f5);
		wheel4g.render(f5);
		wheel5a.render(f5);
		wheel5b.render(f5);
		wheel5c.render(f5);
		wheel5d.render(f5);
		wheel5e.render(f5);
		wheel5f.render(f5);
		wheel5g.render(f5);
		wheel6a.render(f5);
		wheel6b.render(f5);
		wheel6c.render(f5);
		wheel6d.render(f5);
		wheel6e.render(f5);
		wheel6f.render(f5);
		wheel6g.render(f5);
		front.render(f5);
		frontWindow.render(f5);
		backWindow.render(f5);
		topLoader.render(f5);
		back.render(f5);
		right.render(f5);
		left.render(f5);
		leftFront.render(f5);
		rightFront.render(f5);
		rightTop.render(f5);
		leftTop.render(f5);
		topFront.render(f5);
		hood.render(f5);
		cabinLower.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
