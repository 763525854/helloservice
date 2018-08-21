/**
 *  Created by weiping.gong on 2018年8月21日
 */
package helloservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import helloservice.util.ExcelUtil;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年8月21日
 */
@RestController
@RequestMapping("/report")
public class ExcelController {
	/**
	 * 导出报表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/export")
	@ResponseBody
	public void export(HttpServletRequest request, HttpServletResponse response) {
		// 获取数据
		List<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String,String> map1 = new HashMap<>();
		HashMap<String,String> map2 = new HashMap<>();
		map1.put("name", "张三");
		map2.put("name", "李四");
		list.add(map1);
		list.add(map2);
		
		// excel标题
		String[] title = { "名称" };
		// excel文件名
		String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";
		// sheet名
		String sheetName = "学生信息表";
		String[][] values = new String[2][];
		for (int i = 0; i < list.size(); i++) {
			values[i] = new String[title.length];
			HashMap<String, String> map = list.get(i);
			values[i][0] = map.get("name");
		}
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.exportExcel(fileName, sheetName, title, values, null, response);
	}

}
