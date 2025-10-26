package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;

public interface FiltrarIdentificadorUseCase {

    public Event execute(String identificador);
}
