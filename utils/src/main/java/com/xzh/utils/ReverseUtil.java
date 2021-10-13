package com.xzh.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * 反编译工具类
 */
public class ReverseUtil {
    /**
     * 反编译工具目录
     */
    private static String toolsHome = "/home/xzh/Android/tools/";
    /**
     * apktool.jar 主要用于反编译生成smill文件
     */
    private static String apktool = toolsHome + "apktool.jar";
    /**
     * 用于查看反编译的jar包的源码
     */
    private static String jdGui = toolsHome + "jd-gui.jar";
    /**
     * dex2jar工具，用于将.dex转化为.jar文件，不过官网推荐是直接从apk生成成.jar
     */
    private static String dex2jar=toolsHome+"dex2jar/d2j-dex2jar.sh";

    /**
     * ----------------------------------下面的三个变量需要配置-----------------------------------------------------
     */

    /**
     *  一般这个名字是加上日期的，可以当作解压包名
     */
    private static String apkName = "app-release.apk";

    /**
     * 需要反编译的Apk包
     */
    private static String sourceApk = "app/release/" + apkName;
    /**
     * 反编译文件生成位置
     */
    private static String outPath = "app/build/decompile/"+ apkName.replace(".apk","");


    /**
     * 解压Apk
     */
    public static void unzipApk() {

        try {
            //必须添加>> /dev/null  2>&1不然卡死
            //覆盖也会卡死 需要删除

            File file = new File(outPath);
            if (file.exists()) {
                FileUtils.deleteDirectory(file);
            }
            String[] cmd = {"sh", "-c", "unzip -d " + outPath + " " + sourceApk + " >> /dev/null  2>&1"};
            Process p = Runtime.getRuntime().exec(cmd);//创建实例进程执行命令行代码
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("解压完成");

    }

    /**
     * 调用apktool
     */
    public static void doApkTool() {
        try {
            String[] cmd = {"sh", "-c", "java -jar " + apktool + " d " + sourceApk + " -o app/build/decompile"};
            Process p = Runtime.getRuntime().exec(cmd);//创建实例进程执行命令行代码
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 调用dex2jar
     */
    public static void doDex2Jar() {
      //  unzipApk();
        long start = System.currentTimeMillis();
        System.out.println("开始装换");
        try {
            File file=new File(outPath+"/classes.jar");
            if (file.exists()){
                FileUtils.deleteQuietly(file);
            }
            String[] cmd = {"sh", "-c", " sh " + dex2jar + " -f "+ sourceApk +" -o "+outPath+"/classes.jar >> /dev/null  2>&1  "};
            Process p = Runtime.getRuntime().exec(cmd);//创建实例进程执行命令行代码
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)/1000+"秒");
    }

    /**
     * 调用jd-gui解析jar包内容
     */
    public static void doJdGui() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] cmd = {"sh", "-c", "java -jar " + jdGui +" "+outPath+"/classes.jar >> /dev/null  2>&1"};
                    Process p = Runtime.getRuntime().exec(cmd);//创建实例进程执行命令行代码
                    p.waitFor();
                    p.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public static void main(String[] args) {

        //
        ReverseUtil.doDex2Jar();
        ReverseUtil.doJdGui();
    }
}