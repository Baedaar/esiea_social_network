package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringLikeRepository extends JpaRepository<JpaLikeEntity, Long> {
}
