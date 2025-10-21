package eventClean.example.EventClean.infra.gateway;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.enums.TipoEvento;
import eventClean.example.EventClean.core.gateway.EventGateway;
import eventClean.example.EventClean.infra.mappers.EventEntityMapper;
import eventClean.example.EventClean.infra.persistence.EventEntity;
import eventClean.example.EventClean.infra.persistence.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    public EventRepositoryGateway(EventRepository eventRepository, EventEntityMapper eventEntityMapper) {
        this.eventRepository = eventRepository;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    public Event criarEvent(Event event) {
        EventEntity entity = eventEntityMapper.toEntity(event);
        EventEntity newEvent = eventRepository.save(entity);

        return eventEntityMapper.toDomain(newEvent);
    }

    @Override
    public List<Event> buscarEvents() {
        List<EventEntity> entities = eventRepository.findAll();
        List<Event> allEvents = entities.stream().map(e -> eventEntityMapper.toDomain(e)).toList();
        return allEvents;
    }

    @Override
    public List<Event> filterEvents(TipoEvento tipoEvento) {
        List<EventEntity> entities = eventRepository.findByTipoEvento(tipoEvento);
        List<Event> filteredEvents = entities.stream().map(eventEntityMapper::toDomain).toList();
        return filteredEvents;
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        EventEntity foundEvent = eventRepository.findByIdentificador(identificador);
        return foundEvent != null;
    }


}
