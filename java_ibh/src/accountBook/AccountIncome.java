package accountBook;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// 가계부 클래스
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountIncome {
	@NonNull
	Date date;		// 일자
	@NonNull
	int income;	// 수입
	@NonNull
	String goods;
	int total;	// 총액 = 초기자금, 지출시 잔액
}