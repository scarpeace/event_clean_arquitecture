package eventClean.example.EventClean.infra.dtos;

import eventClean.example.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record EventDto(
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

