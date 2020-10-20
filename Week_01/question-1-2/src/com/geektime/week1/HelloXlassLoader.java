package com.geektime.week1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author YangMin
 * @date 2020-10-19 22:04:05
 */
public class HelloXlassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String fullClassName) {
        byte[] classBytes = null;
        Class clazz = null;

        try {
            String xlassFileName = fullClassName.substring(fullClassName.lastIndexOf(".") + 1) + ".xlass";
            URI uri = HelloXlassLoader.class.getResource(xlassFileName).toURI();
            Path path = Paths.get(uri);
            byte[] xlassBytes = Files.readAllBytes(path);
            classBytes = convertByte(xlassBytes);
            clazz = defineClass(fullClassName,classBytes,0,classBytes.length);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return clazz;
    }

    private byte[] convertByte(byte[] xlassBytes) {
        byte[] classBytes = new byte[xlassBytes.length];
        for(int i = 0;i < xlassBytes.length;i++) {
            classBytes[i] = (byte)(0xFF ^ xlassBytes[i]);
        }
        return classBytes;
    }
}
