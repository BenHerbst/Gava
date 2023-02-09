package io.github.javainpolish.language.impl;

import io.github.javainpolish.language.Language;

import java.util.HashMap;
import java.util.Map;

public final class PolishLanguage implements Language {

    private final Map<String, String> dictionary;

    public PolishLanguage() {
        this.dictionary = new HashMap<>();
        dictionary.put("während", "while");
        dictionary.put("falls", "if");
        dictionary.put("wahr", "true");
        dictionary.put("falsch", "false");
        dictionary.put("öffentlich", "public");
        dictionary.put("privat", "private");
        dictionary.put("geschützt", "protected");
        dictionary.put("statisch", "static");
        dictionary.put("leer", "void");
        dictionary.put("stopp", "break");
        dictionary.put("weiter", "continue");
        dictionary.put("wechsel", "switch");
        dictionary.put("klasse", "class");
        dictionary.put("zeichenkette", "String");
        dictionary.put("final", "final");
        dictionary.put("null", "null");
        dictionary.put("versuch", "try");
        dictionary.put("fangen", "catch");
        dictionary.put("gleicht", "equals");
        dictionary.put("drucken", "print");
        dictionary.put("sonst", "else");
    }

    @Override
    public String translate(String context) {
        return dictionary.getOrDefault(context, context);
    }

    public String translateLine(String context) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            context = context.replaceAll(entry.getKey(), entry.getValue());
        }
        return context;
    }
}
