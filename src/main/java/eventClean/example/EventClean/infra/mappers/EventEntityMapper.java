package eventClean.example.EventClean.infra.mappers;


import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event){

        return new EventEntity(
                event.id(),
                event.nome(),
                event.descricao(),
                event.identificador(),
                event.localEvento(),
                event.capacidade(),
                event.organizador(),
                event.dataInicio(),
                event.dataFim(),
                event.tipoEvento());
    }

    public Event toDomain(EventEntity eventEntity){
        return new Event(
                eventEntity.getId(),
                eventEntity.getNome(),
                eventEntity.getDescricao(),
                eventEntity.getCapacidade(),
                eventEntity.getIdentificador(),
                eventEntity.getLocalEvento(),
                eventEntity.getOrganizador(),
                eventEntity.getDataInicio(),
                eventEntity.getDataFim(),
                eventEntity.getTipoEvento()
                );
    }
}
