package app.presentation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.application.dto.payment.CreatePaymentDto;
import app.application.dto.payment.UpdatePaymentDto;
import app.application.vo.payment.CreatePaymentVo;
import app.application.vo.payment.UpdatePaymentVo;
import app.domain.model.common.BaseResponse;
import app.domain.service.payment.PaymentService;
import app.infrastructure.annotation.CommonResponseCode;
import app.infrastructure.exception.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Payment", description = "결제=>결제수단 관련 API")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/payments")
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


	@PutMapping("/{payment_id}")
	@Operation(summary = "결제수단 수정", description = "결제수단을 수정합니다.")
	@CommonResponseCode
	public BaseResponse<UpdatePaymentVo> updatePayment(@PathVariable(name = "payment_id") final Long paymentId
												  		, @RequestBody final UpdatePaymentDto dto) {
		dto.setPaymentId(paymentId);
		log.info("UpdatePaymentDto: {}", dto);
		try {
			UpdatePaymentVo paymentVo = paymentService.updatePayment(dto);
			return BaseResponse.successResponse(paymentVo);
		} catch (CustomException e) {
			return BaseResponse.failResponse(e.getResponseCode());
		} catch (Exception e) {
			return BaseResponse.failResponse(e);
		}
	}


}
