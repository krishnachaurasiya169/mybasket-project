package com.mybasket.app.repository;

import com.mybasket.app.entity.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMetaDataRepo extends JpaRepository<FileMetaData, Long> {
}