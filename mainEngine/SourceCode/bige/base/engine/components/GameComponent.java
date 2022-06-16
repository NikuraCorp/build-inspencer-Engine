
package bige.base.engine.components;

import bige.base.engine.render.LWJGL.CoreEngine;
import bige.base.engine.render.LWJGL.RenderingEngine;
import bige.base.engine.render.LWJGL.Shader;
import bige.base.engine.render.LWJGL.Transform;

public abstract class GameComponent
{
	private GameObject m_parent;

	public void Input(float delta) {}
	public void Update(float delta) {}
	public void Render(Shader shader, RenderingEngine renderingEngine) {}

	public void SetParent(GameObject parent)
	{
		this.m_parent = parent;
	}

	public Transform GetTransform()
	{
		return m_parent.GetTransform();
	}

	public void AddToEngine(CoreEngine engine) {}
}

