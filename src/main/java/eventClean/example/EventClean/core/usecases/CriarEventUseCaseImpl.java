package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.gateway.EventGateway;
import eventClean.example.EventClean.infra.exceptions.DuplicateEventException;

public class CriarEventUseCaseImpl implements CriarEventUseCase {

    private final EventGateway eventGateway;

    public CriarEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }


    @Override
    public Event execute(Event evento) {

        if(eventGateway.existePorIdentificador(evento.identificador())){
            throw new DuplicateEventException("O evento com o identificador "+evento.identificador()+" já existe no banco de dados");
        }

        return eventGateway.criarEvent(evento);
    }
}
