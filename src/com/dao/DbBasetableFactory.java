package com.dao;

import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import com.core.*;
import com.model.*;
import com.dao.*;

public class DbBasetableFactory  extends BasetableFactory{

	public DbBasetableFactory() {

	}

	// paper试卷
	public boolean CreatPaper(HttpServletRequest request) {
		return (new Dbpaper(request)).Insert();
	}
	public boolean UpdatePaper(HttpServletRequest request){
		return (new Dbpaper(request).Update());
	}
	public Paper SearchPaper(String sql){
		return new Dbpaper().Dbpapers(sql);
	}

	// user
	public boolean DeleteUser(String sql) {
		return DataBase.Delete(FinalConstants.DELETE_USER + sql);
	}

	public boolean CreatUser(HttpServletRequest request) {
		return (new Dbuser(request)).Insert();
	}

	public Collection ListUser(int page, String sql) {
		return new Dbuser().Select(page, sql);
	}

	public User SearchUser(String sql) {
		return new Dbuser().Dbusers(sql);
	}

	// 记录总数
	public int getRow(String sql) {
		return DataBase.getRow(sql);

	}

	// select
	public Collection ListSelect(int page, String sql) {
		return new Dbselect().Select(page, sql);
	}
	
	public Collection ListSelect_r(int page, String sql) {
		return new Dbselect().Select_r(page, sql);

	}
	public boolean CreatSelect(HttpServletRequest request) {
		return (new Dbselect(request)).Insert();
	}

	public boolean DeleteSelect(String sql) {
		return DataBase.Delete(FinalConstants.DELETE_SELECT + sql);
	}

	public Select SearchSelect(String sql) {
		return new Dbselect().Dbselects(sql);
	}
	//selectchp
	public Collection ListSelectChp(int page,String sql){
		return new Dbselectchp().Select(page,sql);
	}
	public boolean CreatSelectChp(HttpServletRequest request) {
		return (new Dbselectchp(request)).Insert();
	}

	public boolean DeleteSelectChp(String sql) {
		return DataBase.Delete(FinalConstants.DELETE_SELECTCHP + sql);
	}

	public SelectChp SearchSelectChp(String sql) {
		return new Dbselectchp().Dbselectchps(sql);
	}
	
	//blankchp
	public Collection ListBlankChp(int page,String sql){
		return new Dbblankchp().BlankChp(page,sql);
	}
	public boolean CreatBlankChp(HttpServletRequest request) {
		return (new Dbblankchp(request)).Insert();
	}

	public boolean DeleteBlankChp(String sql) {
		return DataBase.Delete(FinalConstants.DELETE_BLANKCHP + sql);
	}

	public BlankChp SearchBlankChp(String sql) {
		return new Dbblankchp().Dbblankchps(sql);
	}
	//selectdiff
	public boolean DeleteSelectDiff(String sql){
		return DataBase.Delete(FinalConstants.DELETE_SELECTDIFF);
		
	}
	public Collection ListSelectDiff(int page,String sql){
		return new Dbselectdiff().Select(page,sql);
		
	}
	public SelectDiff SearchSelectDiff(String sql){
		return new Dbselectdiff().Dbselectdiffs(sql);
	}
	public boolean CreatSelectDiff(HttpServletRequest request) {
		return (new Dbselectdiff(request)).Insert();
	}
	
	//blank判断题
	public Collection ListBlank(int page, String sql) {
		return new Dbblank().Blank(page, sql);
	}
	
	public boolean CreatBlank(HttpServletRequest request) {
		return (new Dbblank(request)).Insert();
	}

	public boolean DeleteBlank(String sql) {
		return DataBase.Delete(FinalConstants.DELETE_BLANK + sql);
	}

	public Blank SearchBlank(String sql) {
		return new Dbblank().Dbblanks(sql);
	}
//blankdiff
	public boolean CreatBlankDiff(HttpServletRequest request) {
		return (new Dbblankdiff(request)).Insert();
	}

	public boolean DeleteBlankDiff(String sql) {
		return DataBase.Delete(FinalConstants.DELETE_BLANKDIFF + sql);
	}

	public Collection ListBlankDiff(int page, String sql) {
		return new Dbblankdiff().BlankDiff(page,sql);
	}
	public BlankDiff SearchBlankDiff(String sql) {
		return new Dbblankdiff().Dbblankdiffs(sql);
	}


}
