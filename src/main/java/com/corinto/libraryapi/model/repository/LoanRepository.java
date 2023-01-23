package com.corinto.libraryapi.model.repository;

import com.corinto.libraryapi.model.entity.Book;
import com.corinto.libraryapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
