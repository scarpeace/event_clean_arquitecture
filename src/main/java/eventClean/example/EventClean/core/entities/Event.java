package eventClean.example.EventClean.core.entities;

import eventClean.example.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record Event(
        Long id,
        String nome,
        String descricao,
        Integer capacidade,
        String identificador,
        String localEvento,
        String organizador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        TipoEvento tipoEvento) {}
