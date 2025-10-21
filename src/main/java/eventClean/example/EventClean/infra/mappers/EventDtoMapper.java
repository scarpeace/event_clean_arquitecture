package eventClean.example.EventClean.infra.mappers;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.infra.dtos.EventDto;
import eventClean.example.EventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {

    public EventDto toDto(Event event){
        return new EventDto(
                event.id(),
                event.nome(),
                event.descricao(),
                event.capacidade(),
                event.identificador(),
                event.localEvento(),
                event.organizador(),
                event.dataInicio(),
                event.dataFim(),
                event.tipoEvento()
        );

    }

    public Event toDomain(EventDto eventDto){
        return new Event(
                eventDto.id(),
                eventDto.nome(),
                eventDto.descricao(),
                eventDto.capacidade(),
                eventDto.identificador(),
                eventDto.localEvento(),
                eventDto.organizador(),
                eventDto.dataInicio(),
                eventDto.dataFim(),
                eventDto.tipoEvento()
        );
    }
}
