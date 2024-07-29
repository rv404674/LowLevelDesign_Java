package rateLimiter;

import rateLimiter.policies.IRateLimitingPolicy;
import rateLimiter.policies.TokenBucketPolicy;

public class MainApp {
    public static void main(String[] args) {
        // 10 RPM
        IRateLimitingPolicy policy = new TokenBucketPolicy(1000, 10);
        policy.isAllowed("12343");
    }
}
