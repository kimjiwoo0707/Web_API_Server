package dto;

import entity.Member;
import entity.Member.Authority;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class MemberRequestDto {
    private String email;
    private String password;
    private String authority;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(this.email)
                .password(passwordEncoder.encode(this.password))
                .authority(Authority.valueOf(this.authority))
                .build();
    }
}
