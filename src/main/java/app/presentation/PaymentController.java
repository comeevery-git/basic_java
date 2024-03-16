package app.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.application.dto.payment.CreatePaymentDto;
import app.application.vo.payment.CreatePaymentVo;
import app.domain.model.common.BaseResponse;
import app.domain.service.payment.PaymentService;
import app.infrastructure.annotation.CommonResponseCode;
import app.infrastructure.exception.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Payment", description = "결제 관련 API")
@Slf4j
@RestController
@AllArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;

	@PostMapping
	@Operation(summary = "결제수단 등록", description = "결제수단을 등록합니다.")
	@CommonResponseCode
	public BaseResponse<CreatePaymentVo> createPayment(@RequestBody final CreatePaymentDto dto) {
		log.info("CreatePaymentDto: {}", dto);
		try {
			CreatePaymentVo paymentVo = paymentService.createPayment(dto);
			return BaseResponse.successResponse(paymentVo);
		} catch (CustomException e) {
			return BaseResponse.failResponse(e.getResponseCode());
		} catch (Exception e) {
			return BaseResponse.failResponse(e);
		}
	}


}
