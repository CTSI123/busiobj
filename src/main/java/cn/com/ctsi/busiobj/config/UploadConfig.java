package cn.com.ctsi.busiobj.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;


@Configuration
public class UploadConfig {

    /**
     * 文件上传配置
     * @return
     */
    @Bean(name="multipartConfig")
    public MultipartConfigElement multipartConfig() {
        MultipartConfigFactory factory= new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("102400KB");//KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("1024000KB");
        return factory.createMultipartConfig();
    }
}
