package com.xwj.jasypt_demo.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;

public class MyStringEncryptor implements StringEncryptor {


    @Override
    public String encrypt(String message) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        // 加密的算法，这个算法是默认的
        config.setAlgorithm("PBEWithMD5AndDES");
        //加密的密钥，自定义
        config.setPassword("xwj");
        standardPBEStringEncryptor.setConfig(config);
        String encryptedText = standardPBEStringEncryptor.encrypt(message);
        return encryptedText;
    }

    @Override
    public String decrypt(String encryptedMessage) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        // 解密的算法，需同加密算法相同
        config.setAlgorithm("PBEWithMD5AndDES");
        //解密的密钥，需同加密密钥相同
        config.setPassword("xwj");
        standardPBEStringEncryptor.setConfig(config);
        String plainText = standardPBEStringEncryptor.decrypt(encryptedMessage);
        return plainText;
    }
}
