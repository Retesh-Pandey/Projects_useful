import java.util.*;

class RateLimiter {
    private final int limit;
    private final long windowMillis;
    private final Map<String, Queue<Long>> requests = new HashMap<>();

    public RateLimiter(int limit, long windowMillis) {
        this.limit = limit;
        this.windowMillis = windowMillis;
    }

    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();

        requests.putIfAbsent(userId, new LinkedList<>());
        Queue<Long> queue = requests.get(userId);

        while (!queue.isEmpty() && now - queue.peek() > windowMillis) {
            queue.poll();
        }

        if (queue.size() < limit) {
            queue.offer(now);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter(3, 10000);

        for (int i = 1; i <= 5; i++) {
            System.out.println("Request " + i + ": "
                    + limiter.allowRequest("user123"));
        }
    }
}