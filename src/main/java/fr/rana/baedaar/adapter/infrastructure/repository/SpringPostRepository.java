package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringPostRepository extends JpaRepository<JpaPostEntity, Long> {
}
