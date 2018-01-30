package com.prosay.msg;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
@WebServlet("/getCode.do")
public class GetCode extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//生成1个六位数随机数
		String str = "";//0 1 2 3 4 5
		for(int i = 0 ; i < 6;i++){
			str+=(int)Math.floor(Math.random()*10);
		}
		String phone = request.getParameter("phone");
		//将验证码添加到session中
		request.getSession().setAttribute("code", str);
		//发送短信 17737202035
		sendMsg(phone,str);
		response.getWriter().print(str);
		
	}
	public static void main(String [] args){
		GetCode t = new GetCode();
		t.sendMsg("17737202035", "666666");
	}
	private void sendMsg(String phone,String code){
		TaobaoClient client = new DefaultTaobaoClient("	http://gw.api.taobao.com/router/rest", "24528234", "b3392019417cb33865c3d492525e70d6");
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("");
		req.setSmsType("normal");
		req.setSmsFreeSignName("猿说教育");
		req.setSmsParamString("{\"code\":\""+code+"\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_74820011");
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
