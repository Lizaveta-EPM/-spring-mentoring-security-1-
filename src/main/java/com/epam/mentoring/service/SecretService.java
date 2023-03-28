package com.epam.mentoring.service;

import com.epam.mentoring.entity.Secret;
import com.epam.mentoring.repository.SecretRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecretService {

    private final SecretRepository secretRepository;

    public Secret create(Secret secret) {
        return secretRepository.save(secret);
    }

    public Optional<Secret> findByLink(String link) {
        return secretRepository.findByLink(link);
    }
}
