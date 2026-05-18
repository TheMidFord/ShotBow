package midford.shotbow.entity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.renderer.GLRenderer;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.core.util.helper.MathHelper;
import org.joml.Math;

public class SteelArrowRenderer extends EntityRenderer<SteelArrowEntity> {

	@Override
	public void render(TessellatorGeneral tessellator, SteelArrowEntity entity, double x, double y, double z, float yaw, float partialTick) {
		this.bindTexture("/assets/shotbow/textures/entity/steelarrow.png");
		GLRenderer.pushFrame();
		GLRenderer.modelM4f().translate((float)x, (float)y, (float)z);
		GLRenderer.modelM4f().rotate(Math.toRadians(entity.yRotO + (entity.yRot - entity.yRotO) * partialTick - 90.0f), 0.0f, 1.0f, 0.0f);
		GLRenderer.modelM4f().rotate(Math.toRadians(entity.xRotO + (entity.xRot - entity.xRotO) * partialTick), 0.0f, 0.0f, 1.0f);

		int arrowType = entity.getArrowType() == 2 ? 2 : (entity.getArrowType() == 1 ? 1 : 0);
		float bodyMinU = 0.0f;
		float bodyMaxU = 0.5f;
		float bodyMinV = (float)(arrowType * 10) / 32.0f;
		float bodyMaxV = (float)(5 + arrowType * 10) / 32.0f;
		float tailMinU = 0.0f;
		float tailMaxU = 0.15625f;
		float tailMinV = (float)(5 + arrowType * 10) / 32.0f;
		float tailMaxV = (float)(10 + arrowType * 10) / 32.0f;
		float scale = 0.05625f;
		//GLRenderer.enableState(32826);
		float shakeAmount = (float)entity.shake - partialTick;
		if (shakeAmount > 0.0f) {
			float shakeAngle = -MathHelper.sin(shakeAmount * 3.0f) * shakeAmount;
			GLRenderer.modelM4f().rotate(Math.toRadians(shakeAngle), 0.0f, 0.0f, 1.0f);
		}
		GLRenderer.modelM4f().rotate(Math.toRadians(45.0f), 1.0f, 0.0f, 0.0f);
		GLRenderer.modelM4f().scale(scale, scale, scale);
		GLRenderer.modelM4f().translate(-4.0f, 0.0f, 0.0f);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0, -2.0, -2.0, tailMinU, tailMinV);
		tessellator.addVertexWithUV(-7.0, -2.0, 2.0, tailMaxU, tailMinV);
		tessellator.addVertexWithUV(-7.0, 2.0, 2.0, tailMaxU, tailMaxV);
		tessellator.addVertexWithUV(-7.0, 2.0, -2.0, tailMinU, tailMaxV);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0, 2.0, -2.0, tailMinU, tailMinV);
		tessellator.addVertexWithUV(-7.0, 2.0, 2.0, tailMaxU, tailMinV);
		tessellator.addVertexWithUV(-7.0, -2.0, 2.0, tailMaxU, tailMaxV);
		tessellator.addVertexWithUV(-7.0, -2.0, -2.0, tailMinU, tailMaxV);
		tessellator.draw();
		for (int i = 0; i < 4; ++i) {
			GLRenderer.modelM4f().rotate(Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-8.0, -2.0, 0.0, bodyMinU, bodyMinV);
			tessellator.addVertexWithUV(8.0, -2.0, 0.0, bodyMaxU, bodyMinV);
			tessellator.addVertexWithUV(8.0, 2.0, 0.0, bodyMaxU, bodyMaxV);
			tessellator.addVertexWithUV(-8.0, 2.0, 0.0, bodyMinU, bodyMaxV);
			tessellator.draw();
		}
		//GL11.glDisable(32826);
		GLRenderer.popFrame();
	}
}
