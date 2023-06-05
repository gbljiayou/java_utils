package com.gbl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author gbl
 */
public final class EnumUtil {
    /**
     * 前一个元素
     *
     * @param curEnum 枚举类的当前元素
     * @param <E>     枚举类泛型
     * @return
     */
    public static <E extends Enum> E prev(Enum curEnum) {
        int curOrdinal = curEnum.ordinal();
        //第一个元素没有前一个元素
        if (curOrdinal == 0) {
            return null;
        }
        Class<E> enumType = curEnum.getDeclaringClass();
        E[] VALUES = enumType.getEnumConstants();
        return VALUES[(curOrdinal - 1) % VALUES.length];
    }

    /**
     * 前面所有元素[逆序排列]
     *
     * @param curEnum 枚举类的当前元素
     * @param <E>     枚举类泛型
     * @return
     */
    public static <E extends Enum> List<E> prevAll(Enum curEnum) {
        List<E> values = new ArrayList<>();
        E preValue = prev(curEnum);
        while (Objects.nonNull(preValue)) {
            values.add(preValue);
            preValue = prev(preValue);
        }
        return values;
    }

    /**
     * 后一个元素
     *
     * @param curEnum 枚举类的当前元素
     * @param <E>     枚举类泛型
     * @return
     */
    public static <E extends Enum> E next(Enum curEnum) {
        int curOrdinal = curEnum.ordinal();
        Class<E> enumType = curEnum.getDeclaringClass();
        E[] VALUES = enumType.getEnumConstants();
        //最后一个元素没有下一次元素
        if (curOrdinal + 1 == VALUES.length) {
            return null;
        }
        return VALUES[(curOrdinal + 1) % VALUES.length];
    }

    /**
     * 后面所有元素
     *
     * @param curEnum 枚举类的当前元素
     * @param <E>     枚举类泛型
     * @return
     */
    public static <E extends Enum> List<E> nextAll(Enum curEnum) {
        List<E> values = new ArrayList<>();
        E nextValue = next(curEnum);
        while (Objects.nonNull(nextValue)) {
            values.add(nextValue);
            nextValue = next(nextValue);
        }
        return values;
    }

    /**
     * 两个元素中间所有元素
     *
     * @param beginEnum 开始元素
     * @param endEnum   结束元素
     * @param <E>       枚举类泛型
     * @return
     */
    public static <E extends Enum> List<E> Between(Enum beginEnum, Enum endEnum) {
        List<E> values = new ArrayList<>();
        E nextValue = next(beginEnum);
        while (Objects.nonNull(nextValue) && nextValue != endEnum) {
            values.add(nextValue);
            nextValue = next(nextValue);
        }
        return values;
    }
}
