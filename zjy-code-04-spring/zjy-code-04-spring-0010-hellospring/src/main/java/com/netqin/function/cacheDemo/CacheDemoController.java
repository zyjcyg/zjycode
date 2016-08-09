/*
 * COPYRIGHT Beijing NetQin-Tech Co.,Ltd.                                   *
 ****************************************************************************
 * Դ�ļ���: CacheDemoController.java 														       
 * ����: �������ļ����ܣ�													   
 * �汾:	@version 1.0	                                                                   
 * ��������: 2010-3-1							    						   
 * ˵��: ������ʹ���ļ�����ʱ����Լ������                                       
 * �޸���ʷ: (��Ҫ��ʷ�䶯ԭ��˵��)		
 * YYYY-MM-DD |    Author      |	 Change Description		      
 * 2010-3-1   |  hanqunfeng    |  Created 
 */
package com.netqin.function.cacheDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CacheDemoController {
	@Autowired
	private CacheDemoService service;

	@RequestMapping("/demo.do")
	public String handleIndex(Model model) {

		System.out.println(service.getName(0));
		model.addAttribute("name", service.getName(0));

		return "cacheDemo";
	}
	
	
	@RequestMapping("/demoFulsh.do")
	public String handleFulsh(Model model) {
		return "cacheDemo";
	}

}
