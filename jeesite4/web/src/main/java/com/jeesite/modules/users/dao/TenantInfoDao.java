/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.users.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.users.entity.TenantInfo;

/**
 * tenant_infoDAO接口
 * @author gyf
 * @version 2020-05-07
 */
@MyBatisDao
public interface TenantInfoDao extends CrudDao<TenantInfo> {
	
}