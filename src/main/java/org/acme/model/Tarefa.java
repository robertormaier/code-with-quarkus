package org.acme.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue
    private long id;

    private String titulo;
    private String descricao;
    private String status;
    private String dataHoraIncio;
    private String dataHoraConclusao;
}
