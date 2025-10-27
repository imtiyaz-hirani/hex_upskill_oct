package com.hex.trs.mapper;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.dto.TicketRespDto;
import com.hex.trs.enums.Priority;
import com.hex.trs.model.Ticket;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {


    public Ticket toEntity(@Valid TicketReqDto ticketReqDto) {
        Ticket ticket = new Ticket();
        ticket.setSubject(ticketReqDto.subject());
        ticket.setIssue(ticketReqDto.issue());
        /* Convert String priority into Enum Priority */
        Priority priority =  Priority.valueOf(ticketReqDto.priority());
        ticket.setPriority(priority);
        return ticket;
    }

    public TicketRespDto toDto(Ticket ticket) {
        TicketRespDto dto =  new TicketRespDto(ticket.getId(),
                ticket.getStatus().toString(),
                ticket.getCreatedAt().toString()
        );
        return dto;
    }

}
