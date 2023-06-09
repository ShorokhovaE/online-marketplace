package ru.shorokhova.store.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shorokhova.store.auth.entities.Role;
import ru.shorokhova.store.auth.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}