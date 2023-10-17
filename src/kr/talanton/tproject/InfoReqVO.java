package kr.talanton.tproject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoReqVO {
	Long iid;			// ID
	String req_time;	// 시간
	int count;			// 갯수
}