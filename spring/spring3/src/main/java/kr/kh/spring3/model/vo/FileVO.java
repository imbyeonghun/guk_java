package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {

	private int fi_num;
	private int fi_bo_num;
	private String fi_name;
	private String fi_ori_name;
	
	static final String [] imgExtensions = {".jpg", ".png", ".bmp", ".gif"};
	
	public FileVO(int fi_bo_num, String fi_name, String fi_ori_name) {
		this.fi_bo_num = fi_bo_num;
		this.fi_name = fi_name;
		this.fi_ori_name = fi_ori_name;
	}
	
	public boolean isImg() {
		if(fi_ori_name == null) 
			return false;
		for(String imgExtension : imgExtensions) {
			if(fi_ori_name.endsWith(imgExtension)) {
				return true;
			}
		}
		return false;
	}
}