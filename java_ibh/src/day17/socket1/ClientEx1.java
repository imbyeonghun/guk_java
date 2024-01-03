package day17.socket1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientEx1 {

	// 클라이언트용 TCP소켓
	public static void main(String[] args) {

		// 서버의 ip, port번호 설정
		String ip = "192.168.30.210";
		int port = 5001;
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = null;
		
		// 1. ip와 port를 이용해 소켓 객체 생성 및 대기
		// try(코드) catch : 코드에 선언된 것만 자동으로 닫아줌
		try(Socket socket = new Socket(ip,port)){
			// 2. 연결 요청
			// socket.connect(new InetSocketAddress(ip, port));
			
			// 3. 작업
			System.out.println("연결 성공!!");
			
			// OutputStream으로 문자열 전송
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			// 서버에서 채팅 내역을 가져옴
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (ArrayList<String>) ois.readObject();
			
			// 채팅 내역을 조회
			System.out.println(list);
			
			while(true) {
				System.out.print("내용 [종료 : -1]: ");
				String str = scan.nextLine();
				// 문자열을 UTF-8로 보내기
				// 버퍼가 될때까지 대기하기 때문에 한번에 전송함
				// 때문에 oos.flush();로 보내기
				oos.writeUTF(str);	
				oos.flush();
				if(str.equals("-1")) {
					break;
				}
				// 기존 채팅 이력에 새로운 채팅 이력 추가
				list.add(str);
			}
			oos.close();
			
		} catch (UnknownHostException e) {
			System.out.println("연결할 수 없습니다.");
		} catch (IOException e) {
			System.out.println("예외 발생");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}