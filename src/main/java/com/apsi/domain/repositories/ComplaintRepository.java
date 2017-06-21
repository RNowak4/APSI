package com.apsi.domain.repositories;

import com.apsi.domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    Optional<Complaint> findById(Long id);
}
