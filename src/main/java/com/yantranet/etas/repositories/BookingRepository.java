package com.yantranet.etas.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yantranet.etas.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	Optional<Booking> findByRequestId(Long requestId);
}