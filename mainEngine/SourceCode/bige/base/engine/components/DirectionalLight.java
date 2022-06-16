
package bige.base.engine.components;

import bige.base.engine.render.LWJGL.Shader;
import bige.base.engine.render.LWJGL.Vector3f;

public class DirectionalLight extends BaseLight
{
	public DirectionalLight(Vector3f color, float intensity)
	{
		super(color, intensity);

		SetShader(new Shader("forward-directional"));
	}

	public Vector3f GetDirection()
	{
		return GetTransform().GetTransformedRot().GetForward();
	}
}
