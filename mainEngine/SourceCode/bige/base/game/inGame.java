/*Aqui Onde Fica montado seu jogo*/
package bige.base.game;

import bige.base.engine.components.*;
import bige.base.engine.render.*;
import bige.base.engine.render.LWJGL.Attenuation;
import bige.base.engine.render.LWJGL.Material;
import bige.base.engine.render.LWJGL.Matrix4f;
import bige.base.engine.render.LWJGL.Mesh;
import bige.base.engine.render.LWJGL.Quaternion;
import bige.base.engine.render.LWJGL.Texture;
import bige.base.engine.render.LWJGL.Vector3f;
import bige.base.engine.render.LWJGL.engineWindow;

public class inGame extends Game
{
	public void Init()
	{
		/*Models*/
		
		Mesh mesh = new Mesh("plane3.obj");
		
		/*Textures */
		Material corpoMaterial = new Material(new Texture("corpo.png"), 0, 0,
			new Texture("corpo_normal.png"), new Texture("corpo_disp.png"), 0.03f, -0.5f);
		
		Material brick = new Material(new Texture("bricks2.jpg"), 0, 0,
				new Texture("bricks2_normal.jpg"), new Texture("bricks2_disp.jpg"), 0.03f, -0.5f);
		
		Material face = new Material(new Texture("face.png"), 1, 8,
				new Texture("face_normal.png"), new Texture("face_disp.png"), 0.03f, -0.5f);

		Material metal = new Material(new Texture("metal.jpg"), 1, 8,
				new Texture("metal_normal.jpg"), new Texture("metal_disp.jpg"), 0.04f, -1.0f);
		
		Material stone = new Material(new Texture("stone.jpg"), 1, 8,
				new Texture("stone_normal.jpg"), new Texture("stone_disp.jpg"), 0.04f, -1.0f);
		
		Material gradisu = new Material(new Texture("devs/gradisu.jpg"), 0, 0,
				new Texture("biengine/default_normal.jpg"), new Texture("biengine/default_disp.png"), 0.03f, -0.5f);

		Mesh tempMesh = new Mesh("player.obj");

		MeshRenderer meshRenderer = new MeshRenderer(mesh, brick);
		MeshRenderer planeGradisu = new MeshRenderer(mesh, gradisu);
		
		
		GameObject planeObject = new GameObject();
		planeObject.AddComponent(meshRenderer);
		planeObject.GetTransform().GetPos().Set(0, 0, 5);
		
		GameObject planeWall = new GameObject();
		planeWall.AddComponent(planeGradisu);
		planeWall.GetTransform().GetPos().Set(15, 8, 30);

		GameObject directionalLightObject = new GameObject();
		DirectionalLight directionalLight = new DirectionalLight(new Vector3f(0,0,3), 0.2f);

		directionalLightObject.AddComponent(directionalLight);

		GameObject pointLightObject = new GameObject();
		pointLightObject.AddComponent(new PointLight(new Vector3f(3, 3, 5), 0.4f, new Attenuation(0, 0, 1)));

		SpotLight spotLight = new SpotLight(new Vector3f(0,1,1), 0.6f,
				new Attenuation(0,0,0.1f), 0.7f);

		GameObject spotLightObject = new GameObject();
		spotLightObject.AddComponent(spotLight);

		spotLightObject.GetTransform().GetPos().Set(1, 3, 5);
		spotLightObject.GetTransform().SetRot(new Quaternion(new Vector3f(2, 1, 0), (float) Math.toRadians(60.0f)));

		AddObject(planeObject);
		AddObject(directionalLightObject);
		AddObject(pointLightObject);
		AddObject(spotLightObject);
		AddObject(planeWall);


		GameObject testMesh3 = new GameObject().AddComponent(new LookAtComponent()).AddComponent(new MeshRenderer(tempMesh, corpoMaterial));

		AddObject(
				//AddObject(
				new GameObject().AddComponent(new FreeLook(0.3f)).AddComponent(new FreeMove(3.0f))
						.AddComponent(new Camera(new Matrix4f().InitPerspective((float) Math.toRadians(60.0f),
								(float) engineWindow.GetWidth() / (float) engineWindow.GetHeight(), 0.02f, 1000.0f))));

		AddObject(testMesh3);

		testMesh3.GetTransform().GetPos().Set(5, 5, 5);
		testMesh3.GetTransform().SetRot(new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(-60.0f)));

		AddObject(new GameObject().AddComponent(new MeshRenderer(new Mesh("player.obj"), corpoMaterial)));

		directionalLight.GetTransform().SetRot(new Quaternion(new Vector3f(2, 3, 0), (float) Math.toRadians(-75)));
	}
}
