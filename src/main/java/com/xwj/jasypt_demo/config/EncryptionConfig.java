package com.xwj.jasypt_demo.config;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {
 
    @Bean("xwj")
    public StringEncryptor stringEncryptor() {
        MyStringEncryptor myStringEncryptor = new MyStringEncryptor();//调用我们自己实现的类即可
        return myStringEncryptor;
    }
}