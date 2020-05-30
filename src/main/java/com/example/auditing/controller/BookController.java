package com.example.auditing.controller;

import com.example.auditing.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    @GetMapping
    public ResponseEntity<Book> listAll() {
        return null;
    }
}
