package cn.et.article.service;

import java.util.List;
import java.util.Map;

public interface ArticleService {
	/**
	 * 查询文章
	 * @param seekContent 搜索的内容
	 * @return 文章数组
	 */
	public List<Map<String, Object>> queryArticle(String seekContent);

	public void deleteArticle(String id);

	public void updateArticle(String id, String title, String content);

	public void saveArticle(String title, String content);
}
