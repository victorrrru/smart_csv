package cn.smart.hr.web;

import cn.smart.service.HrDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * Spring MVC Controler - 表：hr_data
 * @since 2017-05-31 14:34:20
 */
@Controller
@RequestMapping(value = "/hr")
public class HrDataAction {
	private static final Logger logger = LoggerFactory.getLogger(HrDataAction.class);

	@Autowired
	private HrDataService hrDataService;


	@RequestMapping(value = "uploadDevice",method = RequestMethod.POST)
	@ResponseBody
	public Object uploadDevice( MultipartFile file) throws Exception {
		hrDataService.uploadDevice(file.getOriginalFilename(),file.getInputStream());
		return new HashMap<>();
	}

	@RequestMapping(value = "uploadData",method = RequestMethod.POST)
	@ResponseBody
	public Object uploadData(@RequestParam(value = "file") MultipartFile file) throws Exception {

		hrDataService.uploadData(file.getOriginalFilename(),file.getInputStream());
		return new HashMap<>();
	}



}