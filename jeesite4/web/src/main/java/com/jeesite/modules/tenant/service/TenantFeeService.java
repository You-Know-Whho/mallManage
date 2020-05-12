/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tenant.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tenant.entity.TenantFee;
import com.jeesite.modules.tenant.dao.TenantFeeDao;

/**
 * tenant_feeService
 * @author gyf
 * @version 2020-05-07
 */
@Service
@Transactional(readOnly=true)
public class TenantFeeService extends CrudService<TenantFeeDao, TenantFee> {
	
	/**
	 * 获取单条数据
	 * @param tenantFee
	 * @return
	 */
	@Override
	public TenantFee get(TenantFee tenantFee) {
		return super.get(tenantFee);
	}
	
	/**
	 * 查询分页数据
	 * @param tenantFee 查询条件
	 * @param tenantFee.page 分页对象
	 * @return
	 */
	@Override
	public Page<TenantFee> findPage(TenantFee tenantFee) {
		return super.findPage(tenantFee);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tenantFee
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TenantFee tenantFee) {
		super.save(tenantFee);
	}
	
	/**
	 * 更新状态
	 * @param tenantFee
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TenantFee tenantFee) {
		super.updateStatus(tenantFee);
	}
	
	/**
	 * 删除数据
	 * @param tenantFee
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TenantFee tenantFee) {
		super.delete(tenantFee);
	}
	
}