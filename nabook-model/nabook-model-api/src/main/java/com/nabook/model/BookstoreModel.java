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

package com.nabook.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Bookstore service. Represents a row in the &quot;nab_Bookstore&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.nabook.model.impl.BookstoreModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.nabook.model.impl.BookstoreImpl}.
 * </p>
 *
 * @author phantoan
 * @see Bookstore
 * @see com.nabook.model.impl.BookstoreImpl
 * @see com.nabook.model.impl.BookstoreModelImpl
 * @generated
 */
@ProviderType
public interface BookstoreModel extends BaseModel<Bookstore>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bookstore model instance should use the {@link Bookstore} interface instead.
	 */

	/**
	 * Returns the primary key of this bookstore.
	 *
	 * @return the primary key of this bookstore
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bookstore.
	 *
	 * @param primaryKey the primary key of this bookstore
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this bookstore.
	 *
	 * @return the uuid of this bookstore
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this bookstore.
	 *
	 * @param uuid the uuid of this bookstore
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the bookstore ID of this bookstore.
	 *
	 * @return the bookstore ID of this bookstore
	 */
	public long getBookstoreId();

	/**
	 * Sets the bookstore ID of this bookstore.
	 *
	 * @param bookstoreId the bookstore ID of this bookstore
	 */
	public void setBookstoreId(long bookstoreId);

	/**
	 * Returns the group ID of this bookstore.
	 *
	 * @return the group ID of this bookstore
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this bookstore.
	 *
	 * @param groupId the group ID of this bookstore
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this bookstore.
	 *
	 * @return the company ID of this bookstore
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this bookstore.
	 *
	 * @param companyId the company ID of this bookstore
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this bookstore.
	 *
	 * @return the create date of this bookstore
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this bookstore.
	 *
	 * @param createDate the create date of this bookstore
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this bookstore.
	 *
	 * @return the modified date of this bookstore
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this bookstore.
	 *
	 * @param modifiedDate the modified date of this bookstore
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this bookstore.
	 *
	 * @return the user ID of this bookstore
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this bookstore.
	 *
	 * @param userId the user ID of this bookstore
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this bookstore.
	 *
	 * @return the user uuid of this bookstore
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this bookstore.
	 *
	 * @param userUuid the user uuid of this bookstore
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this bookstore.
	 *
	 * @return the user name of this bookstore
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this bookstore.
	 *
	 * @param userName the user name of this bookstore
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the name of this bookstore.
	 *
	 * @return the name of this bookstore
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this bookstore.
	 *
	 * @param name the name of this bookstore
	 */
	public void setName(String name);

	/**
	 * Returns the country of this bookstore.
	 *
	 * @return the country of this bookstore
	 */
	@AutoEscape
	public String getCountry();

	/**
	 * Sets the country of this bookstore.
	 *
	 * @param country the country of this bookstore
	 */
	public void setCountry(String country);

	/**
	 * Returns the city of this bookstore.
	 *
	 * @return the city of this bookstore
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this bookstore.
	 *
	 * @param city the city of this bookstore
	 */
	public void setCity(String city);

	/**
	 * Returns the prefecture of this bookstore.
	 *
	 * @return the prefecture of this bookstore
	 */
	@AutoEscape
	public String getPrefecture();

	/**
	 * Sets the prefecture of this bookstore.
	 *
	 * @param prefecture the prefecture of this bookstore
	 */
	public void setPrefecture(String prefecture);

	/**
	 * Returns the street of this bookstore.
	 *
	 * @return the street of this bookstore
	 */
	@AutoEscape
	public String getStreet();

	/**
	 * Sets the street of this bookstore.
	 *
	 * @param street the street of this bookstore
	 */
	public void setStreet(String street);

	/**
	 * Returns the zip of this bookstore.
	 *
	 * @return the zip of this bookstore
	 */
	@AutoEscape
	public String getZip();

	/**
	 * Sets the zip of this bookstore.
	 *
	 * @param zip the zip of this bookstore
	 */
	public void setZip(String zip);

	/**
	 * Returns the phone of this bookstore.
	 *
	 * @return the phone of this bookstore
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this bookstore.
	 *
	 * @param phone the phone of this bookstore
	 */
	public void setPhone(String phone);

	/**
	 * Returns the description of this bookstore.
	 *
	 * @return the description of this bookstore
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this bookstore.
	 *
	 * @param description the description of this bookstore
	 */
	public void setDescription(String description);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Bookstore bookstore);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Bookstore> toCacheModel();

	@Override
	public Bookstore toEscapedModel();

	@Override
	public Bookstore toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}