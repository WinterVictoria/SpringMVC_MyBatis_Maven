package com.yan.demo.util;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by wangyan on 2018/8/15.
 */
public class SystemUtil {

    /**
     * @param plainText
     *            明文
     * @return 32位密文
     */
    public static String MD5Encode(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

    /**
     * 验证请求的有效性
     *
     * @param userId
     * @param timeCheck
     * @param pstr
     * @return
     */
    public static boolean validPstr(String userId, String timeCheck, String pstr) {
        String secret = "";
        String key = "yst&#bpii*9d^i97kkyI";
        secret = MD5Encode(userId + timeCheck + key);
        return secret.equalsIgnoreCase(pstr)?true:false;
    }

    /**
     * 调用接口失败，返回相失败信息
     *
     * @param flag 0:安全校验失败 1：未查询到数据
     * @return
     */
    public static String errorResult(int flag) {
        String xml = "";
        Document document = DocumentHelper.createDocument();
        Element warn = document.addElement("warn");
        Element warn_flag = warn.addElement("warn_flag");
        Element warn_msg = warn.addElement("warn_msg");
        if (flag == 0) {
            warn_flag.setText("0");
            warn_msg.setText("数据接口安全校验失败！");
        } else if (flag == 1) {
            warn_flag.setText("1");
            warn_msg.setText("未检索到信息!");
        }
        xml = document.asXML();
        return xml;
    }

    public static void main(String[] args) {
        String ss = errorResult(0);
        System.out.println(ss);
    }


}