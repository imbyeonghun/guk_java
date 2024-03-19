package kr.kh.spring.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendVO {

	private int re_num;
	private String re_me_id;
	private int re_bo_num;
	private int re_state;
}