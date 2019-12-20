package co.simplon.service;

import co.simplon.dao.RoleRepository;
import co.simplon.dao.UserRepository;
import co.simplon.entities.AppRole;
import co.simplon.entities.AppUser;
import co.simplon.entities.EncoderBCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        String hashPW= EncoderBCrypt.getEncoder().encode(user.getPassword());
        user.setPassword(hashPW);
        return userRepository.save(user);
    }



    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUse(String username, String roleName) {
        AppRole role=roleRepository.findByRoleName(roleName);
        AppUser user=userRepository.findByUsername(username);
        user.getRoles().add(role);

    }

    @Override
    public AppUser findUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return null;
    }
}
