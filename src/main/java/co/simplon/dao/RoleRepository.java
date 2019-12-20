package co.simplon.dao;

import co.simplon.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<AppRole, Long> {
public AppRole findByRoleName(String roleName);

}
