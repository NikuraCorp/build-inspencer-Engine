
package engine.base.game;

import engine.base.engine.core.CoreEngine;

public class mainMethod
{
	public static void main(String[] args)
	{ /*Propriedades da janela*/
		CoreEngine engine = new CoreEngine(1000, 600, 500, new inGame());
		engine.CreateWindow("Build Inspencer" + " FPS");
		engine.Start();
	}
}
