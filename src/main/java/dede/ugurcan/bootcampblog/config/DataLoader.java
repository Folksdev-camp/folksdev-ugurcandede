package dede.ugurcan.bootcampblog.config;

import dede.ugurcan.bootcampblog.model.Comment;
import dede.ugurcan.bootcampblog.model.Post;
import dede.ugurcan.bootcampblog.model.PostStatus;
import dede.ugurcan.bootcampblog.model.User;
import dede.ugurcan.bootcampblog.repository.CommentRepository;
import dede.ugurcan.bootcampblog.repository.PostRepository;
import dede.ugurcan.bootcampblog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(name = "command.line.runner.enable", havingValue = "true")
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public DataLoader(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(
                "ugurcandede",
                "ugur@dede.com",
                "Ugurcan Dede");

        Post post = new Post(
                "Hello",
                "Hello Folksie!~",
                PostStatus.PUBLISHED,
                user1);

        // Reverse Ownership
//        user1.getPosts().add(post);
        postRepository.save(post);

        Post commentedPost = postRepository.findTopByOrderByCreatedAt();
        System.out.println("\nCommentedPost: " + commentedPost);


        User user2 = new User(
                "nemesisce",
                "cagridursun@folksdev",
                "Cagri Dursun");

        Post post2 = new Post(
                "Lorem Ipsum",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a diam consectetur.",
                PostStatus.PUBLISHED,
                user2,
                List.of());

        Comment comment = new Comment(
                "Hi Kod Gemisi",
                user2,
                post2);

        commentRepository.save(comment);

        userRepository
                .findAll()
                .forEach(u ->
                        System.out.printf("\n ID -> %s \n\t Data -> %s", u.getId(), u)
                );

    }
}
