package liaody.project.util;

import liaody.project.config.RedisConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate template = ctx.getBean(RedisTemplate.class);
        template.opsForValue().set("boo1","tttt");
        Object boo = template.opsForValue().get("boo1");
        System.out.println(boo);
        // ApplicationContext ctx = new AnnatationConfigApplicationContext(RedisConfig.class);
    }
}
