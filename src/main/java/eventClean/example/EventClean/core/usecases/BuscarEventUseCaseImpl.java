package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.gateway.EventGateway;

import java.util.List;

public class BuscarEventUseCaseImpl implements BuscarEventUseCase {

    private final EventGateway eventGateway;

    public BuscarEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute(String id) {
        return eventGateway.buscarEvents();
    }
}
