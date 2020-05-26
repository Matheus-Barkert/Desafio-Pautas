package br.com.compasso.DesafioPauta.dto;

import br.com.compasso.DesafioPauta.entity.Agenda;
import lombok.Data;

@Data
public class AgendaDto {

    private String title;
    private String description;

    public AgendaDto(Agenda agenda){
        this.title = agenda.getTitle();
        this.description = agenda.getDescription();
    }

}
