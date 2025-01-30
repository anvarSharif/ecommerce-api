package com.example.ecommerce_api.entity;

import com.example.ecommerce_api.entity.abc.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
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
public class AttachmentContent extends BaseEntity {
    private byte[] content;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;
}
