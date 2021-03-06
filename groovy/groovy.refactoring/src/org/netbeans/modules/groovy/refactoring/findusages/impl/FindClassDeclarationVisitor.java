/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.groovy.refactoring.findusages.impl;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.ModuleNode;
import org.netbeans.modules.groovy.editor.api.ElementUtils;

/**
 *
 * @author Martin Janicek
 */
public class FindClassDeclarationVisitor extends AbstractFindUsagesVisitor {

    private final String findingFqn;
    

    public FindClassDeclarationVisitor(ModuleNode moduleNode, String findingFqn) {
        super(moduleNode);
        this.findingFqn = ElementUtils.normalizeTypeName(findingFqn, null);
    }

    @Override
    public void visitClass(ClassNode clazz) {
        final ClassNode type = ElementUtils.getType(clazz);
        final String typeName = ElementUtils.getTypeName(type);

        if (findingFqn.equals(typeName)) {
            usages.add(clazz);
        }
        super.visitClass(clazz);
    }
}
