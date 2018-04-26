import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * Connect to Redis. Ensure that you have a running Redis instance
 * and you are exposing the correct port.
 *
 * `docker run -p 6379:6379 redis:alpine`
 */
public class RedisConnect {
    private static Jedis connectRedis() {
        Jedis jedis = new Jedis("localhost");
        try {
            jedis.connect();
        } catch (JedisConnectionException e) {
            System.out.println("You forgot to start Redis. Please start it with this command:");
            System.out.println("λ docker run -p 6379:6379 redis:alpine");
            return null;
        }
        return jedis;
    }

    public static void main(String[] args) {
        Jedis jedis = connectRedis();
        if (jedis != null && jedis.isConnected()) {
            System.out.println("Program starts: " + jedis.incr("starts"));
        }
    }
}
