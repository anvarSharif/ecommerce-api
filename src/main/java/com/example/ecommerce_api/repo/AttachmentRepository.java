package com.example.ecommerce_api.repo;

import com.example.ecommerce_api.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}