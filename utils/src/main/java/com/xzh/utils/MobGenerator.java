package com.xzh.utils;

import com.google.common.io.Files;
import com.google.common.io.LineReader;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MobGenerator {
    /**
     * 生成root的build.gradle文件
     */
    public void generateRootCode() {
        File sourcefile = new File("build.gradle");
        File targetfile = new File("utils/testRoot.gradle");


        try {
            String fileString = FileUtils.readFileToString(sourcefile, StandardCharsets.UTF_8);
            if (!fileString.contains("com.mob.sdk:MobSDK")) {

                FileUtils.write(targetfile, "", StandardCharsets.UTF_8, false);
                LineIterator lineIterator = FileUtils.lineIterator(sourcefile);
                while (lineIterator.hasNext()) {
                    String line = lineIterator.nextLine();

                    FileUtils.write(targetfile, line + "\n", StandardCharsets.UTF_8, true);

                    if (line.contains("com.android.tools.build:gradle")) {
                        String code = "\t\tclasspath 'com.mob.sdk:MobSDK:2018.0319.1724'\n";
                        FileUtils.write(targetfile, code, StandardCharsets.UTF_8, true);
                    }

                    if (line.matches(".*repositories.*\\{.*")) {
                        String code = "\t\tmaven { url 'https://mvn.mob.com/android'}\n";
                        FileUtils.write(targetfile, code, StandardCharsets.UTF_8, true);
                    }

                    FileUtils.copyFile(targetfile, sourcefile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void generateAppCode(String appKey,String appSecret) {
        File sourcefile = new File("app/build.gradle");
        File targetfile = new File("utils/testApp.gradle");


        try {
            String fileString = FileUtils.readFileToString(sourcefile, StandardCharsets.UTF_8);
            if (!fileString.contains("com.mob.sdk")) {
                FileUtils.write(targetfile, "", StandardCharsets.UTF_8, false);
                LineIterator lineIterator = FileUtils.lineIterator(sourcefile);
                while (lineIterator.hasNext()) {
                    String line = lineIterator.nextLine();

                    FileUtils.write(targetfile, line + "\n", StandardCharsets.UTF_8, true);
                    //apply plugin:'com.android.application'
                    boolean matches = line.matches(".*apply.*com\\.android\\.application.*");

                    if (line.matches(".*apply.*com\\.android\\.application.")) {
                        System.out.println("matches " + matches);
                        String code = "apply plugin: 'com.mob.sdk'\n" +
                                "MobSDK {\n" +
                                "\tappKey " + "'" + appKey + "'\n" +
                                "\tappSecret " + "'" + appSecret + "'\n" +
                                "};\n";
                        FileUtils.write(targetfile, code, StandardCharsets.UTF_8, true);
                    }

                    FileUtils.copyFile(targetfile, sourcefile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generatePropertiesCode() {

        File sourcefile = new File("gradle.properties");

        try {
            String fileToString = FileUtils.readFileToString(sourcefile, StandardCharsets.UTF_8);
            if (fileToString.contains("MobSDK.spEdition")){
                System.out.println("已经存在MobSDK.spEdition属性，结束代码");
            }else {
                FileUtils.write(sourcefile,"MobSDK.spEdition=FP",StandardCharsets.UTF_8,true);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MobGenerator generator = new MobGenerator();
        generator.generateRootCode();
        generator.generateAppCode("123456","123456");
        generator.generatePropertiesCode();
    }


}
