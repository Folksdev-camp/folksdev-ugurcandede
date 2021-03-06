package dede.ugurcan.bootcampblog.dto.converter;

import dede.ugurcan.bootcampblog.dto.CommentDto;
import dede.ugurcan.bootcampblog.dto.PostDto;
import dede.ugurcan.bootcampblog.dto.UserDto;
import dede.ugurcan.bootcampblog.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDto convert(User from) {
        return new UserDto(
                from.getId(),
                from.getUsername(),
                from.getEmail(),
                from.getDisplayName(),
                from.isActive(),
                from.getPosts()
                        .stream()
                        .map(p -> new PostDto(
                                p.getId(),
                                p.getTitle(),
                                p.getBody(),
                                p.getCreatedAt(),
                                p.getUpdatedAt(),
                                p.getStatus()
                        ))
                        .collect(Collectors.toList()),
                from.getComments()
                        .stream()
                        .map(c -> new CommentDto(
                                c.getId(),
                                c.getBody(),
                                c.getCreatedAt(),
                                c.getUpdatedAt()
                        ))
                        .collect(Collectors.toList())
        );
    }

    public List<UserDto> convertToUserDtoList(List<User> users) {
        return users
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
