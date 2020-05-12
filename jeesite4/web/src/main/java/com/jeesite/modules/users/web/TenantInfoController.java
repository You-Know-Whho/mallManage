/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.users.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.entity.DictData;
import com.jeesite.modules.sys.service.DictDataService;
import com.jeesite.modules.sys.utils.DictUtils;
import com.jeesite.modules.test.entity.TestTree;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.users.entity.TenantInfo;
import com.jeesite.modules.users.service.TenantInfoService;

import java.util.List;
import java.util.Map;

/**
 * tenant_infoController
 * @author gyf
 * @version 2020-05-07
 */
@Controller
@RequestMapping(value = "${adminPath}/users/tenantInfo")
public class TenantInfoController extends BaseController {

	@Autowired
	private TenantInfoService tenantInfoService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TenantInfo get(String id, boolean isNewRecord) {
		return tenantInfoService.get(id, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("users:tenantInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(TenantInfo tenantInfo, Model model) {
		model.addAttribute("tenantInfo", tenantInfo);
		return "modules/users/tenantInfoList";
	}

	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("users:tenantInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TenantInfo> listData(TenantInfo tenantInfo, HttpServletRequest request, HttpServletResponse response) {
		tenantInfo.setPage(new Page<>(request, response));
		Page<TenantInfo> page = tenantInfoService.findPage(tenantInfo);
		return page;
	}

	/**
	 * 获取各行业下人员的数据
	 */
	@RequiresPermissions("users:tenantInfo:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData() {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		List<TenantInfo> list = tenantInfoService.findList(new TenantInfo());
		List<DictData> dictDataList= DictUtils.getDictList("industy_category");
		for(DictData dictData:dictDataList){
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", "industry"+dictData.getDictValue());
			map.put("pId","industryCategory");
			map.put("name", dictData.getDictLabel());
			mapList.add(map);
		}
		for (TenantInfo tenantInfo : list) {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", tenantInfo.getId());
			map.put("pId", "industry"+tenantInfo.getIndustyCategory());
			map.put("name", tenantInfo.getTenantName());
			mapList.add(map);
		}
		//增加总父类
		Map<String, Object> newmap = MapUtils.newHashMap();
		newmap.put("id","industryCategory");
		newmap.put("pId",0);
		newmap.put("name", "行业类别");
		newmap.put("isParent", "true");
		mapList.add(newmap);
		return mapList;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("users:tenantInfo:view")
	@RequestMapping(value = "form")
	public String form(TenantInfo tenantInfo, Model model) {
		model.addAttribute("tenantInfo", tenantInfo);
		return "modules/users/tenantInfoForm";
	}

	/**
	 * 保存tenant_info
	 */
	@RequiresPermissions("users:tenantInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TenantInfo tenantInfo) {
		tenantInfoService.save(tenantInfo);
		return renderResult(Global.TRUE, text("保存tenant_info成功！"));
	}

	/**
	 * 删除tenant_info
	 */
	@RequiresPermissions("users:tenantInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TenantInfo tenantInfo) {
		tenantInfoService.delete(tenantInfo);
		return renderResult(Global.TRUE, text("删除tenant_info成功！"));
	}

}
