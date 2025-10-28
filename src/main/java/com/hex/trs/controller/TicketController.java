package com.hex.trs.controller;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.dto.TicketRespDto;
import com.hex.trs.model.Ticket;
import com.hex.trs.service.TicketService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/add/v1/{customerId}")
    public ResponseEntity<?> addTicket(@PathVariable Long customerId,
                                   @Valid @RequestBody TicketReqDto ticketReqDto ){

        return ResponseEntity
                .created(URI.create("/api/ticket/add"))
                .body(ticketService.add(customerId,ticketReqDto));
    }

    @GetMapping("/customer/{customerId}")
    public List<Ticket> getTicketsByCustomer(@PathVariable Long customerId){
        return ticketService.getTicketsByCustomer(customerId);
    }
}
