package de.benherbst.gava.language;

import java.util.Locale;
import java.util.Map;

public interface Language {

    String translate(String context);

    String translateLine(String context);
}
