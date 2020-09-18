package com.zhishouwei.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
@Slf4j
public class StringUtils {


    /**
     * 驼峰转下划线
     * @param str   源字符串
     * @return  转化结果
     */
    public static String toUnderlineCase(CharSequence str) {
        return toSymbolCase(str, '_');
    }

    /**
     * 包名转化为文件路径名
     * @param packageName   包名
     * @return  文件路径
     */
    public static String packageToPath(String packageName) {
        if (packageName != null && packageName.length() > 0) {
            packageName = packageName.replace(".", "/");
        }
        return packageName;
    }

    /**
     * 大小写转化
     * @param str   需要转化的字符串
     * @param symbol    替换标识
     * @return  新字符串
     */
    public static String toSymbolCase(CharSequence str, char symbol) {
        if (str == null) {
            return null;
        } else {
            int length = str.length();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < length; ++i) {
                char c = str.charAt(i);
                Character preChar = i > 0 ? str.charAt(i - 1) : null;
                if (Character.isUpperCase(c)) {
                    Character nextChar = i < str.length() - 1 ? str.charAt(i + 1) : null;
                    if (null != preChar && Character.isUpperCase(preChar)) {
                        sb.append(c);
                    } else if (null != nextChar && Character.isUpperCase(nextChar)) {
                        if (null != preChar && symbol != preChar) {
                            sb.append(symbol);
                        }

                        sb.append(c);
                    } else {
                        if (null != preChar && symbol != preChar) {
                            sb.append(symbol);
                        }

                        sb.append(Character.toLowerCase(c));
                    }
                } else {
                    if (sb.length() > 0 && Character.isUpperCase(sb.charAt(sb.length() - 1)) && symbol != c) {
                        sb.append(symbol);
                    }

                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

    private static File findDict(File file, String name ) {
        try {
            log.info("file path {} ===== {}", file.getCanonicalPath(), name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<File> dics = new ArrayList<>();
        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    if (name.equals(item.getName())) {
                        return item;
                    } else {
                        dics.add(item);
                    }
                }
            }
        }
        if (dics.size() > 0) {
            for (File item : dics) {
                File f = findDict(item, name);
                if (f != null){
                    return f;
                }
            }
        }
        return null;
    }
    // 深度优先遍历
    public static File findFile(File file, String name) {
        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    if (name.equals(item.getName())) {
                        return item;
                    } else {
                        File f = findFile(item, name);
                        if (f != null) {
                            return f;
                        }
                    }
                }
            }
        }
        return null;
    }
    public static String getProjectPath(String projectPath, String appName) {
        File path = new File(projectPath);
        File find = StringUtils.findFile(path, appName);
        if (find == null) {
            return null;
        } else {
            try {
                projectPath = find.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return projectPath;
    }

    public static String getPackagePath(String projectPath, String projectName) {

        projectPath = projectPath + "/src/main/java";

        File packageFile = new File(projectPath);
        File file = getDirectory(packageFile, projectName);
        String name = null;
        try {
            name = file.getCanonicalPath().replace(projectPath+"/", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("======= getPackagePath {}", name);
        return name;
    }

    public static File getDirectory(File file, String pak) {
        if (file.isDirectory()) {
            if (pak.equals(file.getName())) {
                return file;
            } else {
                for (File item : file.listFiles()) {
                    if (pak.equals(item.getName())) {
                        return item;
                    } else
                    if (item.isDirectory()) {
                        file = getDirectory(item, pak);
                    }
                }
            }
        } else {
            return null;
        }
        return file;
    }
    public static String getPackageName(String projectPath, String projectName) {

        log.info("{}----getPackageName------ {}", projectPath, projectName);
        String name = getPackagePath(projectPath, projectName);
        name = name.replace("src/main/java/", "");
        return name.replace("/", ".");
    }
}
