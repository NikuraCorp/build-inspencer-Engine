
package bige.base.engine.components;

import bige.base.engine.render.LWJGL.Vector2f;
import bige.base.engine.render.LWJGL.Vector3f;
import bige.base.engine.render.LWJGL.engineWindow;

public class FreeLook extends GameComponent
{
	private static final Vector3f Y_AXIS = new Vector3f(0,1,0);

	private boolean m_mouseLocked = false;
	private float   m_sensitivity;
	private int     m_unlockMouseKey;

	public FreeLook(float sensitivity)
	{
		this(sensitivity, Input.KEY_ESCAPE);
	}

	public FreeLook(float sensitivity, int unlockMouseKey)
	{
		this.m_sensitivity = sensitivity;
		this.m_unlockMouseKey = unlockMouseKey;
	}

	@Override
	public void Input(float delta)
	{
		Vector2f centerPosition = new Vector2f(engineWindow.GetWidth()/2, engineWindow.GetHeight()/2);

		if(Input.GetKey(m_unlockMouseKey))
		{
			Input.SetCursor(true);
			m_mouseLocked = false;
		}
		if(Input.GetMouseDown(0))
		{
			Input.SetMousePosition(centerPosition);
			Input.SetCursor(false);
			m_mouseLocked = true;
		}

		if(m_mouseLocked)
		{
			Vector2f deltaPos = Input.GetMousePosition().Sub(centerPosition);

			boolean rotY = deltaPos.GetX() != 0;
			boolean rotX = deltaPos.GetY() != 0;

			if(rotY)
				GetTransform().Rotate(Y_AXIS, (float) Math.toRadians(deltaPos.GetX() * m_sensitivity));
			if(rotX)
				GetTransform().Rotate(GetTransform().GetRot().GetRight(), (float) Math.toRadians(-deltaPos.GetY() * m_sensitivity));

			if(rotY || rotX)
				Input.SetMousePosition(centerPosition);
		}
	}
}
