package com.xzh.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SignUtil {


    private static void ps() {
        try {
            // 此处用于填写需要执行的命令，规则设定真实执行中需要空格的地方，
            // 这里变成String数组的来间隔开，至于sh -c命令建议网上自行脑补，
            // 我们这次执行的实际命令是查询目前linux系统存在的tomcat进程，
            // 命令如右：ps -ef|grep tomcat
            String[] cmd = {"sh", "-c", "./gradlew signingReport >utils/tmp/sign.log"};
            Process p = Runtime.getRuntime().exec(cmd);//创建实例进程执行命令行代码
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
         ps();
        List<SignModel> signModels = convert2SignList();
        for (SignModel signModel : signModels) {
            boolean variantNotEmpty = StringUtils.isNotEmpty(signModel.getVariant());
            if (variantNotEmpty&&signModel.getVariant().equals("debug")){
                System.out.println(signModel);
            }
        }


       //  System.out.println(signModels);
    }

    private static List<SignModel> convert2SignList() {
        File file=new File("utils/tmp/sign.log");
        List<SignModel> signModels=new ArrayList<>();
        try {
            String fileToString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            String[] split = fileToString.split("----------");
            File tmp=new File("utils/tmp/tmpLine.txt");
            //不计算最后一个
            for (int i = 0; i < split.length-1; i++) {

                SignModel signModel=new SignModel();

                FileUtils.write(tmp,split[i],StandardCharsets.UTF_8);
                //分成多组
                List<String> lines = FileUtils.readLines(tmp, StandardCharsets.UTF_8);
                //将每组内容封装进SignModel
                for (String line : lines) {

                    if (line.contains("Variant:")){
                        signModel.setVariant(line.split(":")[1].trim());
                    }else if (line.contains("Config:")){
                        signModel.setConfig(line.split(":")[1].trim());
                    }else if (line.contains("Store:")){
                        signModel.setStore(line.split(":")[1].trim());
                    }else if (line.contains("Alias:")){
                        signModel.setAlias(line.split(":")[1].trim());
                    }else if (line.contains("MD5:")){
                        signModel.setMd5(line.substring(line.indexOf(":")+1).trim());
                    }else if (line.contains("SHA1:")){
                        signModel.setSha1(line.substring(line.indexOf(":")+1).trim());
                    }else if (line.contains("SHA-256:")){
                        signModel.setSha256(line.substring(line.indexOf(":")+1).trim());
                    }else if (line.contains("Valid until:")){
                        signModel.setValidUntil(line.substring(line.indexOf(":")+1).trim());
                    }
                }
                signModels.add(signModel);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return signModels;

    }


}
