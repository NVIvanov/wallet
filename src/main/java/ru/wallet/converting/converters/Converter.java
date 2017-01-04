package ru.wallet.converting.converters;

/**
 * Конвертирует модель в DTO и обратно. Если у принимаемой модели есть id,
 * то в модель будут подгружены существующие данные.
 * @author nivanov
 *         on 04.01.17.
 */
public interface Converter<S, T> {
    T convert(S source);
    S convertBack(T source);
    void populate(S existingTarget, T source);
}
