package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Member;

@Getter
@Setter
public class MemberResponseDto {
    private String email;
    private String authority;

    public static MemberResponseDto of(Member member) {
        MemberResponseDto responseDto = new MemberResponseDto();
        responseDto.setEmail(member.getEmail());
        responseDto.setAuthority(member.getAuthority().name()); // Enum 값을 문자열로 변환
        return responseDto;
    }
}
