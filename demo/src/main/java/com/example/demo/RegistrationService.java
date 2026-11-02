package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final List<Registration> registrations = new ArrayList<>();

    public Registration register(Registration registration) {
        if (registration == null) {
            throw new IllegalArgumentException("Registration details are required");
        }

        registrations.add(registration);
        return registration;
    }

    public List<Registration> getAllRegistrations() {
        return registrations;
    }
}
