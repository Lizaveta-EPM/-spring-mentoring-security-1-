package com.epam.mentoring.repository;

import com.epam.mentoring.entity.Secret;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretRepository extends JpaRepository<Secret, Long> {

    Optional<Secret> findByLink(String link);
}
