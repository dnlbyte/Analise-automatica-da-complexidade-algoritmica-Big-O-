package com.Analise_automatica_da_complexidade_algoritmica_Big_O_.Analise_automatica_da_complexidade_algoritmica_Big_O_;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.WhileStmt;

public class MethodAnalyzer {

    public void analyze(CompilationUnit cu) {
        cu.findAll(MethodDeclaration.class).forEach(method -> {
            int forCount = method.findAll(ForStmt.class).size();
            int whileCount = method.findAll(WhileStmt.class).size();
            boolean isRecursive = method.findAll(MethodDeclaration.class).stream()
                    .anyMatch(m -> m.getBody().isPresent() && m.getBody().get().toString().contains(method.getNameAsString()));

            System.out.println("Método: " + method.getName());
            System.out.println(" - Loops for: " + forCount);
            System.out.println(" - Loops while: " + whileCount);
            System.out.println(" - É recursivo? " + isRecursive);

            String bigO = "O(1)";
            if (isRecursive) bigO = "O(n) ou O(log n)";
            else if (forCount + whileCount == 1) bigO = "O(n)";
            else if (forCount + whileCount >= 2) bigO = "O(n²)";

            System.out.println(" - Estimativa de Complexidade: " + bigO);
            System.out.println();
        });
    }
}