package com.cognizant.truyum.repository;

import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Integer>{
    List<MenuItem> findByActiveAndDateOfLaunchBefore(boolean active, Date dateOfLaunch);
}
