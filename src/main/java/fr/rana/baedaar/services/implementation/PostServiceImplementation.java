package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.dao.PostDao;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostDao postDao;

    public PostServiceImplementation(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Post createPost(User user, String content) {
        Post post = new Post(user, content, null, null);
        try {
            postDao.createPost(post);
            System.out.println("Post créé avec succès avec ID: " + post.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public Post updatePost(Post post, String newContent) {
        try {
            if (post != null) {
                post.setContent(newContent);
                postDao.updatePost(post);
                System.out.println("Post mis à jour avec succès !");
                return post;
            } else {
                System.out.println("Post non trouvé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletePost(Post post) {
        try {
            postDao.deletePost(post);
            System.out.println("Post supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
