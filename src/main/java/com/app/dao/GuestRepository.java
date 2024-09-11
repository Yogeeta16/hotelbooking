package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
	
}

