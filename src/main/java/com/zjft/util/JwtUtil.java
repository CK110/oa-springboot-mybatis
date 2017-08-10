package com.zjft.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zjft.entity.UserDO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by CK on 2017/8/8.
 */
public class JwtUtil {

    private static final String SIGN_KEY = "1qaz!@#$2wsx%^&*3edc";

    private static final String JWT_ISSUSER = "zjft.com";

    private static final String JWT_TOKEN_EXPIRY_SECONDS = "60*60";

    private static final String JWT_SECRET_FOR_TOKEN = "XT6PRpRuehFsyMa2";


    public static String generateToken(UserDO userDO) throws UnsupportedEncodingException {

        Algorithm algorithm = Algorithm.HMAC256(SIGN_KEY);

        String aud = stringMD5(userDO.toString1() + JWT_SECRET_FOR_TOKEN);
        System.out.println("md5:" + aud);
        String token = JWT.create()
                .withIssuer(JWT_ISSUSER)
                .withSubject(aud + "|" + userDO.getUsername() + "|" + userDO.getPassword())
                .sign(algorithm);

        return token;
    }

    public static String stringMD5(String input) {
        try {
            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 输入的字符串转换成字节数组
            byte[] inputByteArray = input.getBytes();
            // inputByteArray是输入字符串转换得到的字节数组
            messageDigest.update(inputByteArray);
            // 转换并返回结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
            // 字符数组转换成字符串返回
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

    }

    public static String byteArrayToHex(byte[] byteArray) {

        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray = new char[byteArray.length * 2];

        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        UserDO u = new UserDO("wjchen", "000001", "xxxx", "0000000000111010");

        String t = JwtUtil.generateToken(u);
        System.out.println(t);

        String s = JWT.decode(t).getSubject();
        System.out.println(s);
    }
}
