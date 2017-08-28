package com.test;

import com.alibaba.fastjson.JSONObject;
import com.data.InItTemplate;
import com.job.AccessToken;
import com.job.AccessTokenManager;
import com.util.HttpClientUtil;
import com.util.MessAgeUtil;
import com.util.WeiXinUtil;
import com.wx.entitys.template.TemplateCtent;
import com.wx.entitys.template.TemplateUser;

public class WeiXinTest {
	public static void main(String[] args) {
	/*
		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		url=url.replace("APPID",AccessTokenManager.APPID);
		url=url.replace("APPSECRET",AccessTokenManager.AppSecret);
	String json	=HttpClientUtil.httpGet(url);
	AccessToken accessToken=JSONObject.parseObject(json, AccessToken.class);
	System.out.println(accessToken.getAccess_token());
	*/
	
	/*	String pach="D:/huajie.jpg";
		try {
			
		System.out.println(MessAgeUtil.FileupLoad(pach, AccessTokenManager.Access_Token, "thumb"));	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
		/*
	String menu=WeiXinUtil.initMenu();	
	String msg=WeiXinUtil.sendMenu(AccessTokenManager.Access_Token, menu);
	System.out.println(msg);
	*/
	String tmpId= MessAgeUtil.GetTemplate_id("TM00040", AccessTokenManager.Access_Token);
	String[] op=MessAgeUtil.getUserList(AccessTokenManager.Access_Token, "");
	for(int i=0;i<op.length;i++)
	{
	  TemplateUser templateUser=InItTemplate.getTemplateCtent(op[i],tmpId);
	  MessAgeUtil.sendTemplate(AccessTokenManager.Access_Token, templateUser);
	}
	}
}
