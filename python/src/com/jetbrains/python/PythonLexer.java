/*
 *  Copyright 2005 Pythonid Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS"; BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.jetbrains.python;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by IntelliJ IDEA.
 * User: yole
 * Date: 28.05.2005
 * Time: 9:28:11
 * To change this template use File | Settings | File Templates.
 */
public class PythonLexer extends FlexAdapter {
  public PythonLexer() {
    super(new _PythonLexer((Reader)null));
  }

  public _PythonLexer getFlex() {
    return (_PythonLexer)super.getFlex();
  }
}
