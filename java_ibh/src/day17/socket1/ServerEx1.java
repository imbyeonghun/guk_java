package day17.socket1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerEx1 {

	// 서버용 TCP소켓 프로그래밍
	public static void main(String[] args) {

		// 1. 서버의 포트번호를 정함
		int port = 5001;
		ArrayList<String> list = new ArrayList<String>();
		ServerSocket serverSocket = null;
		String fileName = "src/day17/socket1/chat.txt";
		
		list = load(fileName);
		System.out.println(list);
		System.out.println("불러오기 성공");
		try {
			// 2. 서버 소켓 객체 생성
			serverSocket = new ServerSocket(port);
			
			// accept() : 대기하다가 요청이 오면 수락 
			// 3. 클라이언트쪽에서 접속 요청이 오길 기다림
			// 4. 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			
			//5. 작업
			System.out.println("[연결 성공!]");

			// 읽어온 채팅 내역을 클라이언트로 전송
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(list);
			oos.flush();
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			while(true) {
				String str = ois.readUTF();
				if(str.equals("-1")) {
					break;
				}
				System.out.println(str);
				list.add(str);
			}
			ois.close();
			is.close();
			
		} catch (IOException e) {	// 이미 포트번호를 사용하고 있을 경우
			e.printStackTrace();
		}
		save(list,fileName);
	}

	private static void save(ArrayList<String> list, String fileName) {
		
		// FileOutputStream fos = new FileOutputStream(fileName)
		// ObjectOutputStream oos = new ObjectOutputStream(fos)
		// 두 코드를 하나로 합친 것
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			list.stream().forEach(str->{
				// 람다식에서 한 예외처리는 기존 예외처리와는 별개
				try {
					oos.writeUTF(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<String> load(String fileName){
		ArrayList<String> list = new ArrayList<String>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			// 반복문으로 읽어오다가 더 이상 읽어올게 없으면
			// 예외처리로 list반환
			while(true) {
				list.add(ois.readUTF());
			}
		}
		catch (IOException e) {
			return list;
		}
	}
}