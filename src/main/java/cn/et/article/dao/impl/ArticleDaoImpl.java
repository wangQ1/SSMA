package cn.et.article.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cn.et.article.dao.ArticleDao;
import cn.et.article.mapper.ArticleMapper;
@Repository
public class ArticleDaoImpl implements ArticleDao{
	@Autowired
	ArticleMapper am;
	public  List<Map<String, Object>> queryArticle(String seekContent) {
		return am.queryArticle(seekContent);
	}
	public void updateArticle(String id, String title, String content) {
		am.updateArticle(id, title, content);
	}
	public void saveArticle(String title, String content) {
		am.saveArticle(title, content);
	}
	public void deleteArticle(String id) {
		am.deleteArticle(id);
	}
}