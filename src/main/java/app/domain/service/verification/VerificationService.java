package app.domain.service.verification;

import app.application.dto.verification.IdentityVerificationDto;
import app.application.vo.verification.IdentityVerificationVo;
import app.domain.model.common.ResponseCode;
import app.domain.utils.JsonUtils;
import app.infrastructure.exception.CustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class VerificationService {
    private final RestTemplate restTemplate; // TODO request adapter 분리
    private final JsonUtils jsonUtil;

    public IdentityVerificationVo verifyIdentity(IdentityVerificationDto identityVerificationDto) {
        String url = "/api/v1/getIdentity"; // TODO request url 변경

        // RestTemplate 신원 조회 요청
        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            IdentityVerificationVo identityVerificationVo = jsonUtil.jsonToObject(jsonResponse, IdentityVerificationVo.class);
            return identityVerificationVo;
        } catch (JsonProcessingException e) {
            throw new CustomException(ResponseCode.BAD_PARSING);
        }

        // TODO 예외처리
    }
}

