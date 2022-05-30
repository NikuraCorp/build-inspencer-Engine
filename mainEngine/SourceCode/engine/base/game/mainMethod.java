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
