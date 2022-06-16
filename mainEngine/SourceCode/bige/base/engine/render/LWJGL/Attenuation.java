
package bige.base.engine.render.LWJGL;

public class Attenuation extends Vector3f
{
	public Attenuation(float constant, float linear, float exponent) {
		super(constant, linear, exponent);
	}

	public float GetConstant()
	{
		return GetX();
	}

	public float GetLinear()
	{
		return GetY();
	}

	public float GetExponent()
	{
		return GetZ();
	}
}
