package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.enums.TipoEvento;
import eventClean.example.EventClean.core.gateway.EventGateway;

import java.util.List;

public class FiltrarEventUseCaseImpl implements FiltrarEventUseCase{

    private final EventGateway eventGateway;

    public FiltrarEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }


    @Override
    public List<Event> execute(TipoEvento tipoEvento) {
        List<Event> filteredEvents = eventGateway.filterEvents(tipoEvento);
        return filteredEvents;
    }
}
