/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.users.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * tenant_infoEntity
 * @author gyf
 * @version 2020-05-07
 */
@Table(name="tenant_info", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="tenant_name", attrName="tenantName", label="租户姓名", queryType=QueryType.LIKE),
		@Column(name="month_quota", attrName="monthQuota", label="月定额", isQuery=false),
		@Column(name="second_name", attrName="secondName", label="第二个名称", isQuery=false),
		@Column(name="tenant_no", attrName="tenantNo", label="编号", isQuery=false),
		@Column(name="industry", attrName="industry", label="行业", isQuery=false),
		@Column(name="industy_category", attrName="industyCategory", label="行业类别"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class TenantInfo extends DataEntity<TenantInfo> {
	
	private static final long serialVersionUID = 1L;
	private String tenantName;		// 租户姓名
	private String monthQuota;		// 月定额
	private String secondName;		// 第二个名称
	private String tenantNo;		// 编号
	private String industry;		// 行业
	private String industyCategory;		// 行业类别
	
	public TenantInfo() {
		this(null);
	}

	public TenantInfo(String id){
		super(id);
	}
	
	@NotBlank(message="租户姓名不能为空")
	@Length(min=0, max=8, message="租户姓名长度不能超过 8 个字符")
	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	@Length(min=0, max=8, message="月定额长度不能超过 8 个字符")
	public String getMonthQuota() {
		return monthQuota;
	}

	public void setMonthQuota(String monthQuota) {
		this.monthQuota = monthQuota;
	}
	
	@Length(min=0, max=8, message="第二个名称长度不能超过 8 个字符")
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	@NotBlank(message="编号不能为空")
	@Length(min=0, max=32, message="编号长度不能超过 32 个字符")
	public String getTenantNo() {
		return tenantNo;
	}

	public void setTenantNo(String tenantNo) {
		this.tenantNo = tenantNo;
	}
	
	@Length(min=0, max=8, message="行业长度不能超过 8 个字符")
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	@NotBlank(message="行业类别不能为空")
	@Length(min=0, max=2, message="行业类别长度不能超过 2 个字符")
	public String getIndustyCategory() {
		return industyCategory;
	}

	public void setIndustyCategory(String industyCategory) {
		this.industyCategory = industyCategory;
	}
	
}