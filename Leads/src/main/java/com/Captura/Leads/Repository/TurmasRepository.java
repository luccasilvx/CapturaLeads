package com.Captura.Leads.Repository;

import com.Captura.Leads.Models.Turmas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmasRepository extends JpaRepository<Turmas,Long> {
}
