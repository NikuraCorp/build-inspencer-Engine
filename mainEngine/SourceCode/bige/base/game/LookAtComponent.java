
package bige.base.game;

import bige.base.engine.components.GameComponent;
import bige.base.engine.render.LWJGL.Quaternion;
import bige.base.engine.render.LWJGL.RenderingEngine;
import bige.base.engine.render.LWJGL.Shader;
import bige.base.engine.render.LWJGL.Vector3f;

public class LookAtComponent extends GameComponent
{
	private RenderingEngine m_renderingEngine;

	@Override
	public void Update(float delta)
	{
		if(m_renderingEngine != null)
		{
			Quaternion newRot = GetTransform().GetLookAtRotation(m_renderingEngine.GetMainCamera().GetTransform().GetTransformedPos(),
					new Vector3f(0, 1, 0));
					//GetTransform().GetRot().GetUp());

			GetTransform().SetRot(GetTransform().GetRot().NLerp(newRot, delta * 5.0f, true));
			//GetTransform().SetRot(GetTransform().GetRot().SLerp(newRot, delta * 5.0f, true));
		}
	}

	@Override
	public void Render(Shader shader, RenderingEngine renderingEngine)
	{
		this.m_renderingEngine = renderingEngine;
	}
}
