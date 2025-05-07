package com.Analise_automatica_da_complexidade_algoritmica_Big_O_.Analise_automatica_da_complexidade_algoritmica_Big_O_;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AnaliseAutomaticaDaComplexidadeAlgoritmicaBigOApplication {

	public static void main(String[] args) throws Exception {
		String filePath = "src/main/java/com/Analise_automatica_da_complexidade_algoritmica_Big_O_/Analise_automatica_da_complexidade_algoritmica_Big_O_/Exemplo.java";
		String code = new String(Files.readAllBytes(Paths.get(filePath)));
		CompilationUnit cu = StaticJavaParser.parse(code);

		MethodAnalyzer analyzer = new MethodAnalyzer();
		analyzer.analyze(cu);
	}

}
