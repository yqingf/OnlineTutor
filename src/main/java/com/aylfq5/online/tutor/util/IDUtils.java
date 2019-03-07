package com.aylfq5.online.tutor.util;

import java.util.Random;

/**
 * @Description: id生成器
 * @Author: aylfq5
 * @CreateDate: 2019/2/28 11:44
 * @Version: 1.0
 */
public class IDUtils {
    /**
     * id生成
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(genItemId());
        }
    }
}
