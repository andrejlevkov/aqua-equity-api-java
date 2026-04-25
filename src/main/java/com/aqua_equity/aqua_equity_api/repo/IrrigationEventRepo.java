package com.aqua_equity.aqua_equity_api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aqua_equity.aqua_equity_api.model.IrrigationEvent;

@Repository
public interface IrrigationEventRepo extends JpaRepository<IrrigationEvent, Long>{

	@Query("SELECT i FROM IrrigationEvent i JOIN i.farm f JOIN f.user u WHERE i.id = :userId")
    List<IrrigationEvent> findIrrigationEventsByUserId(@Param("userId") Long userId);
}
