package com.hutool;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

public class demo1 {
    public static void main(String[] args) {
        //身份证工具类
        String ID_18 = "622226199610312814";
        boolean valid = IdcardUtil.isValidCard(ID_18);
        Console.log(valid);

        DateTime date = DateUtil.parse("2020-02-01");

        int age = IdcardUtil.getAgeByIdCard(ID_18, date);

        String birth = IdcardUtil.getBirthByIdCard(ID_18);

        Console.log(birth);

        String province = IdcardUtil.getProvinceByIdCard(ID_18);
        Console.log(province);

        String simpleUUID = IdUtil.simpleUUID();
        Console.log(simpleUUID);

        // 生成指定url对应的二维码到文件，宽和高都是300像素
        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("/Users/zhaojixun/Desktop/截屏/qrcode.jpg"));

    }
}
