package com.util;

import com.alibaba.fastjson.JSONObject;
import com.wx.entitys.btn.Button;
import com.wx.entitys.btn.ClickButton;
import com.wx.entitys.btn.Menu;
import com.wx.entitys.btn.ViewButton;

public class WeiXinUtil {
	//初始化菜单
	public static String  initMenu()
	{
		String result=null;
		Menu menu=new Menu();
		ClickButton ck1_1=new ClickButton(); 
		ClickButton ck2_1=new ClickButton(); 
		ViewButton vb_3=new ViewButton();
	
		ck1_1.setType("click");
		ck1_1.setName("资本剑客");
		ck1_1.setKey("120");
		ck2_1.setType("click");
		ck2_1.setName("人员介绍");
		ck2_1.setKey("220");
		
		vb_3.setName("疑难杂症");
		vb_3.setType("view");
		vb_3.setUrl("http://www.baidu.com");
		
		ClickButton ck1_2=new ClickButton();
		ck1_2.setName("公司介绍");
		ck1_2.setType("click");
		ck1_2.setKey("120");
		ClickButton ck1_3=new ClickButton();
		ck1_3.setName("人员介绍");
		ck1_3.setType("click");
		ck1_3.setKey("130");
		ViewButton vk1_4=new ViewButton();
		vk1_4.setName("公司HP");
		vk1_4.setType("view");
		vk1_4.setUrl("http://www.txcf888.com");
		ck1_1.setSub_button(new Button[]{ck1_2,ck1_3,vk1_4});
//		<------------------------------------------>
		ClickButton ck2_2=new ClickButton();
		ck2_2.setName("相关人员介绍");
		ck2_2.setType("click");
		ck2_2.setKey("220");
		ClickButton ck2_3=new ClickButton();
		ck2_3.setName("技术人员介绍");
		ck2_3.setType("click");
		ck2_3.setKey("230");
		ViewButton vk2_4=new ViewButton();
		vk2_4.setName("相关链接");
		vk2_4.setType("view");
		vk2_4.setUrl("http://www.txcf888.com");
		ck2_1.setSub_button(new Button[]{ck2_2,ck2_3,vk2_4});

		menu.setButton(new Button[]{ck1_1,ck2_1,vb_3});
		result=JSONObject.toJSONString(menu);
		System.out.println(result);
		return result;
	}
	public static String sendMenu(String access_token,String data)
	{
		String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
		url=url.replace("ACCESS_TOKEN", access_token);
		return 	HttpClientUtil.httpPost(url, data);
	}
}
