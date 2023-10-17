package kr.talanton.tproject;

import lombok.Data;		// lombok (자동 Getter, Setter)

@Data
public class SiseResponseVO {	// 응답 형식
	private SiseInfoVO result;	// 응답 데이터
	private String resultCode;	// 성공 여부
}
