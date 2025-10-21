package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.enums.TipoEvento;

import java.util.List;

public interface FiltrarEventUseCase {

    public List<Event> execute(TipoEvento tipoEvento);
}
