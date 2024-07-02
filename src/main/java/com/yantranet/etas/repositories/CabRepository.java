package com.yantranet.etas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yantranet.etas.models.Cab;

public interface CabRepository extends JpaRepository<Cab, Long>
{
	List<Cab> findByCabStatusAndVacancyGreaterThan(String cabStatus, int Vacancy);
}