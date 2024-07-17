package com.avanse.jpa.model.pennant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public interface PennantViewRepository extends JpaRepository<PennantView,Integer>{

	List<PennantView> findByLoanNo(String loanNo);

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	PennantView findByLoanNoAndTYPE(String loanNo, String type);

	boolean existsByLoanNo(String loanNo);

	//List<PennantView> findByOVERDUE__SI__AMOUNTGreaterThanOrderByLoanNo(double amount);

	//@Query("select t from PENNANT_MCAAP_REPORT t WHERE t.OVERDUE_SI_AMOUNT>0  order by LOAN_NO")
	@Query(
			  value = "SELECT * FROM PENNANT_MCAAP_REPORT t where t.EMI_SI_PI_AMOUNT>0  order by t.LOAN_NO", 
			  nativeQuery = true
			  )
	List<PennantView> getAllOverdueAmtGreaterThanZeroOrderByLoanNo();
}
