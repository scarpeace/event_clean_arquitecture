package eventClean.example.EventClean.core.gateway;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.enums.TipoEvento;
import eventClean.example.EventClean.infra.persistence.EventEntity;

import java.util.List;

public interface EventGateway {

    Event criarEvent(Event event);
    List<Event> buscarEvents();
    List<Event> filterEvents(TipoEvento tipoEvento);
}
