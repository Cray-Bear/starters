package com.fty1.center.mock;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@SpringBootApplication
@EnableScheduling
public class CenterMockApplication {

    public static void main(String[] args) throws Exception {

        String basePack = "com.fty1.center.mock";

        List<String> classNames = new ArrayList<>();
        Enumeration<URL> urlEnumeration = Thread.currentThread().getContextClassLoader().getResources(basePack.replace(".", "/"));
        while (urlEnumeration.hasMoreElements()) {
            URL url = urlEnumeration.nextElement();
            String protocol = url.getProtocol();
            if ("jar".equalsIgnoreCase(protocol)) {
                JarURLConnection connection = (JarURLConnection) url.openConnection();
                if (connection != null) {
                    JarFile jarFile = connection.getJarFile();
                    if (jarFile != null) {
                        Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                        while (jarEntryEnumeration.hasMoreElements()) {
                            JarEntry entry = jarEntryEnumeration.nextElement();
                            String jarEntryName = entry.getName();
                            if (jarEntryName.contains(".class") && jarEntryName.replaceAll("/",".").startsWith(basePack)) {
                                String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replace("/", ".");
                                Class cls = Class.forName(className);
                                classNames.add(cls.getCanonicalName());
                            }
                        }
                    }
                }
            }
        }
    }

}
