/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.nabook.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.nabook.model.OrderItem;
import com.nabook.model.OrderItemModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OrderItem service. Represents a row in the &quot;nab_OrderItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link OrderItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrderItemImpl}.
 * </p>
 *
 * @author phantoan
 * @see OrderItemImpl
 * @see OrderItem
 * @see OrderItemModel
 * @generated
 */
@ProviderType
public class OrderItemModelImpl extends BaseModelImpl<OrderItem>
	implements OrderItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a order item model instance should use the {@link OrderItem} interface instead.
	 */
	public static final String TABLE_NAME = "nab_OrderItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "orderItemId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "bookOrderId", Types.BIGINT },
			{ "bookId", Types.BIGINT },
			{ "price", Types.VARCHAR },
			{ "quantity", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("orderItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookOrderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("bookId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("price", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table nab_OrderItem (uuid_ VARCHAR(75) null,orderItemId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,userId LONG,userName VARCHAR(75) null,bookOrderId LONG,bookId LONG,price VARCHAR(12) null,quantity INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table nab_OrderItem";
	public static final String ORDER_BY_JPQL = " ORDER BY orderItem.orderItemId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY nab_OrderItem.orderItemId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.nabook.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.nabook.model.OrderItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.nabook.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.nabook.model.OrderItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.nabook.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.nabook.model.OrderItem"),
			true);
	public static final long BOOKID_COLUMN_BITMASK = 1L;
	public static final long BOOKORDERID_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long USERID_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long ORDERITEMID_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.nabook.service.util.ServiceProps.get(
				"lock.expiration.time.com.nabook.model.OrderItem"));

	public OrderItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _orderItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrderItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orderItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OrderItem.class;
	}

	@Override
	public String getModelClassName() {
		return OrderItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("orderItemId", getOrderItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("bookOrderId", getBookOrderId());
		attributes.put("bookId", getBookId());
		attributes.put("price", getPrice());
		attributes.put("quantity", getQuantity());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long orderItemId = (Long)attributes.get("orderItemId");

		if (orderItemId != null) {
			setOrderItemId(orderItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long bookOrderId = (Long)attributes.get("bookOrderId");

		if (bookOrderId != null) {
			setBookOrderId(bookOrderId);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getOrderItemId() {
		return _orderItemId;
	}

	@Override
	public void setOrderItemId(long orderItemId) {
		_orderItemId = orderItemId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public long getBookOrderId() {
		return _bookOrderId;
	}

	@Override
	public void setBookOrderId(long bookOrderId) {
		_columnBitmask |= BOOKORDERID_COLUMN_BITMASK;

		if (!_setOriginalBookOrderId) {
			_setOriginalBookOrderId = true;

			_originalBookOrderId = _bookOrderId;
		}

		_bookOrderId = bookOrderId;
	}

	public long getOriginalBookOrderId() {
		return _originalBookOrderId;
	}

	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		_columnBitmask |= BOOKID_COLUMN_BITMASK;

		if (!_setOriginalBookId) {
			_setOriginalBookId = true;

			_originalBookId = _bookId;
		}

		_bookId = bookId;
	}

	public long getOriginalBookId() {
		return _originalBookId;
	}

	@Override
	public String getPrice() {
		if (_price == null) {
			return StringPool.BLANK;
		}
		else {
			return _price;
		}
	}

	@Override
	public void setPrice(String price) {
		_price = price;
	}

	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				OrderItem.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			OrderItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OrderItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OrderItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OrderItemImpl orderItemImpl = new OrderItemImpl();

		orderItemImpl.setUuid(getUuid());
		orderItemImpl.setOrderItemId(getOrderItemId());
		orderItemImpl.setGroupId(getGroupId());
		orderItemImpl.setCompanyId(getCompanyId());
		orderItemImpl.setCreateDate(getCreateDate());
		orderItemImpl.setModifiedDate(getModifiedDate());
		orderItemImpl.setUserId(getUserId());
		orderItemImpl.setUserName(getUserName());
		orderItemImpl.setBookOrderId(getBookOrderId());
		orderItemImpl.setBookId(getBookId());
		orderItemImpl.setPrice(getPrice());
		orderItemImpl.setQuantity(getQuantity());

		orderItemImpl.resetOriginalValues();

		return orderItemImpl;
	}

	@Override
	public int compareTo(OrderItem orderItem) {
		long primaryKey = orderItem.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrderItem)) {
			return false;
		}

		OrderItem orderItem = (OrderItem)obj;

		long primaryKey = orderItem.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		OrderItemModelImpl orderItemModelImpl = this;

		orderItemModelImpl._originalUuid = orderItemModelImpl._uuid;

		orderItemModelImpl._originalGroupId = orderItemModelImpl._groupId;

		orderItemModelImpl._setOriginalGroupId = false;

		orderItemModelImpl._originalCompanyId = orderItemModelImpl._companyId;

		orderItemModelImpl._setOriginalCompanyId = false;

		orderItemModelImpl._setModifiedDate = false;

		orderItemModelImpl._originalUserId = orderItemModelImpl._userId;

		orderItemModelImpl._setOriginalUserId = false;

		orderItemModelImpl._originalBookOrderId = orderItemModelImpl._bookOrderId;

		orderItemModelImpl._setOriginalBookOrderId = false;

		orderItemModelImpl._originalBookId = orderItemModelImpl._bookId;

		orderItemModelImpl._setOriginalBookId = false;

		orderItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OrderItem> toCacheModel() {
		OrderItemCacheModel orderItemCacheModel = new OrderItemCacheModel();

		orderItemCacheModel.uuid = getUuid();

		String uuid = orderItemCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			orderItemCacheModel.uuid = null;
		}

		orderItemCacheModel.orderItemId = getOrderItemId();

		orderItemCacheModel.groupId = getGroupId();

		orderItemCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			orderItemCacheModel.createDate = createDate.getTime();
		}
		else {
			orderItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			orderItemCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			orderItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		orderItemCacheModel.userId = getUserId();

		orderItemCacheModel.userName = getUserName();

		String userName = orderItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			orderItemCacheModel.userName = null;
		}

		orderItemCacheModel.bookOrderId = getBookOrderId();

		orderItemCacheModel.bookId = getBookId();

		orderItemCacheModel.price = getPrice();

		String price = orderItemCacheModel.price;

		if ((price != null) && (price.length() == 0)) {
			orderItemCacheModel.price = null;
		}

		orderItemCacheModel.quantity = getQuantity();

		return orderItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", orderItemId=");
		sb.append(getOrderItemId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", bookOrderId=");
		sb.append(getBookOrderId());
		sb.append(", bookId=");
		sb.append(getBookId());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.nabook.model.OrderItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderItemId</column-name><column-value><![CDATA[");
		sb.append(getOrderItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookOrderId</column-name><column-value><![CDATA[");
		sb.append(getBookOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = OrderItem.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			OrderItem.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _orderItemId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private long _bookOrderId;
	private long _originalBookOrderId;
	private boolean _setOriginalBookOrderId;
	private long _bookId;
	private long _originalBookId;
	private boolean _setOriginalBookId;
	private String _price;
	private int _quantity;
	private long _columnBitmask;
	private OrderItem _escapedModel;
}