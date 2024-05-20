package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reception")

public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String patCode;
    private String patName;
    @Lob
    private byte [ ] picture;
}
