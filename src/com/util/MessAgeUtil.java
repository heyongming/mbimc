package com.util;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.wx.entitys.NewsItem;
import com.wx.entitys.NewsTextMessage;
import com.wx.entitys.TextMessage;

public class MessAgeUtil {
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_NEWS = "news";

	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";

	// 把XML文件转为map集合
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader saxReader = new SAXReader();
		InputStream is = request.getInputStream();
		Document doc = saxReader.read(is);
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for (Element element : list) {
			map.put(element.getName(), element.getText());

		}
		return map;
	}

	// 把文本消息转为XML
	public static String textToXml(TextMessage textMessage) {

		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());

		String xmlStr = xStream.toXML(textMessage);

		return xmlStr;

	}

	// 把MAP集合转成文本对象
	public static TextMessage mapToTextMessage(Map<String, String> map) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(map.get("ToUserName"));
		textMessage.setFromUserName(map.get("FromUserName"));
		textMessage.setMsgType(map.get("MsgType"));
		textMessage.setMsgId(map.get("MsgId"));
		textMessage.setContent(map.get("Content"));
		textMessage.setCreateTime(map.get("CreateTime"));
		if (map.get("Event") != null) {
			textMessage.setEvent(map.get("Event"));
		}
		if (map.get("EventKey") != null) {
			textMessage.setEventKey(map.get("EventKey"));
		}

		return textMessage;
	}

	// 显示主菜单
	public static String showMenu() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("终于等到你！还好我没放弃！\n\n");
		sbf.append("1.资本剑客说相关介绍\n");
		sbf.append("2.迈步相关介绍\n");
		sbf.append("3.课程相关介绍\n");
		sbf.append("4.自身教师介绍\n");
		sbf.append("5.企业文化介绍\n");
		sbf.append("重复显示请输入?或者help\n");
		return sbf.toString();
	}

	public static String overOut() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("有缘再见\n");
		return sbf.toString();
	}

	// 其他選項
	public static String ontherMenu() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("相关功能正在开发中，请期待\n");
		return sbf.toString();
	}

	// 初始化文本消息
	public static TextMessage initText(TextMessage message) {
		TextMessage ToMessage = new TextMessage();
		ToMessage.setToUserName(message.getFromUserName());
		ToMessage.setFromUserName(message.getToUserName());
		ToMessage.setMsgType(MESSAGE_TEXT);
		ToMessage.setCreateTime(new Date().getTime() + "");
		ToMessage.setContent(message.getContent());
		return ToMessage;
	}

	// 初始化图文消息
	public static NewsTextMessage initNewText(TextMessage message, List<NewsItem> newItem) {
		NewsTextMessage ntm = new NewsTextMessage();
		ntm.setFromUserName(message.getToUserName());
		ntm.setToUserName(message.getFromUserName());
		ntm.setMsgType(MessAgeUtil.MESSAGE_NEWS);
		ntm.setArticles(newItem);
		ntm.setArticleCount(newItem.size());
		ntm.setCreateTime(new Date().getTime() + "");

		return ntm;
	}

	// 图文消息转成XML
	public static String NewsTextToXml(NewsTextMessage newsTextMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml", newsTextMessage.getClass());
		xStream.alias("item", newsTextMessage.getArticles().get(0).getClass());
		String xmlStr = xStream.toXML(newsTextMessage);

		return xmlStr;
	}
}
