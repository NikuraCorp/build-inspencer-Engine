/*Aqui Onde Fica montado seu jogo*/
package engine.base.game;

import engine.base.engine.components.*;
import engine.base.engine.core.*;
import engine.base.engine.rendering.*;

public class inGame extends Game
{
	public void Init()
	{
		
		Mesh mesh = new Mesh("plane3.obj");
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
		
		Material gradisu = new Material(new Texture("gradisu.jpg"), 0, 0,
				new Texture("bricks2_normal.jpg"), new Texture("bricks2_disp.jpg"), 0.03f, -0.5f);

		Mesh tempMesh = new Mesh("player.obj");

		MeshRenderer meshRenderer = new MeshRenderer(mesh, brick);
		MeshRenderer planeGradisu = new MeshRenderer(mesh, gradisu);
		GameObject planeObject = new GameObject();
		planeObject.AddComponent(meshRenderer);
		planeObject.GetTransform().GetPos().Set(0, -1, 5);
		
		GameObject planeWall = new GameObject();
		planeWall.AddComponent(planeGradisu);
		planeWall.GetTransform().GetPos().Set(0, 8, 5);

		GameObject directionalLightObject = new GameObject();
		DirectionalLight directionalLight = new DirectionalLight(new Vector3f(0,0,3), 0.2f);

		directionalLightObject.AddComponent(directionalLight);

		GameObject pointLightObject = new GameObject();
		pointLightObject.AddComponent(new PointLight(new Vector3f(3, 3, 5), 0.4f, new Attenuation(0, 0, 1)));

		SpotLight spotLight = new SpotLight(new Vector3f(0,1,1), 0.4f,
				new Attenuation(0,0,0.1f), 0.7f);

		GameObject spotLightObject = new GameObject();
		spotLightObject.AddComponent(spotLight);

		spotLightObject.GetTransform().GetPos().Set(1, 3, 5);
		spotLightObject.GetTransform().SetRot(new Quaternion(new Vector3f(2, 1, 0), (float) Math.toRadians(80.0f)));

		AddObject(planeObject);
		AddObject(directionalLightObject);
		AddObject(pointLightObject);
		AddObject(spotLightObject);
		AddObject(planeWall);

		GameObject testMesh3 = new GameObject().AddComponent(new LookAtComponent()).AddComponent(new MeshRenderer(tempMesh, corpoMaterial));

		AddObject(
				//AddObject(
				new GameObject().AddComponent(new FreeLook(0.3f)).AddComponent(new FreeMove(2.5f))
						.AddComponent(new Camera(new Matrix4f().InitPerspective((float) Math.toRadians(70.0f),
								(float) Window.GetWidth() / (float) Window.GetHeight(), 0.02f, 1000.0f))));

		AddObject(testMesh3);

		testMesh3.GetTransform().GetPos().Set(5, 5, 5);
		testMesh3.GetTransform().SetRot(new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(-60.0f)));

		AddObject(new GameObject().AddComponent(new MeshRenderer(new Mesh("player.obj"), corpoMaterial)));

		directionalLight.GetTransform().SetRot(new Quaternion(new Vector3f(2, 3, 0), (float) Math.toRadians(-75)));
	}
}
