package co.simplon.service;

import co.simplon.entities.AppRole;
import co.simplon.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUse(String username,String roleName);
    public AppUser findUsername(String username);

    AppUser findUserByUsername(String username);
}
