package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaUserEntity;
import fr.rana.baedaar.domain.model.User;
import fr.rana.baedaar.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;


@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringUserRepository repository;

    public JpaUserRepository(SpringUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        JpaUserEntity userEntity = new JpaUserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        JpaUserEntity savedEntity = repository.save(userEntity);
        return savedEntity.toUser();
    }

    @Override
    public User connection(String email, String password) {
        return repository.findByUserNameAndPassword(email, password)
                .map(JpaUserEntity::toUser)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }

    @Override
    public void updateUserPassword(String newPassword) {

    }

    @Override
    public void updateUserUsername(String newUsername) {

    }

    @Override
    public void deleteUser(String username, String password) {
    }
}
