package kr.talanton.tproject;

import java.util.List;
import lombok.Data;

@Data
public class SiseInfoVO {
	private int totCnt;					// 응답 주식 갯수
	private String ms;				// 시장 상태 : 개장(OPEN), 폐장
	private List<StockInfoVO> itemList;	// 응답 주식 시세정보 데이터
}