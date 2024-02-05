package kr.kh.account.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;

public interface AccountService {

	List<Type> getTypeList();

	List<Category> getCategoryList(@Param("ty_name") String type);

	boolean insertItem(Item item, String type);
}