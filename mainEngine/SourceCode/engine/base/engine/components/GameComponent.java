
package engine.base.engine.components;

import engine.base.engine.core.CoreEngine;
import engine.base.engine.core.GameObject;
import engine.base.engine.core.Transform;
import engine.base.engine.rendering.RenderingEngine;
import engine.base.engine.rendering.Shader;

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

