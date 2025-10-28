package com.hex.trs.service;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.dto.TicketRespDto;
import com.hex.trs.enums.Status;
import com.hex.trs.mapper.TicketMapper;
import com.hex.trs.model.Customer;
import com.hex.trs.model.Ticket;
import com.hex.trs.repository.TicketRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {

    private final CustomerService customerService;
    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    public TicketRespDto add(Long customerId, @Valid TicketReqDto ticketReqDto) {
        /* fetch customer info  from DB using this customerID
            If id is invalid , i will throw an exception
         */
        Customer customer =  customerService.getById(customerId);
        /*
            Map Dto to entity
         */
        Ticket ticket = ticketMapper.toEntity(ticketReqDto);
        /*
        *   add extra entity fields values
        *   attach customer to ticket
        * */
        ticket.setStatus(Status.OPEN);
        ticket.setCustomer(customer);
        /*
        * Save ticket & send trimmed response
        * */
        return ticketMapper.toDto(ticketRepository.save(ticket));
    }

    public List<Ticket> getTicketsByCustomer(Long customerId) {
        return ticketRepository.getTicketsByCustomer(customerId);
    }
}
