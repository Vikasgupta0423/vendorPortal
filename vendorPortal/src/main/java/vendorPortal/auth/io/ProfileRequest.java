package vendorPortal.auth.io;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {

    @NotBlank(message = "Name should not be empty")
    private String name;
    @Email(message = "Enter valid email address")
    @NotNull(message = "Email should not empty")
    private String email;
    @Size(min = 6, message = "Password must be atleast 6 charaters")
    private String password;
}
