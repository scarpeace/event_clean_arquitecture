CREATE TABLE Events (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    identificador VARCHAR(255) UNIQUE NOT NULL,
    local_evento VARCHAR(255) NOT NULL,
    capacidade INTEGER NOT NULL,
    organizador VARCHAR(255) NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    tipo_evento VARCHAR(50) NOT NULL
)