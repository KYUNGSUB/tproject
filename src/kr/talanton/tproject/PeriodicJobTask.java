package kr.talanton.tproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PeriodicJobTask implements Job {
	private static final SimpleDateFormat TIMESTAMP_FMT = new SimpleDateFormat("yyyyMMddHHmm");

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Job Executed [" + new Date(System.currentTimeMillis()) + "]");
		String currentDate = TIMESTAMP_FMT.format(new Date());
		String triggerKey = context.getTrigger().getKey().toString(); // group1.trggerName
		System.out.println(String.format("[%s][%s]", currentDate, triggerKey));

		DatabaseProcessor dp = DatabaseProcessor.getInstance();
		Long iid = dp.storeInfoReqTable(currentDate);		// InfoReq 테이블에 현황정보 저장
		NaverInterworkManager ni = NaverInterworkManager.getInstance();
		List<StockInfoVO> stockList = ni.getCurrentStockInfo(false);	// 주식 시세 정보 가져오기
		dp.storeStockListInfo(stockList, iid);	// 데이터베이스에 저장(sise_info 테이블)
		dp.updateInfoReqTable(iid, stockList.size());	// InfoReq 테이블에 주식 갯수 저장
	}
}