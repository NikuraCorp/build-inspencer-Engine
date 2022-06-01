
package engine.base.game;

import engine.base.engine.core.CoreEngine;

public class mainMethod
{
	public static void main(String[] args)
	{ /*Propriedades da janela*/
		CoreEngine windowEngine = new CoreEngine(1300, 700, 500, new inGame());
		windowEngine.CreateWindow("Build Inspencer" + " FPS");
		windowEngine.Start();
	}
}
