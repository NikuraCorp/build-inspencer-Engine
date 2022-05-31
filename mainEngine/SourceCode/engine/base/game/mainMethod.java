
package engine.base.game;

import engine.base.engine.core.CoreEngine;

public class mainMethod
{
	public static void main(String[] args)
	{
		CoreEngine engine = new CoreEngine(1000, 600, 1000, new TestGame());
		engine.CreateWindow("Build Inspencer" + " FPS");
		engine.Start();
	}
}
