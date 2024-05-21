package app.auth.domain.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationService {
    // private final RestTemplate restTemplate; // TODO request adapter 분리
    // private final JsonUtils jsonUtil;
    //
    // public IdentityVerificationVo verifyIdentity(IdentityVerificationDto identityVerificationDto) {
    //     String url = "/api/v1/getIdentity"; // TODO request url 변경
    //
    //     // RestTemplate 신원 조회 요청
    //     String jsonResponse = restTemplate.getForObject(url, String.class);
    //
    //     try {
    //         IdentityVerificationVo identityVerificationVo = jsonUtil.jsonToObject(jsonResponse, IdentityVerificationVo.class);
    //         return identityVerificationVo;
    //     } catch (JsonProcessingException e) {
    //         throw new CustomException(ResponseCode.BAD_PARSING);
    //     }
    //
    //     // TODO 예외처리
    // }
}

