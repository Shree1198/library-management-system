package com.shree.librarysystem.service;

import com.shree.librarysystem.dto.BookDto;
import jakarta.validation.ConstraintViolationException;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    BookDto getBookById(Long id) throws ConstraintViolationException;

    BookDto createBook(BookDto bookDto);

    BookDto updateBook(Long id, BookDto bookDto) throws ConstraintViolationException;

    void deleteBook(Long id) throws ConstraintViolationException;
}
