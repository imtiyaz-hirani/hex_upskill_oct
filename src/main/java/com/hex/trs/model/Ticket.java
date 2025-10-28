package com.hex.trs.model;

import com.hex.trs.enums.Priority;
import com.hex.trs.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sub")
    private String subject;

    @Column(length = 1000)
    private String issue;

    @Enumerated(EnumType.STRING)
    private Priority priority; //LOW(0), MEDIUM(1), HIGH(2)

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Ticket ticket;
}
