package liaody.project.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/stringAndHash")
    @ApiOperation(value="String And Hash", notes="Redis")
    public String stringAndHash() {
        //  默认使用了jdk序列化器，所以保存的Redis不是证书，不能够进行运算。
        redisTemplate.opsForValue().set("ket1","value1");
        redisTemplate.opsForValue().set("int_key",1);
        redisTemplate.opsForValue().set("int",1);
        return null;
    }
}
