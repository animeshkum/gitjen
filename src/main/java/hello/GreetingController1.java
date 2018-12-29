package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController1 {

    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String template = "Hello1, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting1 greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting1(counter.incrementAndGet(),
                String.format(template, name));
    }

    /*@RequestMapping("/redis")
    public String redis() {
        int counter1 = 0;
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        String key = "redis.counter";
        if (!this.redisTemplate.hasKey(key)) {
            ops.set(key,Integer.toString(counter1));
            System.out.println("key not found");
        } else {
            counter1 = Integer.parseInt(ops.get(key));

            counter1++;
            ops.set(key, Integer.toString(counter1));
            System.out.println("key found" + counter1);
        }
        return ops.get(key);
    } */



}
