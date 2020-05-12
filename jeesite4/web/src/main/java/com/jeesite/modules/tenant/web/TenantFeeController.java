/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tenant.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.users.service.TenantInfoService;
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
import com.jeesite.modules.tenant.entity.TenantFee;
import com.jeesite.modules.tenant.service.TenantFeeService;

/**
 * tenant_feeController
 * @author gyf
 * @version 2020-05-07
 */
@Controller
@RequestMapping(value = "${adminPath}/tenant/tenantFee")
public class TenantFeeController extends BaseController {

	@Autowired
	private TenantFeeService tenantFeeService;
	@Autowired
	private TenantInfoService tenantInfoService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TenantFee get(String id, boolean isNewRecord) {
		return tenantFeeService.get(id, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("tenant:tenantFee:view")
	@RequestMapping(value = {"list", ""})
	public String list(TenantFee tenantFee, Model model) {
		model.addAttribute("tenantFee", tenantFee);
		return "modules/tenant/tenantFeeList";
	}

	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tenant:tenantFee:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TenantFee> listData(TenantFee tenantFee, HttpServletRequest request, HttpServletResponse response) {
		tenantFee.setPage(new Page<>(request, response));
		Page<TenantFee> page = tenantFeeService.findPage(tenantFee);
		for(TenantFee tenantFee1:page.getList()){
			tenantFee1.setTenantInfo(tenantInfoService.get(tenantFee1.getTenantId()));
		}
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tenant:tenantFee:view")
	@RequestMapping(value = "form")
	public String form(TenantFee tenantFee, Model model) {
		model.addAttribute("tenantFee", tenantFee);
		return "modules/tenant/tenantFeeForm";
	}

	/**
	 * 保存tenant_fee
	 */
	@RequiresPermissions("tenant:tenantFee:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TenantFee tenantFee) {
		tenantFeeService.save(tenantFee);
		return renderResult(Global.TRUE, text("保存tenant_fee成功！"));
	}

	/**
	 * 停用tenant_fee
	 */
	@RequiresPermissions("tenant:tenantFee:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(TenantFee tenantFee) {
		tenantFee.setStatus(TenantFee.STATUS_DISABLE);
		tenantFeeService.updateStatus(tenantFee);
		return renderResult(Global.TRUE, text("停用tenant_fee成功"));
	}

	/**
	 * 启用tenant_fee
	 */
	@RequiresPermissions("tenant:tenantFee:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(TenantFee tenantFee) {
		tenantFee.setStatus(TenantFee.STATUS_NORMAL);
		tenantFeeService.updateStatus(tenantFee);
		return renderResult(Global.TRUE, text("启用tenant_fee成功"));
	}

	/**
	 * 删除tenant_fee
	 */
	@RequiresPermissions("tenant:tenantFee:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TenantFee tenantFee) {
		tenantFeeService.delete(tenantFee);
		return renderResult(Global.TRUE, text("删除tenant_fee成功！"));
	}

}
