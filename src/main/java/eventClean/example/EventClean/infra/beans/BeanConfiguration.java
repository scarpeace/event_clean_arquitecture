package eventClean.example.EventClean.infra.beans;

import eventClean.example.EventClean.core.enums.TipoEvento;
import eventClean.example.EventClean.core.gateway.EventGateway;
import eventClean.example.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventUseCase criarEvent(EventGateway eventGateway){
        return new CriarEventUseCaseImpl(eventGateway);
    }

    @Bean
    public BuscarEventUseCase buscarEvent(EventGateway eventGateway){
        return new BuscarEventUseCaseImpl(eventGateway);
    }

    @Bean
    public FiltrarEventUseCase filtrarEvent(EventGateway eventGateway){
        return new FiltrarEventUseCaseImpl(eventGateway);
    }

}
