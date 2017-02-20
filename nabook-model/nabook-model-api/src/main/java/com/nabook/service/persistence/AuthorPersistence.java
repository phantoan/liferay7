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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.nabook.exception.NoSuchAuthorException;

import com.nabook.model.Author;

/**
 * The persistence interface for the author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see com.nabook.service.persistence.impl.AuthorPersistenceImpl
 * @see AuthorUtil
 * @generated
 */
@ProviderType
public interface AuthorPersistence extends BasePersistence<Author> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorUtil} to access the author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the authors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching authors
	*/
	public java.util.List<Author> findByUuid(java.lang.String uuid);

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
	public java.util.List<Author> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Author> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public java.util.List<Author> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the first author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the last author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the last author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the authors before and after the current author in the ordered set where uuid = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public Author[] findByUuid_PrevAndNext(long authorId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Removes all the authors where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of authors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching authors
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchAuthorException;

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the author where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the author that was removed
	*/
	public Author removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchAuthorException;

	/**
	* Returns the number of authors where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching authors
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the authors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching authors
	*/
	public java.util.List<Author> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Author> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Author> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public java.util.List<Author> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public Author[] findByUuid_C_PrevAndNext(long authorId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Removes all the authors where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of authors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching authors
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the author in the entity cache if it is enabled.
	*
	* @param author the author
	*/
	public void cacheResult(Author author);

	/**
	* Caches the authors in the entity cache if it is enabled.
	*
	* @param authors the authors
	*/
	public void cacheResult(java.util.List<Author> authors);

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public Author create(long authorId);

	/**
	* Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public Author remove(long authorId) throws NoSuchAuthorException;

	public Author updateImpl(Author author);

	/**
	* Returns the author with the primary key or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public Author findByPrimaryKey(long authorId) throws NoSuchAuthorException;

	/**
	* Returns the author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author, or <code>null</code> if a author with the primary key could not be found
	*/
	public Author fetchByPrimaryKey(long authorId);

	@Override
	public java.util.Map<java.io.Serializable, Author> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the authors.
	*
	* @return the authors
	*/
	public java.util.List<Author> findAll();

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
	public java.util.List<Author> findAll(int start, int end);

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
	public java.util.List<Author> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public java.util.List<Author> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the authors from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of books associated with the author.
	*
	* @param pk the primary key of the author
	* @return long[] of the primaryKeys of books associated with the author
	*/
	public long[] getBookPrimaryKeys(long pk);

	/**
	* Returns all the books associated with the author.
	*
	* @param pk the primary key of the author
	* @return the books associated with the author
	*/
	public java.util.List<com.nabook.model.Book> getBooks(long pk);

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
	public java.util.List<com.nabook.model.Book> getBooks(long pk, int start,
		int end);

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
	public java.util.List<com.nabook.model.Book> getBooks(long pk, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nabook.model.Book> orderByComparator);

	/**
	* Returns the number of books associated with the author.
	*
	* @param pk the primary key of the author
	* @return the number of books associated with the author
	*/
	public int getBooksSize(long pk);

	/**
	* Returns <code>true</code> if the book is associated with the author.
	*
	* @param pk the primary key of the author
	* @param bookPK the primary key of the book
	* @return <code>true</code> if the book is associated with the author; <code>false</code> otherwise
	*/
	public boolean containsBook(long pk, long bookPK);

	/**
	* Returns <code>true</code> if the author has any books associated with it.
	*
	* @param pk the primary key of the author to check for associations with books
	* @return <code>true</code> if the author has any books associated with it; <code>false</code> otherwise
	*/
	public boolean containsBooks(long pk);

	/**
	* Adds an association between the author and the book. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPK the primary key of the book
	*/
	public void addBook(long pk, long bookPK);

	/**
	* Adds an association between the author and the book. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param book the book
	*/
	public void addBook(long pk, com.nabook.model.Book book);

	/**
	* Adds an association between the author and the books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPKs the primary keys of the books
	*/
	public void addBooks(long pk, long[] bookPKs);

	/**
	* Adds an association between the author and the books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param books the books
	*/
	public void addBooks(long pk, java.util.List<com.nabook.model.Book> books);

	/**
	* Clears all associations between the author and its books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author to clear the associated books from
	*/
	public void clearBooks(long pk);

	/**
	* Removes the association between the author and the book. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPK the primary key of the book
	*/
	public void removeBook(long pk, long bookPK);

	/**
	* Removes the association between the author and the book. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param book the book
	*/
	public void removeBook(long pk, com.nabook.model.Book book);

	/**
	* Removes the association between the author and the books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPKs the primary keys of the books
	*/
	public void removeBooks(long pk, long[] bookPKs);

	/**
	* Removes the association between the author and the books. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param books the books
	*/
	public void removeBooks(long pk, java.util.List<com.nabook.model.Book> books);

	/**
	* Sets the books associated with the author, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param bookPKs the primary keys of the books to be associated with the author
	*/
	public void setBooks(long pk, long[] bookPKs);

	/**
	* Sets the books associated with the author, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the author
	* @param books the books to be associated with the author
	*/
	public void setBooks(long pk, java.util.List<com.nabook.model.Book> books);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}