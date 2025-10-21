package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.gateway.EventGateway;

public class CriarEventUseCaseImpl implements CriarEventUseCase {

    private final EventGateway eventGateway;

    public CriarEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }


    @Override
    public Event execute(Event evento) {
        Event newEvent = eventGateway.criarEvent(evento);
        return newEvent;
    }
}
