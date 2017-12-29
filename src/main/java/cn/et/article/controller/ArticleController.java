package cn.et.article.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.article.service.ArticleService;
/**
 * springMvc中的Model相关的对象是 用来处理和传输数据的对象
 * @Valid 自动应用jsr303
 * @ModelAttribute 用来重命名参数数据
 * Model、ModelMap、Map 都是用来传递数据到视图（request.setAttribute）建议用Map
 * ModelAndView 绑定数据到视图 ，ModelMap用于传递数据，View用于跳转
 * @SessionAttributes 用于请求重定向(redirect) 可以将参数数据存储在session中，使用时必须手动实例化，使用之后必须清除
 * @author Administrator
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleService as;
	/**
	 * 第三种:直接返回对象, springMvc自动转换成json，由jackson实现
	 * 需要添加配置消息转换器
	 * @param seekContent
	 * @return
	 * @throws Exception
	 */
	@ResponseBody//必须添加， 说明这是一个响应体，而不是一个跳转页面
	@RequestMapping(value="/qa", method=RequestMethod.GET)
	public List<Map<String, Object>> queryAll(String seekContent) throws Exception{
		List<Map<String, Object>> selectArticle = as.queryArticle(seekContent);
		return selectArticle;
	}
	/**
	 * 添加新文章
	 * @param title 文章标题
	 * @param content 文章内容
	 * @param os
	 * @return
	 */
	@RequestMapping(value="/sa", method=RequestMethod.POST)
	public String addArticle(String title, String content, OutputStream os) throws Exception{
		try {
			as.saveArticle(title, content);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 删除文章
	 * @param id 文章id
	 * @param os
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/da/{id}", method=RequestMethod.DELETE)
	public String deleteArticle(@PathVariable String id, OutputStream os) throws Exception{
		try {
			as.deleteArticle(id);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 修改文章
	 * @param id 文章id
	 * @param title 文章标题
	 * @param content 文章内容
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/ua/{id}", method=RequestMethod.PUT)
	public String updateArticle(@PathVariable String id, String title, String content, OutputStream os) throws Exception{
		try {
			as.updateArticle(id, title, content);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
}
