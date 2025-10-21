package eventClean.example.EventClean.infra.presentation;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.enums.TipoEvento;
import eventClean.example.EventClean.core.usecases.BuscarEventUseCase;
import eventClean.example.EventClean.core.usecases.CriarEventUseCase;
import eventClean.example.EventClean.core.usecases.FiltrarEventUseCase;
import eventClean.example.EventClean.infra.dtos.EventDto;
import eventClean.example.EventClean.infra.mappers.EventDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class EventController {

    private final CriarEventUseCase criarEventUseCase;
    private final BuscarEventUseCase buscarEventUseCase;
    private final FiltrarEventUseCase filtrarEventUseCase;
    private final EventDtoMapper eventDtoMapper;


    public EventController(CriarEventUseCase criarEventUseCase,
                           BuscarEventUseCase buscarEventUseCase,
                           FiltrarEventUseCase filtrarEventUseCase,
                           EventDtoMapper eventDtoMapper) {
        this.criarEventUseCase = criarEventUseCase;
        this.eventDtoMapper = eventDtoMapper;
        this.buscarEventUseCase = buscarEventUseCase;
        this.filtrarEventUseCase = filtrarEventUseCase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String,Object>> criarEvento(@RequestBody EventDto eventDto){
        try{
            Event novoEvent = criarEventUseCase.execute(eventDtoMapper.toDomain(eventDto));
            Map<String,Object> response = new HashMap<>();

            response.put("Mensagem: ","Evento cadastrado com sucesso no banco de dados");
            response.put("Dados do evento: ", eventDtoMapper.toDto(novoEvent));

            return ResponseEntity.ok(response);
        }catch (Exception e){
            Map<String,Object> response = new HashMap<>();

            response.put("Mensagem: ","Erro ao cadastrar evento no banco de dados");
            response.put("Detalhes do Erro: ", e.getMessage());

            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public List<EventDto> listaEventos(){
        List<Event> events = buscarEventUseCase.execute("buscar");
        List<EventDto> eventsDto = events.stream().map(e -> eventDtoMapper.toDto(e)).toList();
        return eventsDto;
    }

    @GetMapping("filtrar/{tipoEvento}")
    public List<EventDto> filtrarEventos(@PathVariable TipoEvento tipoEvento){
        List<Event> events = filtrarEventUseCase.execute(tipoEvento);
        List<EventDto> eventsDto = events.stream().map(e -> eventDtoMapper.toDto(e)).toList();
        return eventsDto;
    }
}
