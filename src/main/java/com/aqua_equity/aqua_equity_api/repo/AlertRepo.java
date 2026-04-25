package com.aqua_equity.aqua_equity_api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aqua_equity.aqua_equity_api.model.Alert;

@Repository
public interface AlertRepo extends JpaRepository<Alert, Long>{

	@Query("SELECT a FROM Alert a JOIN a.farm f JOIN f.user u WHERE u.id = :userId")
    List<Alert> findAlertsByUserId(@Param("userId") Long userId);
}
