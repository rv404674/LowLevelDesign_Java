package InMemoryQueue.udit;

import InMemoryQueue.udit.models.Message;
import InMemoryQueue.udit.models.Topic;
import InMemoryQueue.udit.publicinterfaces.InMemoryQueue;

// Video - https://www.youtube.com/watch?v=4BEzgPlLKTo&t=69s
public class InMemoryQueueMainUdit {
    public static void main(String[] args) throws InterruptedException {
        InMemoryQueue memoryQueue = new InMemoryQueue();
        Topic topic1 = memoryQueue.createTopic("t1");
        Topic topic2 = memoryQueue.createTopic("t2");
        SleepingSubscriber subscriber1 = new SleepingSubscriber("sub1", 10000);
        SleepingSubscriber subscriber2 = new SleepingSubscriber("sub2", 10000);
        memoryQueue.subscribe(subscriber1, topic1);
        memoryQueue.subscribe(subscriber2, topic1);

        SleepingSubscriber subscriber3 = new SleepingSubscriber("sub3", 5000);
        memoryQueue.subscribe(subscriber3, topic2);

        memoryQueue.publish(topic1, new Message("m1"));
        memoryQueue.publish(topic1, new Message("m2"));

        memoryQueue.publish(topic2, new Message("m3"));


        Thread.sleep(15000);
    }
}
