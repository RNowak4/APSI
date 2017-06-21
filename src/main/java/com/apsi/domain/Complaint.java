package com.apsi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "ClientEntity")
public class Complaint {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    @ManyToOne
    private Client client;
    private Date complaintDate;
    private Date decisionDate;
    private ComplaintStatus complaintStatus;
}
