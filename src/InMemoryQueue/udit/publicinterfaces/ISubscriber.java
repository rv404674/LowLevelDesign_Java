package InMemoryQueue.udit.publicinterfaces;

import InMemoryQueue.udit.models.Message;

public interface ISubscriber {
    String getId();

    void consume(Message message) throws InterruptedException;
}