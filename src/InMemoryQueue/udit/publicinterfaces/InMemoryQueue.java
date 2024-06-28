package InMemoryQueue.udit.publicinterfaces;

import InMemoryQueue.udit.models.Message;
import InMemoryQueue.udit.models.Topic;
import InMemoryQueue.udit.models.TopicSubscriber;

import java.util.UUID;

public class InMemoryQueue {

    public Topic createTopic(final String topicName) {
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        System.out.println("Created Topic " + topic.getTopicName());
        return topic;
    }

    public void subscribe(ISubscriber subscriber, Topic topic) {
        topic.addSubscribe(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subsribed to topic:" + topic.getTopicName());
    }

    public void publish(final Topic topic, Message message) {
        topic.addMessage(message);
        System.out.println(message.getMsg() + "published to topic" + topic.getTopicName());
        topic.publish();
    }


}
