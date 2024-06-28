package InMemoryQueue.udit.models;

import InMemoryQueue.udit.handlers.SubscriberThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Topic {
    HashMap<String, SubscriberThread> subscriberThreadHashMap;
    private String topicName;
    private String topicId;
    private List<Message> messages;
    private List<TopicSubscriber> subscribers;

    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
        this.subscriberThreadHashMap = new HashMap<>();
    }

    public synchronized void addMessage(Message message) {
        this.messages.add(message);
    }

    public void addSubscribe(TopicSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber : this.getSubscribers()) {
            startSubscriberThread(topicSubscriber);
        }
    }


    /**
     * Spin up a new thread for each subscriber.
     * And to save resources, save the thread, so that it can be used again.
     *
     * @param topicSubscriber
     */
    public void startSubscriberThread(TopicSubscriber topicSubscriber) {
        String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!this.subscriberThreadHashMap.containsKey(subscriberId)) {
            SubscriberThread subscriberThread = new SubscriberThread(this, topicSubscriber);
            this.subscriberThreadHashMap.put(subscriberId, subscriberThread);
            new Thread(subscriberThread).start();
            return;
        }

        SubscriberThread subscriberThread = this.subscriberThreadHashMap.get(subscriberId);
        subscriberThread.wakeUpIfNeeded();
    }


    public String getTopicName() {
        return topicName;
    }

    public String getTopicId() {
        return topicId;
    }

    public List<TopicSubscriber> getSubscribers() {
        return subscribers;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
