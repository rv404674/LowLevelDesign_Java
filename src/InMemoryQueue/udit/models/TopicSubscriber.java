package InMemoryQueue.udit.models;

import InMemoryQueue.udit.publicinterfaces.ISubscriber;

// will have a subscriber and an offset.
public class TopicSubscriber {
    private Integer offset;
    private ISubscriber subscriber;

    public TopicSubscriber(ISubscriber subscriber) {
        this.offset = 0;
        this.subscriber = subscriber;
    }

    public Integer getOffset() {
        return offset;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
