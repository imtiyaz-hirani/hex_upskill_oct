package com.hex.trs.controller;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.service.TicketService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/add")
    public TicketReqDto addTicket(@Valid @RequestBody TicketReqDto ticketReqDto ){

        return ticketReqDto;
    }
}
