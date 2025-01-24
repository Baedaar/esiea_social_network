package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringUserRepository extends JpaRepository<JpaUserEntity, Long> {
    Optional<JpaUserEntity> findByUserNameAndPassword(String userName, String password);
}
