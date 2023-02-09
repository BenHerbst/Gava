package de.benherbst.gava;

import de.benherbst.gava.compiler.CompilerInfo;
import de.benherbst.gava.compiler.JavaFileCompiler;

import java.io.File;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        System.out.println("Path to .java file:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);

        JavaFileCompiler javaFileCompiler = new JavaFileCompiler();

        CompilerInfo info = javaFileCompiler.compile(file);

        if (info == null) return;

        javaFileCompiler.run(info);
    }
}