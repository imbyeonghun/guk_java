package day18.socket1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Client {
	
	private Socket socket;
	
	/**
	 *  읽기 기능
	 */
	public void receive() {
		/*
		// 람다식을 이용하지 않을 때 사용법
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		
		Thread t = new Thread(()->{
			ObjectInputStream ois = null;
			try{
				ois = new ObjectInputStream(socket.getInputStream());
				while(true) {
					String str = ois.readUTF();	// 읽어오기
					if(str.equals("-1")) {
						break;
					}
					System.out.println(str);	// 출력
				}
				System.out.println("읽기 기능이 정상 종료합니다.");
			} catch (Exception e) {
				System.out.println("예외가 발생해서 읽기 기능을 종료합니다.");
			}
		});
		t.start();
	}
	
	/**
	 * 전송 기능
	 */
	public void send() {
		Thread t = new Thread(()->{
			ObjectOutputStream oos = null;
			try{
				oos = new ObjectOutputStream(socket.getOutputStream());
				Scanner scan = new Scanner(System.in);
				while(true) {
					String str = scan.nextLine();
					oos.writeUTF(str);
					oos.flush();
					if(str.equals("-1")) {
						break;
					}
				}
				System.out.println("전송 기능이 정상 종료합니다.");
			} catch (Exception e) {
				System.out.println("예외가 발생해서 전송 기능을 종료합니다.");
			}
		});
		t.start();
	}
}