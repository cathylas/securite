package co.simplon.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncoderBCrypt {
    public static PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}


