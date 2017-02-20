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

package com.nabook.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nabook.model.Author;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the author service. This utility wraps {@link com.nabook.service.persistence.impl.AuthorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see AuthorPersistence
 * @see com.nabook.service.persistence.impl.AuthorPersistenceImpl
 * @generated
 */
@ProviderType
public class AuthorUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Author author) {
		getPersistence().clearCache(author);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Author update(Author author) {
		return getPersistence().update(author);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Author update(Author author, ServiceContext serviceContext) {
		return getPersistence().update(author, serviceContext);
	}

	/**
	* Returns all the authors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching authors
	*/
	public static List<Author> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the authors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of matching authors
	*/
	public static List<Author> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the authors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Author> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the authors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUuid_First(java.lang.String uuid,
		OrderByComparator<Author> orderByComparator)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Author> orderByComparator)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the authors before and after the current author in the ordered set where uuid = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author[] findByUuid_PrevAndNext(long authorId,
		java.lang.String uuid, OrderByComparator<Author> orderByComparator)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByUuid_PrevAndNext(authorId, uuid, orderByComparator);
	}

	/**
	* Removes all the authors where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of authors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching authors
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUUID_G(java.lang.String uuid, long groupId)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the author where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the author that was removed
	*/
	public static Author removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of authors where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching authors
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the authors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching authors
	*/
	public static List<Author> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the authors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of matching authors
	*/
	public static List<Author> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the authors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the authors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Author> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Author> orderByComparator)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Author> orderByComparator)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the authors before and after the current author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author[] findByUuid_C_PrevAndNext(long authorId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Author> orderByComparator)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(authorId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the authors where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of authors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching authors
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the author in the entity cache if it is enabled.
	*
	* @param author the author
	*/
	public static void cacheResult(Author author) {
		getPersistence().cacheResult(author);
	}

	/**
	* Caches the authors in the entity cache if it is enabled.
	*
	* @param authors the authors
	*/
	public static void cacheResult(List<Author> authors) {
		getPersistence().cacheResult(authors);
	}

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public static Author create(long authorId) {
		return getPersistence().create(authorId);
	}

	/**
	* Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author remove(long authorId)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence().remove(authorId);
	}

	public static Author updateImpl(Author author) {
		return getPersistence().updateImpl(author);
	}

	/**
	* Returns the author with the primary key or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author findByPrimaryKey(long authorId)
		throws com.nabook.exception.NoSuchAuthorException {
		return getPersistence().findByPrimaryKey(authorId);
	}

	/**
	* Returns the author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author, or <code>null</code> if a author with the primary key could not be found
	*/
	public static Author fetchByPrimaryKey(long authorId) {
		return getPersistence().fetchByPrimaryKey(authorId);
	}

	public static java.util.Map<java.io.Serializable, Author> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the authors.
	*
	* @return the authors
	*/
	public static List<Author> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of authors
	*/
	public static List<Author> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of authors
	*/
	public static List<Author> findAll(int start, int end,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of authors
	*/
	public static List<Author> findAll(int start, int end,
		OrderByComparator<Author> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the authors from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of books associated with the author.
	*
	* @param pk the primary key of the author
	* @return long[] of the primaryKeys of books associated with the author
	*/
	public static long[] getBookPrimaryKeys(long pk) {
		return getPersistence().getBookPrimaryKeys(pk);
	}

	/**
	* Returns all the books associated with the author.
	*
	* @param pk the primary key of the author
	* @return the books associated with the author
	*/
	public static List<com.nabook.model.Book> getBooks(long pk) {
		return getPersistence().getBooks(pk);
	}

	/**
	* Returns a range of all the books associated with the author.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the author
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of books associated with the author
	*/
	public static List<com.nabook.model.Book> getBooks(long pk, int start,
		int end) {
		return getPersistence().getBooks(pk, start, end);
	}

	/**
	* Returns an ordered range of all the books associated with the author.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the author
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of books associated with the author
	*/
	public static List<com.nabook.model.Book> getBooks(long pk, int start,
		int end, OrderByComparator<com.nabook.model.Book> orderByComparator) {
		return getPersistence().getBooks(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of books associated with the author.
	*
	* @param pk the primary key of the author
	* @return the number of books associated with the author
	*/
	public static int getBooksSize(long pk) {
		return getPersistence().getBooksSize(pk);
	}

	/**
	* Returns <code>true</code> if the book is associated with the author.
	*
	* @param pk the primary key of the author
	* @param bookPK the primary key of the book
	* @return <code>true</code> if the book is associated with the author; <code>false</code> otherwise
	*/
	public static boolean containsBook(long pk, long bookPK) {
		return getPersistence().containsBook(pk, bookPK);
	}

	/**
	* Returns <code>true</code> if the author has any books associated with it.
	*
	* @param pk the primary key of the author to check for associations with books
	* @return <code>true</code> if the author has any books associated with it; <code>false</code> otherwise
	*/
	public static boolean containsBooks(long pk) {
		return getPersistence().containsBooks(pk);
	}

	/**
	* Adds an association between the author and the book. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPK the primary key of the book
	*/
	public static void addBook(long pk, long bookPK) {
		getPersistence().addBook(pk, bookPK);
	}

	/**
	* Adds an association between the author and the book. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param book the book
	*/
	public static void addBook(long pk, com.nabook.model.Book book) {
		getPersistence().addBook(pk, book);
	}

	/**
	* Adds an association between the author and the books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPKs the primary keys of the books
	*/
	public static void addBooks(long pk, long[] bookPKs) {
		getPersistence().addBooks(pk, bookPKs);
	}

	/**
	* Adds an association between the author and the books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param books the books
	*/
	public static void addBooks(long pk, List<com.nabook.model.Book> books) {
		getPersistence().addBooks(pk, books);
	}

	/**
	* Clears all associations between the author and its books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author to clear the associated books from
	*/
	public static void clearBooks(long pk) {
		getPersistence().clearBooks(pk);
	}

	/**
	* Removes the association between the author and the book. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPK the primary key of the book
	*/
	public static void removeBook(long pk, long bookPK) {
		getPersistence().removeBook(pk, bookPK);
	}

	/**
	* Removes the association between the author and the book. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param book the book
	*/
	public static void removeBook(long pk, com.nabook.model.Book book) {
		getPersistence().removeBook(pk, book);
	}

	/**
	* Removes the association between the author and the books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPKs the primary keys of the books
	*/
	public static void removeBooks(long pk, long[] bookPKs) {
		getPersistence().removeBooks(pk, bookPKs);
	}

	/**
	* Removes the association between the author and the books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param books the books
	*/
	public static void removeBooks(long pk, List<com.nabook.model.Book> books) {
		getPersistence().removeBooks(pk, books);
	}

	/**
	* Sets the books associated with the author, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPKs the primary keys of the books to be associated with the author
	*/
	public static void setBooks(long pk, long[] bookPKs) {
		getPersistence().setBooks(pk, bookPKs);
	}

	/**
	* Sets the books associated with the author, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param books the books to be associated with the author
	*/
	public static void setBooks(long pk, List<com.nabook.model.Book> books) {
		getPersistence().setBooks(pk, books);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AuthorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AuthorPersistence, AuthorPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AuthorPersistence.class);
}