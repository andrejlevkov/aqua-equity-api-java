package com.aqua_equity.aqua_equity_api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aqua_equity.aqua_equity_api.model.Estimate;

@Repository
public interface EstimateRepo extends JpaRepository<Estimate, Long> {

	@Query("SELECT e FROM Estimate e JOIN e.farm f JOIN f.user u WHERE u.id = :userId")
    List<Estimate> findAlertsByUserId(@Param("userId") Long userId);
}
