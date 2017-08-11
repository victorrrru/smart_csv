package cn.interheart.hr.hr.web;

import cn.interheart.hr.service.UploadDeviceTmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring MVC Controler - 表：upload_device_tmp
 * @since 2017-05-31 14:34:35
 */
@Controller
@RequestMapping(value = "/hr")
public class UploadDeviceTmpAction {
	private static final Logger logger = LoggerFactory.getLogger(UploadDeviceTmpAction.class);

	@Autowired
	private UploadDeviceTmpService uploadDeviceTmpService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/uploaddevicetmp", method=RequestMethod.GET)
	public Object listPage() {
		return "uploaddevicetmp";
	}


}