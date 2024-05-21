package app.presentation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.payment.application.dto.CreatePaymentDto;
import app.payment.application.dto.UpdatePaymentDto;
import app.common.domain.model.common.CommonCode;
import app.common.domain.model.common.ResponseCode;
import app.payment.domain.model.entity.Status;
import app.payment.domain.service.PaymentService;
import app.payment.presentation.PaymentController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PaymentService paymentService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	@DisplayName("결제수단 등록 테스트")
	public void 결제수단_등록() throws Exception {
		CreatePaymentDto dto = new CreatePaymentDto();
		dto.setMemberId(1L);
		dto.setPaymentMethod("계좌이체");
		dto.setPaymentMethodNumber("00000000000");

		mockMvc.perform(post("/api/v1/payments")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto))
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.status").value(CommonCode.STATUS_SUCCESS))
			.andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
			.andDo(print());
	}

	@Test
	@DisplayName("결제수단 수정 테스트")
	public void 결제수단_수정() throws Exception {
		UpdatePaymentDto dto = new UpdatePaymentDto();
		dto.setMemberId(1L);
		dto.setStatus(Status.INACTIVE);

		mockMvc.perform(put("/api/v1/payments/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto))
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.status").value(CommonCode.STATUS_SUCCESS))
			.andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
			.andDo(print());
	}


}