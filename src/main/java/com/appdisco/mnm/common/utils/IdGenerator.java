/**
 * Project		: MileNMile
 * FileName		: IdGenerator.java
 * Package		: com.appdisco.mnm.common.utils
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 15. 오후 12:42:46
 */
package com.appdisco.mnm.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.utils.IdGenerator
 * @file	: IdGenerator.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 15. 오후 12:42:46
 * </PRE>
 */
public class IdGenerator {

    /**
     * Gets the uuid.
     *
     * @return the uuid
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * Gets the secret code.
     *
     * @return the secret code
     */
    public static String getSecretCode() {
        return Base64.encode(getUUID().substring(16).getBytes()).replaceAll("=", "");
    }

    /**
     * Gets the coupon code.
     *
     * @return the coupon code
     */
    public static String getCouponCode() {
        String strAlphabet = "";
        Integer intNumber1 = null;
        Integer intNumber2 = null;
        String num1 = "";
        String num2 = "";
        Integer couponSeq = (int) (System.currentTimeMillis() / 10000);
        Integer countSeq = Integer.toString(couponSeq).length();
        Random oRandom = new Random();
        int j = oRandom.nextInt(5) + 2; //문자개수(2~6)
        int k = 16 - j - countSeq; //문자와일련번호를제외한수(랜덤생성할수)
        int p = oRandom.nextInt(k) + countSeq + 1; //문자시작자리

        for (int o = 1; o <= j; o++) {
            char ch = (char) ((Math.random() * 26) + 65); //대문자
            strAlphabet = strAlphabet + ch;
        }
        for (int l = 1; l < (p - countSeq); l++) {
            intNumber1 = oRandom.nextInt(9) + 1;
            num1 = num1 + Integer.toString(intNumber1);
        }
        for (int m = (p - countSeq); m <= k; m++) {
            intNumber2 = oRandom.nextInt(9) + 1;
            num2 = num2 + Integer.toString(intNumber2);
        }

        //쿠폰번호
        return num1 + couponSeq + strAlphabet + num2;
    }
    
    
    /**
     * The test method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        System.out.println(getUUID());
        System.out.println(getSecretCode());

        for (int i = 0; i < 30; i++) {
            System.out.println("==" + getCouponCode() + "--");
        }
    }

}
