package com.easybytes.loans.Audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAware")
public class AuditAware implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Anonymous");
    }
}
