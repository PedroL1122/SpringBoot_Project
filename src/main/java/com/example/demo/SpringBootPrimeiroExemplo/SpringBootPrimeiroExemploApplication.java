package com.example.demo.SpringBootPrimeiroExemplo;

import com.example.demo.domain.Cliente;
import com.example.demo.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.rpires.repository")
@EntityScan("br.com.rpires.*")
@ComponentScan(basePackages = "br.com.rpires")
public class SpringBootPrimeiroExemploApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);

    @Autowired
    private IClienteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPrimeiroExemploApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("StartApplication...");
        Cliente cliente = createCliente();
        repository.save(cliente);
    }

    private Cliente createCliente() {
        return Cliente.builder()
                .cpf(02322413140L)
                .email("bangue062@gmail.com")
                .estado("GO")
                .nome("Pedro")
                .build();
    }

}
