package com.zhishouwei.common.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.zhishouwei.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@Slf4j
public class StringUtils {

    /**
     * 默认加密
     *
     * @param data 需要加密的数据
     * @return  encrypt data
     * @throws ServiceException 异常
     */
    public static String encryptDefault(String data) throws ServiceException {
        return encrypt(data, Constants.ASC_PASSWORD);
    }

    /**
     * 默认解密
     *
     * @param data 需要解密的数据
     * @return 解密后的数据
     * @throws ServiceException 异常
     */
    public static String decryptDefault(String data) throws ServiceException {
        return decrypt(data, Constants.ASC_PASSWORD);
    }

    /**
     * 加密
     *
     * @param data 要加密的数据
     * @param key  秘钥
     * @return string
     * @throws ServiceException 异常
     */
    public static String encrypt(String data, String key) throws ServiceException {
        try {
            //实例化加密算法
            AES aes = SecureUtil.aes(key.getBytes());
            return aes.encryptBase64(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("数据加密失败");
        }

    }


    /**
     * 解密
     *
     * @param encryptData 要解密的数据
     * @param key         秘钥
     * @return string
     * @throws ServiceException 异常
     */
    public static String decrypt(String encryptData, String key) throws ServiceException {
        try {
            AES aes = SecureUtil.aes(key.getBytes());
            return aes.decryptStr(encryptData);
        } catch (Exception e) {
            throw new ServiceException("数据解密失败");
        }

    }


    /**
     * 驼峰转下划线
     * @param str   源字符串
     * @return  转化结果
     */
    public static String toUnderlineCase(CharSequence str) {
        return toSymbolCase(str, '_');
    }

    /**
     * 下划线转驼峰
     * @param param 源字符串
     * @return 转化结果
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        boolean flag = false; // "_" 后转大写标志,默认字符前面没有"_"
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == '_') {
                flag = true;
            } else {
                if (flag) {
                    //表示当前字符前面是"_" ,当前字符转大写
                    sb.append(Character.toUpperCase(param.charAt(i)));
                    flag = false;  //重置标识
                } else {
                    sb.append(Character.toLowerCase(param.charAt(i)));
                }
            }
        }
        return sb.toString();
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

    /**
     * 判断字符串是否符合手机号码格式
     * 移动号段:   134 135 136 137 138 139 147 148 150 151 152 157 158 159  165 172 178 182 183 184 187 188 198
     * 联通号段:   130 131 132 145 146 155 156 166 170 171 175 176 185 186
     * 电信号段:   133 149 153 170 173 174 177 180 181 189  191  199
     * 虚拟运营商: 170
     * @param res 待检测的字符串
     * @return 是否为手机号
     */

    public static boolean isMobile(String res) {
        final String regular = "^((13[0-9])|(14[5,6,7,9])|(15[^4])|(16[5,6])|(17[0-9])|(18[0-9])|(19[1,8,9]))\\d{8}$";
        if (org.springframework.util.StringUtils.isEmpty(res)) {
            return false;
        }
        return res.matches(regular);
    }

    /**
     * 判断是否为openid
     * 微信openid：a-z,A-Z,0-9组成的28位
     * 微博uid：10位数字
     * 腾讯QQopenid：32位HEX
     * @param res   待检测的字符串
     * @return 是否为openId
     */
    public static boolean isOpenID(String res) {
        boolean isOK = false;
        if (res != null && ((res.length() == 28  &&
                res.matches("[a-zA-Z0-9]{28}")) // 微信openid
                || (res.length() == 10 && Long.getLong(res) != null) //微博uid
                || (res.length() == 32 && res.matches("[a-hA-H0-9]{32}")) //腾讯QQopenid
        )) {
            isOK = true;
        }
        return isOK;
    }

    /**
     * 空判断
     * @param res 源字符
     * @return true or false
     */
    public boolean isEmpty(String res) {
        return org.springframework.util.StringUtils.isEmpty(res);
    }


    /**
     * 遍历文件目录
     * @param file  目录名
     * @param name  文件名
     * @return      文件
     */
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
                    if ("target".equals(item.getName())) {
                        continue;
                    }
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

    /**
     * 深度优先遍历
     * @param file 目录名
     * @param name 文件名
     * @return 文件
     */
    // 深度优先遍历
    public static File findFile(File file, String name) {
        if (file.isDirectory()) {
            for (File item : Objects.requireNonNull(file.listFiles())) {
//                log.info("========find file {}", file.toString());
                if (item.isDirectory()) {
                    if ("target".equals(item.getName())) {
                        continue;
                    }
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

    private static String getPackagePath(String projectPath, String projectName) {

        if (!projectPath.contains("/src/main/java")) {
            projectPath = projectPath + "/src/main/java";
        }

        File packageFile = new File(projectPath);
        File file = getDirectory(packageFile, projectName);
        String name = null;
        try {
            name = Objects.requireNonNull(file).getCanonicalPath().replace(projectPath+"/", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("======= getPackagePath {}", name);
        return name;
    }

    private static File getDirectory(File file, String pak) {
        if (file.isDirectory()) {
            if (pak.equals(file.getName())) {
                return file;
            } else {
                for (File item : Objects.requireNonNull(file.listFiles())) {
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

        log.info("{} ----getPackageName------ {}", projectPath, projectName);
        String name = getPackagePath(projectPath, projectName);
        name = name.substring(name.indexOf("src/main/java/"));
        name = name.replace("src/main/java/", "");
        return name.replace("/", ".");
    }

}
