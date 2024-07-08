package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "receptionImage")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imgID;
    private String imageName;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageUrl;
    private String matCode;
}
