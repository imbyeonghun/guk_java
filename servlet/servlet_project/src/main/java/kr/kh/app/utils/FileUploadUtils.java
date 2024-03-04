package kr.kh.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class FileUploadUtils {
	
	public static String getFileName(Part part) {
		
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			// item은 다음과 같은 형태로 구성
			// 속성명 = 값
			if(item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=") + 2,item.length() - 1);
			}
		}
		return null;
	}
	
	public static String upload(String uploadPath, Part part) {

		// 저장할 파일 이름을 추가
		String fileName = getFileName(part);
		// 경로가 포함된 파일명
		String filePath = uploadPath + File.separator + fileName;
		
		// 클라이언트가 보내준 파일에서 InputStream으로 읽어와서 서버에 OutputStream으로 파일을 생성
		try(InputStream is = part.getInputStream();
			OutputStream os = new FileOutputStream(filePath)){
			byte[] buffer = new byte[1024*4];	// 4kb씩 읽어와서 덮어쓰기
			int readCount;	// 읽어온 개수
			// InputStream.read(byte[])은 읽어와서 배열에 저장 후 읽어온 개수를 반환
			// 읽어온 개수가 없으면 -1을 리턴
			while((readCount = is.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
			return filePath;
		}catch(Exception e) {
			return null;
		}
	}
}