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

import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.search.UsageSearchContext;
import com.jetbrains.python.psi.*;
import org.jetbrains.annotations.NotNull;

/**
 * @author yole
 */
public class PythonFindUsagesProvider implements FindUsagesProvider {
    private PythonLanguage language;

    public PythonFindUsagesProvider() {
        this.language = (PythonLanguage)PythonFileType.INSTANCE.getLanguage();
    }

    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement || psiElement instanceof PyReferenceExpression;
    }

    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    public String getType(@NotNull PsiElement element) {
        if (element instanceof PyParameter) return "parameter";
        if (element instanceof PyFunction) return "function";
        if (element instanceof PyClass) return "class";
        if (element instanceof PyReferenceExpression || element instanceof PyTargetExpression)
            return "variable";
        return "";
    }

    @NotNull
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof PsiNamedElement) {
            return ((PsiNamedElement) element).getName();
        }
        if (element instanceof PyReferenceExpression) {
            String referencedName = ((PyReferenceExpression) element).getReferencedName();
            if (referencedName == null) {
                return "";
            }
            return referencedName;
        }
        return "";
    }

    @NotNull
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return getDescriptiveName(element);
    }

    public boolean mayHaveReferences(IElementType token, final short searchContext) {
        if ((searchContext & UsageSearchContext.IN_CODE) != 0 && token == PyElementTypes.REFERENCE_EXPRESSION)
            return true;
        if ((searchContext & UsageSearchContext.IN_COMMENTS) != 0 && token == PyTokenTypes.END_OF_LINE_COMMENT)
            return true;
        if ((searchContext & UsageSearchContext.IN_STRINGS) != 0 && token == PyTokenTypes.STRING_LITERAL)
            return true;
        return false;
    }

    public WordsScanner getWordsScanner() {
        return new PyWordsScanner(language);
    }
}
