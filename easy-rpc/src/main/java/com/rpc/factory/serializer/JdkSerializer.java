package com.rpc.factory.serializer;

import java.io.*;

/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class JdkSerializer implements Serializer {
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return byteOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class type) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try{
            return (T) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            objectInputStream.close();
        }
    }
}
