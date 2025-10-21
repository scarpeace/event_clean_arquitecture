package eventClean.example.EventClean.infra.persistence;

import eventClean.example.EventClean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="events")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String identificador;
    private String localEvento;
    private Integer capacidade;
    private String organizador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
}
