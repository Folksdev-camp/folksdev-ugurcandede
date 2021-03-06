package dede.ugurcan.bootcampblog.dto

import com.fasterxml.jackson.annotation.JsonInclude
import dede.ugurcan.bootcampblog.model.PostStatus
import org.springframework.hateoas.RepresentationModel
import java.time.LocalDateTime

data class PostDto @JvmOverloads constructor(

    val id: String?,
    val title: String,
    val body: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val status: PostStatus,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    val user: UserDto? = null,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val comments: List<CommentDto>? = null,
) : RepresentationModel<PostDto>()
