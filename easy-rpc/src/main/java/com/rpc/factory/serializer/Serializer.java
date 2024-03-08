package com.rpc.factory.serializer;

import java.io.IOException;

public interface Serializer {

    <T> byte[] serialize(T object) throws IOException;

    <T> T deserialize(byte[] bytes,Class type) throws IOException;
}
