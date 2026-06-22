package com.enginefleet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enginefleet.Entity.Route;

public interface RouteRepository extends JpaRepository<Route,Long> {

}
