package co.edu.uniquindio.unitravel;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication

public class persistenciaApplication {

   public static void main(String[] args) {

        SpringApplication.run(persistenciaApplication.class, args);
       /*
       StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
       System.out.println(passwordEncryptor.encryptPassword("12345"));

        */
    }
}
