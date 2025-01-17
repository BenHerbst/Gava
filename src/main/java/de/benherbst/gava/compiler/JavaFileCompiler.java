package de.benherbst.gava.compiler;

import de.benherbst.gava.language.impl.GermanLanguage;
import de.benherbst.gava.transformers.Transformer;
import de.benherbst.gava.transformers.impl.StringTransformer;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public final class JavaFileCompiler {

    public CompilerInfo compile(File file) {
        GermanLanguage germanLanguage = new GermanLanguage();
        Transformer<File, String> transformer = new StringTransformer();
        transformer.apply(germanLanguage).apply(file);

        int result = com.sun.tools.javac.Main.compile(new String[] {file.getAbsolutePath()});
        if (result != 0) {
            System.err.println("Compilation failed");
            return null;
        }

        String className = file.getName().replace(".java", "");
        File classFile = new File(file.getParentFile(), className + ".class");
        return new CompilerInfo(className, classFile);
    }

    public void run(CompilerInfo info) {
        try {
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {info.classFile().getParentFile().toURI().toURL()});
            Class<?> cls = classLoader.loadClass(info.className());

            Method main = cls.getMethod("main", String[].class);
            main.invoke(null, (Object) new String[]{});
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException |
                 InvocationTargetException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
