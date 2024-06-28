package InMemoryQueue.udit.handlers;

import InMemoryQueue.udit.models.Message;
import InMemoryQueue.udit.models.Topic;
import InMemoryQueue.udit.models.TopicSubscriber;

public class SubscriberThread implements Runnable{
    private Topic topic;
    private TopicSubscriber topicSubscriber;

    public SubscriberThread(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run() {
        synchronized (topicSubscriber){
            do {
                int curOffset = topicSubscriber.getOffset();
                while(curOffset == topic.getMessages().size()){
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Message message = topic.getMessages().get(curOffset);
                try {
                    topicSubscriber.getSubscriber().consume(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                topicSubscriber.setOffset(topicSubscriber.getOffset()+1);
            }while(true);
        }
    }

    synchronized public void wakeUpIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }


}
