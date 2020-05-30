package com.example.auditing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    private static final String USER_AUDITOR = "USER";
    private static final String UNDEFINED = "UNDEFINED";

    @Autowired
    private HttpServletRequest request;

    @Value("${auditing.uri-user-auditor:}")
    private String uriUserAuditor;

    @Override
    public Optional<String> getCurrentAuditor() {
        String URI = this.request.getRequestURI();

        if (URI.contains(uriUserAuditor)) {
            return Optional.ofNullable(USER_AUDITOR);
        }

        return Optional.ofNullable(UNDEFINED);

//        TODO: use this code for get username authenticated in your filter!
//        return Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(e -> e.getAuthentication())
//                .map(Authentication::getName);
    }
}
