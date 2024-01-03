package day17;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class IpEx1 {

	public static void main(String[] args) {
		InetAddress address = null;
		
		try {
			// localhost : 내부 IP를 의미, 모든 PC가 동일
			address = InetAddress.getByName("localhost");
			System.out.println(address);
			
			// naver의 IP주소 중 하나를 조회
			address = InetAddress.getByName("www.naver.com");
			System.out.println(address);
			
			// 내 PC의 IP주소 조회
			address = InetAddress.getLocalHost();
			System.out.println(address);
			
			// 네이버의 IP주소들을 조회하는 코드 작성
			InetAddress[] addressList = InetAddress.getAllByName("www.naver.com");
			Arrays.stream(addressList).forEach(addr->System.out.println(addr));
		} catch (UnknownHostException e) {	// host의 이름을 알 수 없습니다.
			System.out.println("해당 이름과 일치하는 IP정보를 찾을 수 없습니다.");
		}
	}

}