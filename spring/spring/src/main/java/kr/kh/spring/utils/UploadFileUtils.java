package kr.kh.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
    public static String uploadFile(String uploadPath, String originalName, byte[]
            fileData)throws Exception{
    	// UUID => 랜덤한 16자리 수 생성 => 같은 파일명을 구분할 수 있기 위해 처리
        UUID uid = UUID.randomUUID();
        
        // 파일명에 'UUID_파일명'으로 변경 
        String savedName = uid.toString() +"_" + originalName;

        // 파일을 저장할 경로(날짜 경로로 업로드하는 날짜이며, 년/월/일로 구성)
        String savedPath = calcPath(uploadPath);
        
        // 서버에 업로드할 파일 객체 생성
        File target = new File(uploadPath + savedPath, savedName);

        // fileData를 target에 복사 => 파일을 서버에 업로드
        FileCopyUtils.copy(fileData, target);
        
        // 업로드한 파일의 파일명을 가져옴
        // 아래에서 만든 \를 /로 변경하는 getFileName사용
        String uploadFileName = getFileName(savedPath, savedName);
        return uploadFileName;
    }

    // 날짜 폴더 만들때 사용할 날짜를 구분해서 makeDir메서드로 폴더 생성
    private static String calcPath(String uploadPath) {
        Calendar cal = Calendar.getInstance();

        String yearPath = File.separator+cal.get(Calendar.YEAR);
        String monthPath = yearPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
        String datePath = monthPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
        makeDir(uploadPath, yearPath, monthPath, datePath);

        return datePath;

    }
    
    // 입력받은 날짜로 폴더 만들때 사용한 메서드
    private static void makeDir(String uploadPath, String... paths) {
        if(new File(paths[paths.length-1]).exists())
            return;
        for(String path : paths) {
            File dirPath = new File(uploadPath + path);
            if( !dirPath.exists())
                dirPath.mkdir();
        }
    }
    
    // 경로와 이름이 주어지면 \를 /로 변경하지 위해 생성된 메서드
    private static String getFileName(String path, String fileName)
            throws Exception{
        String iconName = path + File.separator + fileName;
        return iconName.replace(File.separatorChar, '/');
    }

	public static void deleteFile(String uploadPath, String fi_name) {
		fi_name = fi_name.replace('/', File.separatorChar);	// / => \ 로 변경
		File file = new File(uploadPath + fi_name);
		
		// 파일이 존재하면 파일을 삭제
		if(file.exists()) {
			file.delete();	// 삭제해주는 메서드 (툴에서 제공)
		}
	}
}