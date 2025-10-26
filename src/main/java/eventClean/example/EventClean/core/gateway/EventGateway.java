package eventClean.example.EventClean.core.gateway;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.enums.TipoEvento;
import eventClean.example.EventClean.infra.persistence.EventEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventGateway {

    Event criarEvent(Event event);
    List<Event> buscarEvents();
    List<Event> filterEvents(TipoEvento tipoEvento);
    Event filtrarPorIdentificador(String identificador);
    boolean existePorIdentificador(String identificador);
    boolean dataDeInicioInvalida(LocalDateTime dataInicio);

}
