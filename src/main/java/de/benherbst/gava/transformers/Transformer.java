package de.benherbst.gava.transformers;

import de.benherbst.gava.language.Language;

import java.util.function.Function;

public interface Transformer<E, T> {

    Function<E, T> apply(Language language);
}
