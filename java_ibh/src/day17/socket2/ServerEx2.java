package day17.socket2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx2 {

	// 서버용 TCP소켓 프로그래밍
	public static void main(String[] args) {

		// 1. 서버의 포트번호를 정함
		int port = 5001;
		ServerSocket serverSocket = null;
		
		try {
			// 2. 서버 소켓 객체 생성
			serverSocket = new ServerSocket(port);
			
			// accept() : 대기하다가 요청이 오면 수락 
			// 3. 클라이언트쪽에서 접속 요청이 오길 기다림
			// 4. 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			
			//5. 작업
			System.out.println("[연결 성공!]");
			
			// 클라이언트가 보낸 문자열을 읽어와서 콘솔에 출력하는 Thread
			Thread receiveThread = new Thread(()->{
				try {
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					// 상대방이 채팅을 보내면 서버쪽에 출력
					while(true) {
						String str = ois.readUTF();
						if(str.equals("-1")) {
							break;
						}
						System.out.println(str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("서버 : 받는 기능 종료");
			});
			receiveThread.start();
			
			// 문자열을 입력받아 클라이언트에 전송하는 Thread
			Thread sendThread = new Thread(()->{
				try{
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					Scanner scan = new Scanner(System.in);
					while(true) {
						String str = scan.nextLine();
						oos.writeUTF(str);
						oos.flush();
						if(str.equals("-1")) {
							break;
						}
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println("클라이언트 : 보내는 기능 종료");
			});
			sendThread.start();
			
		} catch (IOException e) {	// 이미 포트번호를 사용하고 있을 경우
			e.printStackTrace();
		}
		System.out.println("서버 : 메인 기능 종료");
	}
}