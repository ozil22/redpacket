package com.liuhe.redpacket.web.oms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhe.redpacket.domain.SystemDictionary;
import com.liuhe.redpacket.service.ISystemDictionaryService;
import com.liuhe.redpacket.system.MethodAnnotation;
import com.liuhe.redpacket.system.MethodAnnotation.ResourceType;
import com.liuhe.redpacket.utils.result.AjaxResult;

@Controller
@RequestMapping("/systemParam")
public class SystemParamController {
	@Autowired
	ISystemDictionaryService systemDictionaryService;

	// 系统参数主页面
	@MethodAnnotation(name = "主页", type = ResourceType.系统参数)
	@RequestMapping("/index")
	private String index() {
		return "systemDictionary/systemParam";
	}

	// 返回列表数据
	@MethodAnnotation(name = "列表", type = ResourceType.系统参数)
	@ResponseBody
	@RequestMapping("/list")
	private List<SystemDictionary> systemDictionaryList() {
		return systemDictionaryService.getAll();
	}
	
	//删除
	@MethodAnnotation(name = "删除", type = ResourceType.系统参数)
	@ResponseBody
	@RequestMapping("/delete")
	private AjaxResult delete(@RequestParam("id")Long id) {
		AjaxResult ar;
		try {
			if (id != null) {
				systemDictionaryService.delete(id);
				ar = new AjaxResult();
			}else {
				ar = new AjaxResult("删除失败", null);
			}
		} catch (Exception e) {
			ar = new AjaxResult("删除失败", null);
		}
		return ar;
	}
	//保存和更新
	@MethodAnnotation(name = "编辑", type = ResourceType.系统参数)
	@ResponseBody
	@RequestMapping("/save")
	private AjaxResult save(SystemDictionary systemDictionary) {
		AjaxResult ar;
		try {
			//判断是新建还是更新
			if (systemDictionary != null && systemDictionary.getId() != null) {
				systemDictionaryService.update(systemDictionary);
				ar = new AjaxResult("更新成功！");
			}else {
				systemDictionaryService.save(systemDictionary);
				ar = new AjaxResult("保存成功！");
			}
		} catch (Exception e) {
			ar = new AjaxResult("保存失败！", null);
		}
		return ar;
	}
}
