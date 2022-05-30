
package engine.base.game;

import engine.base.engine.core.CoreEngine;

public class mainMethod
{
	public static void main(String[] args)
	{
		CoreEngine engine = new CoreEngine(1000, 600, 60, new TestGame());
		engine.CreateWindow("Build Inspencer");
		engine.Start();
	}
}
