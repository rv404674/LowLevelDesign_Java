package rateLimiter.policies;

public interface IRateLimitingPolicy {
    boolean isAllowed(String uuid);
}
