
package bige.base.engine.render.LWJGL;

import bige.base.engine.components.Game;
import bige.base.engine.components.Input;
import bige.base.engine.components.Time;
import bige.tools.mainMethod;

public class CoreEngine
{
	private boolean         m_isRunning;
	private Game            m_game;
	private RenderingEngine m_renderingEngine;
	
	
	public int WIDTH = 1100;
	public int HEIGHT = 600;
	public double FPS_CAP = 200;
	public static final String windowTitle = "Build Inspencer";
	
	public CoreEngine(Game game)
	{
		this.m_isRunning = false;
		this.m_game = game;
		this.FPS_CAP = 1.0/FPS_CAP;
		game.SetEngine(this);
	}
		

	public void CreateWindow(String title)
	{
		engineWindow.CreateWindow(WIDTH,HEIGHT, windowTitle);
		this.m_renderingEngine = new RenderingEngine();
	}

	public void Start()
	{
		if(m_isRunning)
			return;
		
		Run();
	}
	
	public void Stop()
	{
		if(!m_isRunning)
			return;
		
		m_isRunning = false;
	}
	
	private void Run()
	{
		m_isRunning = true;
		
		int frames = 0;
		double frameCounter = 0;

		m_game.Init();

		double lastTime = Time.GetTime();
		double unprocessedTime = 0;
		
		while(m_isRunning)
		{
			boolean render = false;

			double startTime = Time.GetTime();
			double passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime;
			frameCounter += passedTime;
			
			while(unprocessedTime > FPS_CAP)
			{
				render = true;
				
				unprocessedTime -= FPS_CAP;
				
				if(engineWindow.IsCloseRequested())
					Stop();

				m_game.Input((float) FPS_CAP);
				Input.Update();
				
				m_game.Update((float) FPS_CAP);
				
				if(frameCounter >= 0.8)
				{
					System.out.println("FPS :" + frames);
					frames = 0;
					frameCounter =0.1;
				}
			}
			if(render)
			{
				m_game.Render(m_renderingEngine);
				engineWindow.Render();
				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		CleanUp();
	}

	private void CleanUp()
	{
		engineWindow.Dispose();
	}

	public RenderingEngine GetRenderingEngine() {
		return m_renderingEngine;
	}
}
