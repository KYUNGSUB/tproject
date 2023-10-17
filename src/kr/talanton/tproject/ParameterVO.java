package kr.talanton.tproject;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParameterVO {
	Long pid;		// parameter ID
	String name;	// parameter 이름
	String value;	// 값
	Date regdate;	// 등록일
	Date moddate;	// 변경일
}