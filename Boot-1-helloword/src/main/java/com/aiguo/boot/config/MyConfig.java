package com.aiguo.boot.config;

import com.aiguo.boot.bean.Car;
import com.aiguo.boot.bean.Pet;
import com.aiguo.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Version 1.0
 * @Author:SAG
 * @Date:2021/7/22 1.配置类里使用@Bean 标注在方法上给容器注册组件，默认是单例的
 * 2.配置类本身也是组件\
 * 3.proxyBeanMethods:代理bean 方法
 * full：全模式 proxyBeanMethods = true
 * lite ：轻量级模式 proxyBeanMethods = false
 * 解决组件依赖问题
 */

//@ImportResource("classpath:beans.xml")  导入 spring xml类型的配置文件
//@Import() 导入扫描的外部组件，给容器中自动创建组件
@Configuration(proxyBeanMethods = true)//告诉spring boot这是一个配置类 == 配置文件

@EnableConfigurationProperties(Car.class)
// 1.开启car 的属性配置绑定  2.把car组件自动注册到容器中  这个注解必须在配置类写
public class MyConfig {

    /**
     * 外部无论对这个配置类中的组件组测方法调用多少次，获取的都是之前容器注册的单例对象
     */
    //@ConditionalOnBean(name = "tom")//条件装配，容器中有某个组件的是很好才注册下面的bean
    @Bean//给容器中添加组件，以方法名作为组件的id ，返回类型就是组件类型，返回的值就是在容器中保存的实例
    public User user01() {
        User zhangsan = new User("zhangsan", 22);
        //user 组件依赖了pet组件
        zhangsan.setPet(tomcatpet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatpet() {
        return new Pet("tomcat");
    }
}
