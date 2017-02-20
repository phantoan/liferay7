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

import com.nabook.model.StockItem;
import com.nabook.model.StockItemModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the StockItem service. Represents a row in the &quot;nab_StockItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link StockItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StockItemImpl}.
 * </p>
 *
 * @author phantoan
 * @see StockItemImpl
 * @see StockItem
 * @see StockItemModel
 * @generated
 */
@ProviderType
public class StockItemModelImpl extends BaseModelImpl<StockItem>
	implements StockItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a stock item model instance should use the {@link StockItem} interface instead.
	 */
	public static final String TABLE_NAME = "nab_StockItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "stockItemId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "bookId", Types.BIGINT },
			{ "remainingQuantity", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stockItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("bookId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("remainingQuantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table nab_StockItem (uuid_ VARCHAR(75) null,stockItemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,bookId LONG,remainingQuantity INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table nab_StockItem";
	public static final String ORDER_BY_JPQL = " ORDER BY stockItem.stockItemId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY nab_StockItem.stockItemId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.nabook.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.nabook.model.StockItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.nabook.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.nabook.model.StockItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.nabook.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.nabook.model.StockItem"),
			true);
	public static final long BOOKID_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long STOCKITEMID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.nabook.service.util.ServiceProps.get(
				"lock.expiration.time.com.nabook.model.StockItem"));

	public StockItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _stockItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStockItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stockItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StockItem.class;
	}

	@Override
	public String getModelClassName() {
		return StockItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stockItemId", getStockItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bookId", getBookId());
		attributes.put("remainingQuantity", getRemainingQuantity());

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

		Long stockItemId = (Long)attributes.get("stockItemId");

		if (stockItemId != null) {
			setStockItemId(stockItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Integer remainingQuantity = (Integer)attributes.get("remainingQuantity");

		if (remainingQuantity != null) {
			setRemainingQuantity(remainingQuantity);
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
	public long getStockItemId() {
		return _stockItemId;
	}

	@Override
	public void setStockItemId(long stockItemId) {
		_stockItemId = stockItemId;
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
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
	public int getRemainingQuantity() {
		return _remainingQuantity;
	}

	@Override
	public void setRemainingQuantity(int remainingQuantity) {
		_remainingQuantity = remainingQuantity;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				StockItem.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			StockItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StockItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StockItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StockItemImpl stockItemImpl = new StockItemImpl();

		stockItemImpl.setUuid(getUuid());
		stockItemImpl.setStockItemId(getStockItemId());
		stockItemImpl.setGroupId(getGroupId());
		stockItemImpl.setCompanyId(getCompanyId());
		stockItemImpl.setUserId(getUserId());
		stockItemImpl.setUserName(getUserName());
		stockItemImpl.setCreateDate(getCreateDate());
		stockItemImpl.setModifiedDate(getModifiedDate());
		stockItemImpl.setBookId(getBookId());
		stockItemImpl.setRemainingQuantity(getRemainingQuantity());

		stockItemImpl.resetOriginalValues();

		return stockItemImpl;
	}

	@Override
	public int compareTo(StockItem stockItem) {
		long primaryKey = stockItem.getPrimaryKey();

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

		if (!(obj instanceof StockItem)) {
			return false;
		}

		StockItem stockItem = (StockItem)obj;

		long primaryKey = stockItem.getPrimaryKey();

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
		StockItemModelImpl stockItemModelImpl = this;

		stockItemModelImpl._originalUuid = stockItemModelImpl._uuid;

		stockItemModelImpl._originalGroupId = stockItemModelImpl._groupId;

		stockItemModelImpl._setOriginalGroupId = false;

		stockItemModelImpl._originalCompanyId = stockItemModelImpl._companyId;

		stockItemModelImpl._setOriginalCompanyId = false;

		stockItemModelImpl._setModifiedDate = false;

		stockItemModelImpl._originalBookId = stockItemModelImpl._bookId;

		stockItemModelImpl._setOriginalBookId = false;

		stockItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StockItem> toCacheModel() {
		StockItemCacheModel stockItemCacheModel = new StockItemCacheModel();

		stockItemCacheModel.uuid = getUuid();

		String uuid = stockItemCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			stockItemCacheModel.uuid = null;
		}

		stockItemCacheModel.stockItemId = getStockItemId();

		stockItemCacheModel.groupId = getGroupId();

		stockItemCacheModel.companyId = getCompanyId();

		stockItemCacheModel.userId = getUserId();

		stockItemCacheModel.userName = getUserName();

		String userName = stockItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			stockItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			stockItemCacheModel.createDate = createDate.getTime();
		}
		else {
			stockItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			stockItemCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			stockItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		stockItemCacheModel.bookId = getBookId();

		stockItemCacheModel.remainingQuantity = getRemainingQuantity();

		return stockItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", stockItemId=");
		sb.append(getStockItemId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", bookId=");
		sb.append(getBookId());
		sb.append(", remainingQuantity=");
		sb.append(getRemainingQuantity());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.nabook.model.StockItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stockItemId</column-name><column-value><![CDATA[");
		sb.append(getStockItemId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remainingQuantity</column-name><column-value><![CDATA[");
		sb.append(getRemainingQuantity());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = StockItem.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			StockItem.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _stockItemId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _bookId;
	private long _originalBookId;
	private boolean _setOriginalBookId;
	private int _remainingQuantity;
	private long _columnBitmask;
	private StockItem _escapedModel;
}