package cn.et.article.dao;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
	public  List<Map<String, Object>> queryArticle(String seekContent);

	public void updateArticle(String id, String title, String content);

	public void saveArticle(String title, String content);
	
	public void deleteArticle(String id);
}
