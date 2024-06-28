package InMemoryQueue.udit;

import InMemoryQueue.udit.models.Message;
import InMemoryQueue.udit.publicinterfaces.ISubscriber;

public class SleepingSubscriber implements ISubscriber {
    private final String id;
    private final int sleepTimeInMillis;

    public SleepingSubscriber(String id, int sleepTimeInMillis) {
        this.id = id;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber: " + id + " Started consuming: " + message.getMsg());
        Thread.sleep(sleepTimeInMillis);
        System.out.println("Subscriber: " + id + " Done consuming: " + message.getMsg());
    }

}
