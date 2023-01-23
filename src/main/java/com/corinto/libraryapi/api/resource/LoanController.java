package com.corinto.libraryapi.api.resource;


import com.corinto.libraryapi.api.dto.LoanDTO;
import com.corinto.libraryapi.model.entity.Book;
import com.corinto.libraryapi.model.entity.Loan;
import com.corinto.libraryapi.service.BookService;
import com.corinto.libraryapi.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;
    private final BookService bookService;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody LoanDTO dto) {
        Book book = bookService
                .getBookByIsbn(dto.getIsbn())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found for passed isbn"));
        Loan entity = Loan.builder()
                .book(book)
                .customer(dto.getCustomer())
                .loanDate(LocalDate.now())
                .build();

        entity = service.save(entity);
        return entity.getId();
    }



}
