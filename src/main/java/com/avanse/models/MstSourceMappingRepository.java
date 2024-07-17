package com.avanse.models;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MstSourceMappingRepository extends JpaRepository<MstSourceMapping,UUID>{

	Optional<MstSourceMapping> findBySourceId(UUID sourceId);

	List<MstSourceMapping> findAllByIsDeleted(boolean status);

	boolean existsBySourceIdAndSecretKey(UUID sourceId, String secretKey);
	
	@Query(value = "EXEC GetCashLimitForLoan :loanNo, :requestedDate", nativeQuery = true)
	double getCashLimitForLoan(@Param("loanNo")String loanNo, @Param("requestedDate")Date requestedDate);

}
