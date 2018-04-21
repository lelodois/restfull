package br.com.lelo.restfull.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lelo.restfull.domain.ContaContabil;

@Repository
public interface ContaContabilRepository extends JpaRepository<ContaContabil, UUID> {

}
