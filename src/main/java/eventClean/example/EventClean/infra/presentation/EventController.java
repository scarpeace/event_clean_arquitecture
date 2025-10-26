package eventClean.example.EventClean.infra.presentation;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.enums.TipoEvento;
import eventClean.example.EventClean.core.usecases.BuscarEventUseCase;
import eventClean.example.EventClean.core.usecases.CriarEventUseCase;
import eventClean.example.EventClean.core.usecases.FiltrarIdentificadorUseCase;
import eventClean.example.EventClean.core.usecases.FiltrarTipoEventoUseCase;
import eventClean.example.EventClean.infra.dtos.EventDto;
import eventClean.example.EventClean.infra.mappers.EventDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EventController {

    private final CriarEventUseCase criarEventUseCase;
    private final BuscarEventUseCase buscarEventUseCase;
    private final FiltrarTipoEventoUseCase filtrarTipoEventoUseCase;
    private final FiltrarIdentificadorUseCase filtrarIdentificadorUseCase;
    private final EventDtoMapper eventDtoMapper;


    public EventController(CriarEventUseCase criarEventUseCase,
                           BuscarEventUseCase buscarEventUseCase,
                           FiltrarTipoEventoUseCase filtrarTipoEventoUseCase,
                           FiltrarIdentificadorUseCase filtrarIdentificadorUseCase,
                           EventDtoMapper eventDtoMapper) {
        this.criarEventUseCase = criarEventUseCase;
        this.filtrarIdentificadorUseCase = filtrarIdentificadorUseCase;
        this.eventDtoMapper = eventDtoMapper;
        this.buscarEventUseCase = buscarEventUseCase;
        this.filtrarTipoEventoUseCase = filtrarTipoEventoUseCase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<EventDto> criarEvento(@RequestBody EventDto eventDto){

        Event novoEvent = criarEventUseCase.execute(eventDtoMapper.toDomain(eventDto));
        return ResponseEntity.ok(eventDtoMapper.toDto(novoEvent));

    }

    @GetMapping
    public List<EventDto> listaEventos(){
        List<Event> events = buscarEventUseCase.execute("buscar");
        List<EventDto> eventsDto = events.stream().map(e -> eventDtoMapper.toDto(e)).toList();
        return eventsDto;
    }

    @GetMapping("filtrar/{tipoEvento}")
    public List<EventDto> filtrarEventos(@PathVariable TipoEvento tipoEvento){
        List<Event> events = filtrarTipoEventoUseCase.execute(tipoEvento);
        List<EventDto> eventsDto = events.stream().map(e -> eventDtoMapper.toDto(e)).toList();
        return eventsDto;
    }

    @GetMapping("filtrar/identificador/{identificador}")
    public EventDto filtrarIdentificador(@PathVariable String identificador){
        Event event = filtrarIdentificadorUseCase.execute(identificador);
        return eventDtoMapper.toDto(event);
    }


}
