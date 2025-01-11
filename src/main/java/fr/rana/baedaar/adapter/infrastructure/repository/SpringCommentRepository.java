package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringCommentRepository extends JpaRepository<JpaCommentEntity, Long> {
}
