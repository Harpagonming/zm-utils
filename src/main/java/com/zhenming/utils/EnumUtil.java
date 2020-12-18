package com.zhenming.utils;

import java.lang.reflect.Method;

public class EnumUtil {
  public static <E extends Enum<?>> E getEnums(Class<E> enumClass, Object value, Method method) throws Exception {
    E[] es = enumClass.getEnumConstants();
    for (E e : es) {
      if (value.equals(method.invoke(e))) {
        return e;
      }
    }
    return null;
  }

  private EnumUtil() {
  }
}
