package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringUserRepository extends JpaRepository<JpaUserEntity, Long> {
}
