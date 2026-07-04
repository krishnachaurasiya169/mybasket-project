package com.mybasket.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="my-basket-file-meta-data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String originalName;
    private String storedName;
    private Long fileSize;
    private String storageType;
    private String fileUrl;
    private String fileType;
}
