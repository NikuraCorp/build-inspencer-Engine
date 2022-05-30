/*
 * Copyright (C) 2014 Benny Bobaganoosh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package engine.base.game;

import engine.base.engine.components.*;
import engine.base.engine.core.*;
import engine.base.engine.rendering.*;

public class TestGame extends Game
{
	public void Init()
	{
		Mesh mesh = new Mesh("plane3.obj");
		Material corpoMaterial = new Material(new Texture("corpo.png"), 0, 0,
			new Texture("corpo_normal.png"), new Texture("corpo_disp.png"), 0.03f, -0.5f);
		
		Material face = new Material(new Texture("face.png"), 1, 8,
				new Texture("face_normal.png"), new Texture("face_disp.png"), 0.03f, -0.5f);

		Material metal = new Material(new Texture("metal.jpg"), 1, 8,
				new Texture("metal_normal.jpg"), new Texture("metal_disp.jpg"), 0.04f, -1.0f);
		
		Material stone = new Material(new Texture("stone.jpg"), 1, 8,
				new Texture("stone_normal.jpg"), new Texture("stone_disp.jpg"), 0.04f, -1.0f);

		Mesh tempMesh = new Mesh("player.obj");

		MeshRenderer meshRenderer = new MeshRenderer(mesh, stone);

		GameObject planeObject = new GameObject();
		planeObject.AddComponent(meshRenderer);
		planeObject.GetTransform().GetPos().Set(0, -1, 5);

		GameObject directionalLightObject = new GameObject();
		DirectionalLight directionalLight = new DirectionalLight(new Vector3f(0,0,1), 0.4f);

		directionalLightObject.AddComponent(directionalLight);

		GameObject pointLightObject = new GameObject();
		pointLightObject.AddComponent(new PointLight(new Vector3f(0, 1, 0), 0.4f, new Attenuation(0, 0, 1)));

		SpotLight spotLight = new SpotLight(new Vector3f(0,1,1), 0.4f,
				new Attenuation(0,0,0.1f), 0.7f);

		GameObject spotLightObject = new GameObject();
		spotLightObject.AddComponent(spotLight);

		spotLightObject.GetTransform().GetPos().Set(5, 0, 5);
		spotLightObject.GetTransform().SetRot(new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(90.0f)));

		AddObject(planeObject);
		AddObject(directionalLightObject);
		AddObject(pointLightObject);
		AddObject(spotLightObject);

		GameObject testMesh3 = new GameObject().AddComponent(new LookAtComponent()).AddComponent(new MeshRenderer(tempMesh, corpoMaterial));

		AddObject(
				//AddObject(
				new GameObject().AddComponent(new FreeLook(0.3f)).AddComponent(new FreeMove(2.3f))
						.AddComponent(new Camera(new Matrix4f().InitPerspective((float) Math.toRadians(70.0f),
								(float) Window.GetWidth() / (float) Window.GetHeight(), 0.01f, 1000.0f))));

		AddObject(testMesh3);

		testMesh3.GetTransform().GetPos().Set(5, 5, 5);
		testMesh3.GetTransform().SetRot(new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(-70.0f)));

		AddObject(new GameObject().AddComponent(new MeshRenderer(new Mesh("player.obj"), corpoMaterial)));

		directionalLight.GetTransform().SetRot(new Quaternion(new Vector3f(1, 0, 0), (float) Math.toRadians(-45)));
	}
}
