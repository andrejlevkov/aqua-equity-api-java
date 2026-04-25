package com.aqua_equity.aqua_equity_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aqua_equity.aqua_equity_api.model.Farm;

@Repository
public interface FarmRepo extends JpaRepository<Farm, Long>{

}
