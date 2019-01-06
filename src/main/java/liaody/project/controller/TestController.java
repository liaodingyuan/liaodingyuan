package liaody.project.controller;

import liaody.project.config.RedisConfig;
import liaody.project.util.RedisUtil;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping(value = "/swagger")
    //@RequestMapping("/swagger")
    //@RequestMapping(value = "/swagger",method = RequestMethod.POST)
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        //return new String("swagger测试");
        return redisUtil.get(name);
    }





}
