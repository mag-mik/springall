package com.magmik.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SimpleRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRestApplication.class, args);
    }
}

@RestController
class BooksController {

//    @GetMapping("/books")
    @GetMapping("/") //will handle get request
    public List<Book> getAllBooks() {

        return Arrays.asList(new Book(1l, "Mastering Spring", "Misha"));
    }
}

@Getter
@Setter
@AllArgsConstructor
class Book {
    long id;
    String name;
    String author;
}