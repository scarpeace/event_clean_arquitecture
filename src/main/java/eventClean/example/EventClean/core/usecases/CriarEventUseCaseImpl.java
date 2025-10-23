package eventClean.example.EventClean.core.usecases;

import eventClean.example.EventClean.core.entities.Event;
import eventClean.example.EventClean.core.gateway.EventGateway;
import eventClean.example.EventClean.infra.exceptions.DuplicateEventException;
import eventClean.example.EventClean.infra.exceptions.InvalidStartDateException;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.format.DateTimeFormatter;

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

        if(eventGateway.dataDeInicioInvalida(evento.dataInicio())){
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            throw new InvalidStartDateException("O evento não pode iniciar em uma data que já passou a data: " +evento.dataInicio().format(dateFormatter)+ " já passou");
        }

        return eventGateway.criarEvent(evento);
    }
}
