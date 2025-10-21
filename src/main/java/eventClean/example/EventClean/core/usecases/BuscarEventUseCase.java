package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;

import java.util.List;

public interface BuscarEventUseCase {

    public List<Event> execute(String id);
}
