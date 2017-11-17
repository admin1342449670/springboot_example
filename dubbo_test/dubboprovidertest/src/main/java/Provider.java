import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        //这里采用服务方式启动provider
        //加载dubbo配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-provider.xml"});

        context.start();

        System.out.println("provider服务开启...");

        System.in.read();

    }
}
