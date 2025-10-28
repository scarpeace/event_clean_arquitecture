package eventClean.example.EventClean.core.gateway;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;
import java.util.List;

public interface EventGateway {

    Event criarEvent(Event event);
    List<Event> buscarEvents();
    List<Event> filterEvents(TipoEvento tipoEvento);
    Event filtrarPorIdentificador(String identificador);
    boolean existePorIdentificador(String identificador);
    boolean dataDeInicioInvalida(LocalDateTime dataInicio);

}
