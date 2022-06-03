/*Aqui se aplica algumas configuracoes da janela*/
package engine.base.game;

import engine.base.engine.core.CoreEngine;


public class mainMethod
{
	public static void main(String[] args)
	{ /*Propriedades da janela*/
		CoreEngine windowEngine = new CoreEngine(new inGame());
		windowEngine.CreateWindow("");
		windowEngine.Start();
	}
}
