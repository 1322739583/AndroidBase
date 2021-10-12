package com.xzh.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

    public void generateAppCode(String appKey, String appSecret) {
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
            if (fileToString.contains("MobSDK.spEdition")) {
                System.out.println("已经存在MobSDK.spEdition属性，结束代码");
            } else {
                FileUtils.write(sourcefile, "MobSDK.spEdition=FP", StandardCharsets.UTF_8, true);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void generateManifest() {
        File sourcefile = new File("app/src/main/AndroidManifest.xml");
        File targetfile = new File("utils/tmp/AndroidManifest.xml");

        try {
            String fileToString = FileUtils.readFileToString(targetfile, StandardCharsets.UTF_8);
            if (fileToString.contains(".App")) {
                return;
            }
            FileUtils.write(targetfile, "", StandardCharsets.UTF_8);
            List<String> list = FileUtils.readLines(sourcefile, StandardCharsets.UTF_8);
            for (String s : list) {
                FileUtils.write(targetfile, s + "\n", StandardCharsets.UTF_8, true);
                //不会有空格
                if (s.contains("<application")) {
                    FileUtils.write(targetfile, "\t\tandroid:name=\".App\"", StandardCharsets.UTF_8, true);
                }
            }
            FileUtils.copyFile(targetfile, sourcefile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过dom4j解析xml实现
     */
    private void generateManifestByDom() {

        File sourcefile = new File("app/src/main/AndroidManifest.xml");
        try {
            Document document = DomUtil.load(sourcefile);
            Element rootElement = document.getRootElement();
            Element application = rootElement.element("application");

            Attribute name = application.attribute("name");

            if (name == null) {
                application.addAttribute("android:name", ".App");
                System.out.println("不存在name属性");
            }

            DomUtil.doc2XmlFile(document, sourcefile);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void generateApplication() {
        File sourcefile = new File("app/build.gradle");
        String packageName = "";
        try {
            List<String> lines = FileUtils.readLines(sourcefile, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.contains("applicationId")) {

                    if (line.contains("'")) {
                        packageName = line.substring(line.indexOf("'") + 1, line.length() - 1);
                    } else {
                        packageName = line.substring(line.indexOf("\"") + 1, line.length() - 1);
                    }
                    System.out.println(packageName);
                    break;
                }
            }
            String packagePath = packageName.replace(".", "/");
            String applicationCode = "package " + packageName + ";\n" +
                    "\n" +
                    "import android.app.Application;\n" +
                    "\n" +
                    "public class App extends Application {\n" +
                    "    @Override\n" +
                    "    public void onCreate() {\n" +
                    "        super.onCreate();\n" +
                    "    }\n" +
                    "}";
            File targetFile = new File("app/src/main/java/" + packagePath + "/App.java");
            //FileUtils.touch(targetFile);
            //前提是目录已经存在
            if (!targetFile.exists()) {
                FileUtils.touch(targetFile);
                //不会创建文件，但会创建目录
                //在sources root下和在普通目录下是不太一样的
                FileUtils.writeStringToFile(targetFile, applicationCode, StandardCharsets.UTF_8);
            }
            String fileToString = FileUtils.readFileToString(targetFile, StandardCharsets.UTF_8);
            if (fileToString.contains("MobSDK.submitPolicyGrantResult")) {
                return;
            }
            File tmpApplication = new File("utils/tmp/Application.java");
            FileUtils.touch(tmpApplication);
            FileUtils.write(tmpApplication, "", StandardCharsets.UTF_8);
            List<String> readLines = FileUtils.readLines(targetFile, StandardCharsets.UTF_8);
            for (String readLine : readLines) {
                FileUtils.write(tmpApplication, readLine + "\n", StandardCharsets.UTF_8, true);
                //插入initMob方法
                if (readLine.matches(".*public.*class.*\\{")) {
                    String mobMethod = "\n\tprivate void initMob() {\n" +
                            "\t\tMobSDK.submitPolicyGrantResult(true,null);\n" +
                            "\t}\n\n";
                    FileUtils.write(tmpApplication, mobMethod, StandardCharsets.UTF_8, true);
                }
                //在onCreate方法中调用initMob方法
                if (readLine.matches(".*super.onCreate.*")) {
                    String invokeMethod = "\t\tinitMob();\n";
                    FileUtils.write(tmpApplication, invokeMethod, StandardCharsets.UTF_8, true);
                }
            }

            FileUtils.copyFile(tmpApplication, targetFile);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MobGenerator generator = new MobGenerator();
//        generator.generateRootCode();
//        generator.generateAppCode("123456","123456");
//        generator.generatePropertiesCode();
        //  generator.generateApplication();
        //  generator.generateManifest();
        generator.generateManifestByDom();

    }


}
