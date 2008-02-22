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

package com.jetbrains.python.psi.impl;

import com.intellij.lang.ASTNode;
import com.jetbrains.python.psi.PyKeyValueExpression;

/**
 * Created by IntelliJ IDEA.
 * User: yole
 * Date: 01.06.2005
 * Time: 23:41:31
 * To change this template use File | Settings | File Templates.
 */
public class PyKeyValueExpressionImpl extends PyElementImpl implements PyKeyValueExpression {
    public PyKeyValueExpressionImpl(ASTNode astNode) {
        super(astNode);
    }
}
