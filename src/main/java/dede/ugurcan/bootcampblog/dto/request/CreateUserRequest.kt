package dede.ugurcan.bootcampblog.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class CreateUserRequest(

    @field:NotBlank
    val username: String,

    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    val displayName: String
)
