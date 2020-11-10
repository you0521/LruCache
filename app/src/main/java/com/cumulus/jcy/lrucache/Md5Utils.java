package com.cumulus.jcy.lrucache;

import java.security.MessageDigest;

/**
 * 创建者：  jcy
 * 日期：15:28
 * 时间：2019/4/25
 * 内容：本地缓存中用到的Md5Util工具类
 */

public class Md5Utils {
    public static String encode(String pwd) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] bs = digest.digest(pwd.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bs) {
                int number = b & 0xff;
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(number);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
