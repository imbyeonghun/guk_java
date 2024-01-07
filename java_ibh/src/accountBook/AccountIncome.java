package accountBook;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

// 가계부 클래스
@Data
@AllArgsConstructor
public class AccountIncome {
	Date date;		// 일자
	int income;		// 수입
	String goods;
	
	@Override
	public String toString() {
		return "수입 내역 [ 일자 = " + date + ", 수입 = " + income + ", 품목 = " + goods + "]";
	}
}