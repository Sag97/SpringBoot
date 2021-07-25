package com.aiguo.boot.bean;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@ToString
@Data
//@Component
@ConfigurationProperties(prefix = "mycar")
// 必须加@Component 配置到容器 ，或者配置类里面的@EnableConfigurationProperties(Car.class)来配置到容器
public class Car {

    private String brand;
    private Integer price;


}
