import redis.clients.jedis.Jedis;

public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.incr("starts");
        System.out.println("Programstarts: " + jedis.get("starts"));
    }
}
