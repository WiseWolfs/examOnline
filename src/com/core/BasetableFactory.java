package com.core;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import com.core.*;
import com.dao.*;
import com.model.*;

public abstract class BasetableFactory {
	public abstract int getRow(String sql);

	// user
	public abstract boolean CreatUser(HttpServletRequest request);

	public abstract User SearchUser(String sql);

	public abstract Collection ListUser(int page, String sql);

	public abstract boolean DeleteUser(String sql);

	// select
	public abstract Collection ListSelect(int page, String sql);

	public abstract Collection ListSelect_r(int page, String sql);// 随机抽取选择题列表

	public abstract boolean CreatSelect(HttpServletRequest request);

	public abstract boolean DeleteSelect(String sql);

	public abstract Select SearchSelect(String sql);
	
	//blank
	public abstract Collection ListBlank(int page, String sql);

	public abstract boolean CreatBlank(HttpServletRequest request);

	public abstract boolean DeleteBlank(String sql);

	public abstract Blank SearchBlank(String sql);
	

	// paper
	public abstract boolean CreatPaper(HttpServletRequest request);

	public abstract boolean UpdatePaper(HttpServletRequest request);

	public abstract Paper SearchPaper(String sql);
	
	//selectchp
	public abstract Collection ListSelectChp(int page,String sql);
	
	public abstract boolean CreatSelectChp(HttpServletRequest request);
	
	public abstract boolean DeleteSelectChp(String sql);
	
	public abstract SelectChp SearchSelectChp(String sql);
	
	//blankchp
	public abstract Collection ListBlankChp(int page,String sql);
	
	public abstract boolean CreatBlankChp(HttpServletRequest request);
	
	public abstract boolean DeleteBlankChp(String sql);
	
	public abstract BlankChp SearchBlankChp(String sql);
	
	//selectdiff
	public abstract Collection ListSelectDiff(int page,String sql);
	public abstract SelectDiff SearchSelectDiff(String sql);
	public abstract boolean CreatSelectDiff(HttpServletRequest request);
	public abstract boolean DeleteSelectDiff(String sql);
	
	//blankdiff
	public abstract Collection ListBlankDiff(int page,String sql);
	public abstract BlankDiff SearchBlankDiff(String sql);
	public abstract boolean CreatBlankDiff(HttpServletRequest request);
	public abstract boolean DeleteBlankDiff(String sql);
	

}
