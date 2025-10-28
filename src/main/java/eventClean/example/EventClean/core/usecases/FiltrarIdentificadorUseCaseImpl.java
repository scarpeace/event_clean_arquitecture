package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.gateway.EventGateway;
import eventClean.example.EventClean.infra.exceptions.NotFoundEventException;

public class FiltrarIdentificadorUseCaseImpl implements FiltrarIdentificadorUseCase{

    private final EventGateway eventGateway;

    public FiltrarIdentificadorUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identificador) {
        if(!eventGateway.existePorIdentificador(identificador)){
            throw new NotFoundEventException("O evento com o identificador " +identificador+ " não foi encontrado no banco de dados");
        }
        return eventGateway.filtrarPorIdentificador(identificador);
    }
}
