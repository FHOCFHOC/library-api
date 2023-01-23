package com.corinto.libraryapi.service.impl;

import com.corinto.libraryapi.exception.BusinessException;
import com.corinto.libraryapi.model.entity.Loan;
import com.corinto.libraryapi.model.repository.LoanRepository;
import com.corinto.libraryapi.service.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//@Service
public class LoanServiceImpl implements LoanService {

    private LoanRepository repository;

    public LoanServiceImpl(LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Loan save(Loan loan ) {
       // if( repository.existsByBookAndNotReturned(loan.getBook()) ){
         //   throw new BusinessException("Book already loaned");
        //}
        return repository.save(loan);
    }
}