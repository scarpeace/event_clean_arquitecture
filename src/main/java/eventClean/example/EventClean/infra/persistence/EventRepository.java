package eventClean.example.EventClean.infra.persistence;

import eventClean.example.EventClean.core.enums.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity,Long>{
    List<EventEntity> findByTipoEvento(TipoEvento tipoEvento);
    EventEntity findByIdentificador(String identificador);
}