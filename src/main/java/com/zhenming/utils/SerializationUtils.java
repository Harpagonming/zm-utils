package com.zhenming.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class SerializationUtils {
  public static <T> String serialize(T object, Class<T> T) {
    try {
      //ByteArrayOutputStream 用于存储序列化的Session对象
      ByteArrayOutputStream bos = new ByteArrayOutputStream();

      //将Object对象输出成byte数据
      ObjectOutputStream out = new ObjectOutputStream(bos);
      out.writeObject(object);

      //将字节码，编码成String类型数据
      return Base64.getEncoder().encodeToString(bos.toByteArray());
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("序列化失败");
    }
  }

  public static <T> T deserialize(String sessionStr, Class<T> T) {
    try {
      //读取字节码表
      ByteArrayInputStream bis = new ByteArrayInputStream(Base64.getDecoder().decode(sessionStr));

      //将字节码反序列化成 对象
      ObjectInputStream in = new ObjectInputStream(bis);
      return (T) in.readObject();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("反序列化失败");
    }
  }
}
