package web.customObjects;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RegisterAccountDetails {
    private String username;
    private String email;
    private String password;
}
