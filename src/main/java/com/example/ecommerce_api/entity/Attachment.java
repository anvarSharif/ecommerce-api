package com.example.ecommerce_api.entity;

import com.example.ecommerce_api.entity.abc.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
public class Attachment extends BaseEntity {
    private String fileName;

    public String getFileName() {
        return fileName.length()>10?(fileName.substring(0,10)+"..."+fileName.substring(fileName.length()-3,fileName.length())):fileName;
    }
}
