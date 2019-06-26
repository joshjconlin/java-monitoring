package com.joshjconlin.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.*;
import javax.management.*;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("com.joshjconlin.monitoring:type=Monitoring");
            mbs.invoke(name, "addCall", null, null);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Hello Docker World";
    }

    public static void main(String[] args) {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("com.joshjconlin.monitoring:type=Monitoring");
            Monitoring mbean = new Monitoring();
            mbs.registerMBean(mbean, name);
            SpringApplication.run(Application.class, args);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
