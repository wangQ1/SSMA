package cn.et.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.article.dao.ArticleDao;
import cn.et.article.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao ad;
	public List<Map<String, Object>> queryArticle(String seekContent) {
		return ad.queryArticle(seekContent);
	}
	public void deleteArticle(String id) {
		ad.deleteArticle(id);
	}
	public void updateArticle(String id, String title, String content) {
		ad.updateArticle(id, title, content);
	}
	public void saveArticle(String title, String content) {
		ad.saveArticle(title, content);
	}
}
