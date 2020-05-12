/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tenant.entity;

import javax.validation.constraints.NotBlank;

import com.jeesite.modules.users.entity.TenantInfo;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * tenant_feeEntity
 * @author gyf
 * @version 2020-05-07
 */
@Table(name="tenant_fee", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="tenant_id", attrName="tenantId", label="租户编号"),
		@Column(name="month", attrName="month", label="费用月份"),
		@Column(name="money", attrName="money", label="金额", isQuery=false),
		@Column(name="tax", attrName="tax", label="税金", isQuery=false),
		@Column(name="receipt_date", attrName="receiptDate", label="收款日期", isQuery=false),
		@Column(name="ticket_number", attrName="ticketNumber", label="票据号码", isQuery=false),
		@Column(name="fee_category", attrName="feeCategory", label="费用类别"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class TenantFee extends DataEntity<TenantFee> {

	private static final long serialVersionUID = 1L;
	private String tenantId;		// 租户编号
	private String month;		// 费用月份
	private Double money;		// 金额
	private Double tax;		// 税金
	private Date receiptDate;		// 收款日期
	private String ticketNumber;		// 票据号码
	private String feeCategory;		// 费用类别
	private TenantInfo tenantInfo;

	public TenantFee() {
		this(null);
	}

	public TenantFee(String id){
		super(id);
	}

	@NotBlank(message="租户编号不能为空")
	@Length(min=0, max=64, message="租户编号长度不能超过 64 个字符")
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@NotBlank(message="费用月份不能为空")
	@Length(min=0, max=8, message="费用月份长度不能超过 8 个字符")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@NotNull(message="金额不能为空")
	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	@Length(min=0, max=64, message="票据号码长度不能超过 64 个字符")
	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	@NotBlank(message="费用类别不能为空")
	@Length(min=0, max=2, message="费用类别长度不能超过 2 个字符")
	public String getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(String feeCategory) {
		this.feeCategory = feeCategory;
	}



	/**
	 * 获取
	 *
	 * @return tenantInfo
	 */
	public TenantInfo getTenantInfo() {
		return this.tenantInfo;
	}

	/**
	 * 设置
	 *
	 * @param tenantInfo
	 */
	public void setTenantInfo(TenantInfo tenantInfo) {
		this.tenantInfo = tenantInfo;
	}
}
