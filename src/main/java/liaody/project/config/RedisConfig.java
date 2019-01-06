package liaody.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
//@EnableCaching
//@ConfigurationProperties(prefix = "spring.redis.", ignoreUnknownFields = false)
@PropertySource("classpath:redis.properties")
public class RedisConfig {

//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        // 设置缓存有效期一小时
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofHours(1));
//        return RedisCacheManager
//                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
//                .cacheDefaults(redisCacheConfiguration).build();
//    }
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        // key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
//        // 所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
//        // 或者JdkSerializationRedisSerializer序列化方式;
//        // Long类型不可以会出现异常信息;
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        return redisTemplate;
//    }
    @Value("${spring.redis.jedis.pool.max.idle}")
    private Integer maxIdle;
    @Value("${spring.redis.jedis.pool.max.total}")
    private Integer maxTotal;
    @Value("${spring.redis.jedis.pool.max.wait}")
    private Integer maxWaitMillis;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.host}")
    private String hostName;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;

    /**
     *  RedisConnectionFactory-RedisConnection(实现类JedisConnection)-封装了Redis客户端，如Jedis Jedis是对Redis的封装
     */
   // private RedisConnectionFactory connectionFactory = null;

    /**
     * 配置Redis连接工厂，使用Jedis作为客户端
     * @return 连接工厂
     */
//    @Bean(name="redisConnectionFactory")
//    public RedisConnectionFactory initRedisConnectionFacoty(){
//        if(this.connectionFactory != null){
//            return connectionFactory;
//        }
//        JedisPoolConfig config = new JedisPoolConfig();
//        // 设置最大空闲数
//        config.setMaxIdle(maxIdle);
//        // 最大连接数
//        config.setMaxTotal(maxTotal);
//        //最大等待毫秒数
//        config.setMaxWaitMillis(maxWaitMillis);
//        // 创建连接工厂
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(config);
//        // 获取单机版的配置
//        RedisStandaloneConfiguration standaloneConfiguration = jedisConnectionFactory.getStandaloneConfiguration();
//        standaloneConfiguration.setDatabase(database);
//        standaloneConfiguration.setHostName(hostName);
//        standaloneConfiguration.setPassword(password);
//        standaloneConfiguration.setPort(port);
//        this.connectionFactory  = jedisConnectionFactory;
//        return connectionFactory;
//    }

    /**
     * 配置RedisTemplate
     * @return redisTemplate
     */
//    @Bean(name="redisTemplate")
//    public RedisTemplate<Object,Object> initRedisTemplate(){
//        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
//        // redis会自动初始化StringRedisSerializer，可以直接获取。
//        RedisSerializer keySerializer = redisTemplate.getStringSerializer();
//        redisTemplate.setKeySerializer(keySerializer);
//        redisTemplate.setValueSerializer(keySerializer);
//        redisTemplate.setHashKeySerializer(keySerializer);
//        redisTemplate.setHashValueSerializer(keySerializer);
//        redisTemplate.setConnectionFactory(initRedisConnectionFacoty());
//        return redisTemplate;
//    }





}
