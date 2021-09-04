package com.reto5.inventarioapp;

import com.reto5.inventarioapp.controlador.Controlador;

import com.reto5.inventarioapp.modelo.RepositorioProducto;
import com.reto5.inventarioapp.vista.window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;


@SpringBootApplication
@Configuration
@EnableJdbcRepositories
public class InventarioAppApplication {

    @Autowired
    RepositorioProducto repositorioProducto;

    public static void main(String[] args) {

        SpringApplicationBuilder builder = new SpringApplicationBuilder(InventarioAppApplication.class);
        builder.headless(false);
        builder.run(args);

    }

    @Bean
    ApplicationRunner applicationRunner(){
        return args ->{
            window vn = new window();
            Controlador ctrl = new Controlador(vn, repositorioProducto);
        };
    }

}
