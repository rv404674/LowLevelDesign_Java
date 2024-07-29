package rateLimiter.policies;

public class TokenBucketPolicy implements IRateLimitingPolicy {
    private long maxBucketSize;

    // per minute.
    private long refillRate;
    private long currentBucketSize;
    private long lastRefillTimeStamp;

    public TokenBucketPolicy(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        this.currentBucketSize = maxBucketSize;
        this.lastRefillTimeStamp = System.currentTimeMillis();
    }

    @Override
    public boolean isAllowed(String uuid) {
        refill();

        if (currentBucketSize <= 0) {
            System.out.println(uuid + " is being rate Limited.");
            return false;
        }

        this.currentBucketSize -= 1;
        System.out.println(uuid + "forwarded to the backend systems");
        return true;
    }


    // NOTE:
    // bucket size = 1000
    // refillRate = 10RPM.
    // if within last 10mins, no request came, the bucket
    public void refill() {
        long now = System.currentTimeMillis();
        long elapsedMins = (now - this.lastRefillTimeStamp) / 60 * 1000;

        long tokensToAdd = elapsedMins * refillRate;
        if (tokensToAdd > 0) {
            this.currentBucketSize = Math.min(tokensToAdd + currentBucketSize, this.maxBucketSize);
            this.lastRefillTimeStamp = now;
        }
    }
}
