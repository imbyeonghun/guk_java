package accountBook;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

// 가계부 클래스
@Data
@AllArgsConstructor
public class Account {
	
	Date date;			// 일자
	String goods;		// 품목
	int amount,price;	// 수량, 금액
	
	@Override
	public String toString() {
		return "지출 내역 [일자 = " + date + ", 품목 = " + goods + 
				", 수량 = " + amount + ", 가격 = " + price + ", 총액 = " + amount*price + "]";
	}
}