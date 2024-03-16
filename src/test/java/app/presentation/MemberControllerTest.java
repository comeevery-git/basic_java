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
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.application.dto.member.CreateMemberDto;
import app.application.dto.member.UpdateMemberDto;
import app.domain.model.common.CommonCode;
import app.domain.model.common.ResponseCode;
import app.domain.model.entity.member.Role;
import app.domain.service.member.MemberService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("회원 등록 테스트")
    public void 회원_등록() throws Exception {
        CreateMemberDto dto = new CreateMemberDto();
        dto.setName("이름");
        dto.setEmail("이메일");
        dto.setRole(Role.valueOf("ADMIN"));

        mockMvc.perform(post("/api/v1/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(CommonCode.STATUS_SUCCESS))
                .andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
                .andDo(print());
    }

    @Test
    @DisplayName("회원 조회 테스트")
    public void 회원_조회() throws Exception {
        Long memberId = 1L;

        MvcResult result = mockMvc.perform(get("/api/v1/members/" + memberId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(CommonCode.STATUS_SUCCESS))
                .andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("회원 수정 테스트")
    public void 회원_수정() throws Exception {
        UpdateMemberDto dto = new UpdateMemberDto();
        dto.setName("이름1");
        dto.setEmail("이메일1");
        dto.setRole(Role.valueOf("ADMIN"));

        mockMvc.perform(put ("/api/v1/members/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(CommonCode.STATUS_SUCCESS))
            .andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
            .andDo(print());
    }


}