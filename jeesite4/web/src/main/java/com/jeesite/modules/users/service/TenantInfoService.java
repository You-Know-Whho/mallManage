/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.users.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.users.entity.TenantInfo;
import com.jeesite.modules.users.dao.TenantInfoDao;

/**
 * tenant_infoService
 * @author gyf
 * @version 2020-05-07
 */
@Service
@Transactional(readOnly=true)
public class TenantInfoService extends CrudService<TenantInfoDao, TenantInfo> {
	
	/**
	 * 获取单条数据
	 * @param tenantInfo
	 * @return
	 */
	@Override
	public TenantInfo get(TenantInfo tenantInfo) {
		return super.get(tenantInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param tenantInfo 查询条件
	 * @param tenantInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<TenantInfo> findPage(TenantInfo tenantInfo) {
		return super.findPage(tenantInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tenantInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TenantInfo tenantInfo) {
		super.save(tenantInfo);
	}
	
	/**
	 * 更新状态
	 * @param tenantInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TenantInfo tenantInfo) {
		super.updateStatus(tenantInfo);
	}
	
	/**
	 * 删除数据
	 * @param tenantInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TenantInfo tenantInfo) {
		super.delete(tenantInfo);
	}
	
}