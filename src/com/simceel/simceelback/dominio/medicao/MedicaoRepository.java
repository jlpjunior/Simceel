package com.simceel.simceelback.dominio.medicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicaoRepository extends JpaRepository<Medicao, Long> {
}
