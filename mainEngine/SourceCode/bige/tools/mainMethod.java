/*Aqui se aplica algumas configuracoes da janela*/
package bige.tools;

import bige.base.engine.render.LWJGL.CoreEngine;
import bige.base.game.inGame;


public class mainMethod
{

	public static void main(String[] args)
	{ /*Propriedades da janela*/
		CoreEngine runGame = new CoreEngine(new inGame());
		runGame.CreateWindow("");
		runGame.Start();
	}
}
