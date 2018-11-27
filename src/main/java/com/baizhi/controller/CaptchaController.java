package com.baizhi.controller;


import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class CaptchaController {
	@Autowired
	private Producer captchaProducer = null;

	@RequestMapping("/getKaptcha")
	public void getKaptcha(HttpSession session, HttpServletResponse response) throws IOException {
		//1.生成文本内容
		String text = captchaProducer.createText();
		//2.将文本内容放入session
		session.setAttribute("code", text);
		//3.将文本内容放入一张图片中生成一张图片
		BufferedImage image = captchaProducer.createImage(text);
		//通过工具类将图片写入到图片输出流
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
}
