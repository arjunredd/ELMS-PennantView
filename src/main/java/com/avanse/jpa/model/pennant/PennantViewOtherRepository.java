package com.avanse.jpa.model.pennant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PennantViewOtherRepository extends JpaRepository<PennantViewOther, Integer> {
	List<PennantViewOther> findByLoanNo(String loanNo);
}
