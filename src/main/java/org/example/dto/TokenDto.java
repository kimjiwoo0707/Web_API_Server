package org.example.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenDto {
    private String grantType; // 토큰 타입 (예: Bearer)
    private String accessToken; // 액세스 토큰
    private Long accessTokenExpiresIn; // 액세스 토큰 만료 시간
    private String refreshToken; // 리프레시 토큰
}
