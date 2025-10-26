package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.gateway.EventGateway;

public class FiltrarIdentificadorUseCaseImpl implements FiltrarIdentificadorUseCase{

    private final EventGateway eventGateway;

    public FiltrarIdentificadorUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identificador) {
        return eventGateway.filtrarPorIdentificador(identificador);
    }
}
