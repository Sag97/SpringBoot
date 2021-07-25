package com.aiguo.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * 这是一个springboot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        //1.返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 3.从容器中获取组件

     /*   Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("组件：" + (tom01 == tom02));

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。
        // springboot总会检查这个组件是否在容器中注册了
        //保持组件单实例
        User user = bean.user01();
        System.out.println(user);
        User user1 = bean.user01();
        System.out.println(user == user1);


        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);

        System.out.println("用户的宠物：" + (user01.getPet() == tom));*/


        boolean tom = run.containsBean("tom");
        System.out.println("容器中的tom组件：" + tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中的user组件：" + user01);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha " + haha);
        System.out.println("hehe " + hehe);


    }
}
