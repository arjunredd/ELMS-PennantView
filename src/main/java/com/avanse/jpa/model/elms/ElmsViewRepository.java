/*
 * package com.avanse.jpa.model.elms;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query;
 * 
 * public interface ElmsViewRepository extends JpaRepository<ELMSView, Integer>
 * { List<ELMSView> findByLoanNo(String loanNo);
 * 
 * // ELMSView findByLoanNoAndTYPE(String paramString1, String loanNo); ELMSView
 * findByLoanNoAndTYPE(String loanNo, String paramString1);
 * 
 * boolean existsByLoanNo(String paramString);
 * 
 * 
 * //This queryis for production
 * 
 * @Query( value =
 * "SELECT * FROM elms.coll_overdue_view t where t.EMI_SI_PI_AMOUNT>0  order by t.LOAN_NO"
 * , nativeQuery = true )
 * 
 * 
 * 
 * //This query is for PROD
 * 
 * @Query( value =
 * "SELECT * FROM elms.coll_overdue_view t where t.EMI_SI_PI_AMOUNT>0  order by t.LOAN_NO"
 * , nativeQuery = true ) //this query is for UAT
 * 
 * @Query( value =
 * "SELECT * FROM mcaap_report t where t.EMI_SI_PI_AMOUNT>0  order by t.LOAN_NO"
 * , nativeQuery = true ) List<ELMSView>
 * getAllOverdueAmtGreaterThanZeroOrderByLoanNo();
 * 
 * }
 */