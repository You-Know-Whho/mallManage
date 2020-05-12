/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tenant.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tenant.entity.TenantFee;

/**
 * tenant_feeDAO接口
 * @author gyf
 * @version 2020-05-07
 */
@MyBatisDao
public interface TenantFeeDao extends CrudDao<TenantFee> {
	
}