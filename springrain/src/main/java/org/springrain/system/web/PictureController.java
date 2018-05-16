package org.springrain.system.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springrain.frame.util.JsonUtils;
import org.springrain.system.common.FastDFSClient;

@Controller
public class PictureController {
	
	private String IMAGE_SERVER_URL = "http://192.168.25.133/";
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile) {
		try {
			//取扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			FastDFSClient dfsClient = new FastDFSClient("classpath:conf/client.conf");
			String path = dfsClient.uploadFile(uploadFile.getBytes(), extName);
			String url = IMAGE_SERVER_URL+path;
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			return JsonUtils.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return JsonUtils.writeValueAsString(result);
		}
	}
}
