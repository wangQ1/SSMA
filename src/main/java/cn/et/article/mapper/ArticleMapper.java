package cn.et.article.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ArticleMapper {
	/**
	 * 根据内容查询新闻
	 * @param seekContent
	 * @return
	 */
	@Select("select * from article where a_content like '%${seekContent}%'")
	public List<Map<String, Object>> queryArticle(@Param("seekContent") String seekContent);
	/**
	 * 根据id修改新闻
	 * @param id
	 * @param title
	 * @param content
	 */
	@Update("update article set a_title = #{1}, a_content = #{2} where a_id = #{0}")
	public void updateArticle(String id, String title, String content);
	/**
	 * 添加新的新闻
	 * @param title
	 * @param content
	 */
	@Insert("insert into article(a_title, a_content) values(#{0}, #{1})")
	public void saveArticle(String title, String content);
	/**
	 * 根据id删除新闻
	 * @param id
	 */
	@Delete("delete from article where a_id = #{0}")
	public void deleteArticle(String id);
}
