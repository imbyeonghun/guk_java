package accountBook;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class AccountManager {

	private List<Account> list = new ArrayList<Account>();
	private List<AccountIncome> listIncome = new ArrayList<AccountIncome>();
	@NonNull
	private int total;
	
	/*
	 * 지출 내역 추가
	 */
	public void insertAccount(Account ac) {
		list.add(ac);
		System.out.println("지출내역을 추가했습니다.");
	}
	
	/*
	 * 지출 내역 조회
	 */
	public void printAccount() {
		list.stream().forEach((s)->System.out.println(s));
	}
	
	/*
	 * 수입 내역 추가
	 */
	public void insertAccountIncome(AccountIncome ai) {
		listIncome.add(ai);
		System.out.println("수입내역을 추가했습니다.");
	}
	
	/*
	 * 수입 내역 조회
	 */
	public void printAccountIncome() {
		listIncome.stream().forEach((s)->System.out.println(s));
	}
}