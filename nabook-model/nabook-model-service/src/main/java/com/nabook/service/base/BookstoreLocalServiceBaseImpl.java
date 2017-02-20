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

package com.nabook.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.ratings.kernel.service.persistence.RatingsStatsPersistence;

import com.nabook.model.Bookstore;

import com.nabook.service.BookstoreLocalService;
import com.nabook.service.persistence.AddressPersistence;
import com.nabook.service.persistence.AuthorPersistence;
import com.nabook.service.persistence.BookOrderPersistence;
import com.nabook.service.persistence.BookPersistence;
import com.nabook.service.persistence.BookstorePersistence;
import com.nabook.service.persistence.CartPersistence;
import com.nabook.service.persistence.OrderItemPersistence;
import com.nabook.service.persistence.StockItemPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the bookstore local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.nabook.service.impl.BookstoreLocalServiceImpl}.
 * </p>
 *
 * @author phantoan
 * @see com.nabook.service.impl.BookstoreLocalServiceImpl
 * @see com.nabook.service.BookstoreLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class BookstoreLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements BookstoreLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.nabook.service.BookstoreLocalServiceUtil} to access the bookstore local service.
	 */

	/**
	 * Adds the bookstore to the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookstore the bookstore
	 * @return the bookstore that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Bookstore addBookstore(Bookstore bookstore) {
		bookstore.setNew(true);

		return bookstorePersistence.update(bookstore);
	}

	/**
	 * Creates a new bookstore with the primary key. Does not add the bookstore to the database.
	 *
	 * @param bookstoreId the primary key for the new bookstore
	 * @return the new bookstore
	 */
	@Override
	public Bookstore createBookstore(long bookstoreId) {
		return bookstorePersistence.create(bookstoreId);
	}

	/**
	 * Deletes the bookstore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookstoreId the primary key of the bookstore
	 * @return the bookstore that was removed
	 * @throws PortalException if a bookstore with the primary key could not be found
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Bookstore deleteBookstore(long bookstoreId)
		throws PortalException, SystemException {
		return bookstorePersistence.remove(bookstoreId);
	}

	/**
	 * Deletes the bookstore from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookstore the bookstore
	 * @return the bookstore that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Bookstore deleteBookstore(Bookstore bookstore) {
		return bookstorePersistence.remove(bookstore);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Bookstore.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return bookstorePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nabook.model.impl.BookstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return bookstorePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nabook.model.impl.BookstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return bookstorePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return bookstorePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return bookstorePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Bookstore fetchBookstore(long bookstoreId) {
		return bookstorePersistence.fetchByPrimaryKey(bookstoreId);
	}

	/**
	 * Returns the bookstore matching the UUID and group.
	 *
	 * @param uuid the bookstore's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bookstore, or <code>null</code> if a matching bookstore could not be found
	 */
	@Override
	public Bookstore fetchBookstoreByUuidAndGroupId(String uuid, long groupId) {
		return bookstorePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the bookstore with the primary key.
	 *
	 * @param bookstoreId the primary key of the bookstore
	 * @return the bookstore
	 * @throws PortalException if a bookstore with the primary key could not be found
	 */
	@Override
	public Bookstore getBookstore(long bookstoreId) throws PortalException {
		return bookstorePersistence.findByPrimaryKey(bookstoreId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(bookstoreLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Bookstore.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("bookstoreId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(bookstoreLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Bookstore.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("bookstoreId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(bookstoreLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Bookstore.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("bookstoreId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Bookstore>() {
				@Override
				public void performAction(Bookstore bookstore)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						bookstore);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(Bookstore.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return bookstoreLocalService.deleteBookstore((Bookstore)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return bookstorePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the bookstores matching the UUID and company.
	 *
	 * @param uuid the UUID of the bookstores
	 * @param companyId the primary key of the company
	 * @return the matching bookstores, or an empty list if no matches were found
	 */
	@Override
	public List<Bookstore> getBookstoresByUuidAndCompanyId(String uuid,
		long companyId) {
		return bookstorePersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of bookstores matching the UUID and company.
	 *
	 * @param uuid the UUID of the bookstores
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of bookstores
	 * @param end the upper bound of the range of bookstores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching bookstores, or an empty list if no matches were found
	 */
	@Override
	public List<Bookstore> getBookstoresByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<Bookstore> orderByComparator) {
		return bookstorePersistence.findByUuid_C(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the bookstore matching the UUID and group.
	 *
	 * @param uuid the bookstore's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bookstore
	 * @throws PortalException if a matching bookstore could not be found
	 */
	@Override
	public Bookstore getBookstoreByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {
		return bookstorePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the bookstores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nabook.model.impl.BookstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookstores
	 * @param end the upper bound of the range of bookstores (not inclusive)
	 * @return the range of bookstores
	 */
	@Override
	public List<Bookstore> getBookstores(int start, int end) {
		return bookstorePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of bookstores.
	 *
	 * @return the number of bookstores
	 */
	@Override
	public int getBookstoresCount() {
		return bookstorePersistence.countAll();
	}

	/**
	 * Updates the bookstore in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param bookstore the bookstore
	 * @return the bookstore that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Bookstore updateBookstore(Bookstore bookstore) {
		return bookstorePersistence.update(bookstore);
	}

	/**
	 * Returns the address local service.
	 *
	 * @return the address local service
	 */
	public com.nabook.service.AddressLocalService getAddressLocalService() {
		return addressLocalService;
	}

	/**
	 * Sets the address local service.
	 *
	 * @param addressLocalService the address local service
	 */
	public void setAddressLocalService(
		com.nabook.service.AddressLocalService addressLocalService) {
		this.addressLocalService = addressLocalService;
	}

	/**
	 * Returns the address persistence.
	 *
	 * @return the address persistence
	 */
	public AddressPersistence getAddressPersistence() {
		return addressPersistence;
	}

	/**
	 * Sets the address persistence.
	 *
	 * @param addressPersistence the address persistence
	 */
	public void setAddressPersistence(AddressPersistence addressPersistence) {
		this.addressPersistence = addressPersistence;
	}

	/**
	 * Returns the author local service.
	 *
	 * @return the author local service
	 */
	public com.nabook.service.AuthorLocalService getAuthorLocalService() {
		return authorLocalService;
	}

	/**
	 * Sets the author local service.
	 *
	 * @param authorLocalService the author local service
	 */
	public void setAuthorLocalService(
		com.nabook.service.AuthorLocalService authorLocalService) {
		this.authorLocalService = authorLocalService;
	}

	/**
	 * Returns the author persistence.
	 *
	 * @return the author persistence
	 */
	public AuthorPersistence getAuthorPersistence() {
		return authorPersistence;
	}

	/**
	 * Sets the author persistence.
	 *
	 * @param authorPersistence the author persistence
	 */
	public void setAuthorPersistence(AuthorPersistence authorPersistence) {
		this.authorPersistence = authorPersistence;
	}

	/**
	 * Returns the book local service.
	 *
	 * @return the book local service
	 */
	public com.nabook.service.BookLocalService getBookLocalService() {
		return bookLocalService;
	}

	/**
	 * Sets the book local service.
	 *
	 * @param bookLocalService the book local service
	 */
	public void setBookLocalService(
		com.nabook.service.BookLocalService bookLocalService) {
		this.bookLocalService = bookLocalService;
	}

	/**
	 * Returns the book persistence.
	 *
	 * @return the book persistence
	 */
	public BookPersistence getBookPersistence() {
		return bookPersistence;
	}

	/**
	 * Sets the book persistence.
	 *
	 * @param bookPersistence the book persistence
	 */
	public void setBookPersistence(BookPersistence bookPersistence) {
		this.bookPersistence = bookPersistence;
	}

	/**
	 * Returns the book order local service.
	 *
	 * @return the book order local service
	 */
	public com.nabook.service.BookOrderLocalService getBookOrderLocalService() {
		return bookOrderLocalService;
	}

	/**
	 * Sets the book order local service.
	 *
	 * @param bookOrderLocalService the book order local service
	 */
	public void setBookOrderLocalService(
		com.nabook.service.BookOrderLocalService bookOrderLocalService) {
		this.bookOrderLocalService = bookOrderLocalService;
	}

	/**
	 * Returns the book order persistence.
	 *
	 * @return the book order persistence
	 */
	public BookOrderPersistence getBookOrderPersistence() {
		return bookOrderPersistence;
	}

	/**
	 * Sets the book order persistence.
	 *
	 * @param bookOrderPersistence the book order persistence
	 */
	public void setBookOrderPersistence(
		BookOrderPersistence bookOrderPersistence) {
		this.bookOrderPersistence = bookOrderPersistence;
	}

	/**
	 * Returns the bookstore local service.
	 *
	 * @return the bookstore local service
	 */
	public BookstoreLocalService getBookstoreLocalService() {
		return bookstoreLocalService;
	}

	/**
	 * Sets the bookstore local service.
	 *
	 * @param bookstoreLocalService the bookstore local service
	 */
	public void setBookstoreLocalService(
		BookstoreLocalService bookstoreLocalService) {
		this.bookstoreLocalService = bookstoreLocalService;
	}

	/**
	 * Returns the bookstore persistence.
	 *
	 * @return the bookstore persistence
	 */
	public BookstorePersistence getBookstorePersistence() {
		return bookstorePersistence;
	}

	/**
	 * Sets the bookstore persistence.
	 *
	 * @param bookstorePersistence the bookstore persistence
	 */
	public void setBookstorePersistence(
		BookstorePersistence bookstorePersistence) {
		this.bookstorePersistence = bookstorePersistence;
	}

	/**
	 * Returns the cart local service.
	 *
	 * @return the cart local service
	 */
	public com.nabook.service.CartLocalService getCartLocalService() {
		return cartLocalService;
	}

	/**
	 * Sets the cart local service.
	 *
	 * @param cartLocalService the cart local service
	 */
	public void setCartLocalService(
		com.nabook.service.CartLocalService cartLocalService) {
		this.cartLocalService = cartLocalService;
	}

	/**
	 * Returns the cart persistence.
	 *
	 * @return the cart persistence
	 */
	public CartPersistence getCartPersistence() {
		return cartPersistence;
	}

	/**
	 * Sets the cart persistence.
	 *
	 * @param cartPersistence the cart persistence
	 */
	public void setCartPersistence(CartPersistence cartPersistence) {
		this.cartPersistence = cartPersistence;
	}

	/**
	 * Returns the order item local service.
	 *
	 * @return the order item local service
	 */
	public com.nabook.service.OrderItemLocalService getOrderItemLocalService() {
		return orderItemLocalService;
	}

	/**
	 * Sets the order item local service.
	 *
	 * @param orderItemLocalService the order item local service
	 */
	public void setOrderItemLocalService(
		com.nabook.service.OrderItemLocalService orderItemLocalService) {
		this.orderItemLocalService = orderItemLocalService;
	}

	/**
	 * Returns the order item persistence.
	 *
	 * @return the order item persistence
	 */
	public OrderItemPersistence getOrderItemPersistence() {
		return orderItemPersistence;
	}

	/**
	 * Sets the order item persistence.
	 *
	 * @param orderItemPersistence the order item persistence
	 */
	public void setOrderItemPersistence(
		OrderItemPersistence orderItemPersistence) {
		this.orderItemPersistence = orderItemPersistence;
	}

	/**
	 * Returns the stock item local service.
	 *
	 * @return the stock item local service
	 */
	public com.nabook.service.StockItemLocalService getStockItemLocalService() {
		return stockItemLocalService;
	}

	/**
	 * Sets the stock item local service.
	 *
	 * @param stockItemLocalService the stock item local service
	 */
	public void setStockItemLocalService(
		com.nabook.service.StockItemLocalService stockItemLocalService) {
		this.stockItemLocalService = stockItemLocalService;
	}

	/**
	 * Returns the stock item persistence.
	 *
	 * @return the stock item persistence
	 */
	public StockItemPersistence getStockItemPersistence() {
		return stockItemPersistence;
	}

	/**
	 * Sets the stock item persistence.
	 *
	 * @param stockItemPersistence the stock item persistence
	 */
	public void setStockItemPersistence(
		StockItemPersistence stockItemPersistence) {
		this.stockItemPersistence = stockItemPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the ratings stats local service.
	 *
	 * @return the ratings stats local service
	 */
	public com.liferay.ratings.kernel.service.RatingsStatsLocalService getRatingsStatsLocalService() {
		return ratingsStatsLocalService;
	}

	/**
	 * Sets the ratings stats local service.
	 *
	 * @param ratingsStatsLocalService the ratings stats local service
	 */
	public void setRatingsStatsLocalService(
		com.liferay.ratings.kernel.service.RatingsStatsLocalService ratingsStatsLocalService) {
		this.ratingsStatsLocalService = ratingsStatsLocalService;
	}

	/**
	 * Returns the ratings stats persistence.
	 *
	 * @return the ratings stats persistence
	 */
	public RatingsStatsPersistence getRatingsStatsPersistence() {
		return ratingsStatsPersistence;
	}

	/**
	 * Sets the ratings stats persistence.
	 *
	 * @param ratingsStatsPersistence the ratings stats persistence
	 */
	public void setRatingsStatsPersistence(
		RatingsStatsPersistence ratingsStatsPersistence) {
		this.ratingsStatsPersistence = ratingsStatsPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.nabook.model.Bookstore",
			bookstoreLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.nabook.model.Bookstore");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BookstoreLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Bookstore.class;
	}

	protected String getModelClassName() {
		return Bookstore.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = bookstorePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.nabook.service.AddressLocalService.class)
	protected com.nabook.service.AddressLocalService addressLocalService;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = com.nabook.service.AuthorLocalService.class)
	protected com.nabook.service.AuthorLocalService authorLocalService;
	@BeanReference(type = AuthorPersistence.class)
	protected AuthorPersistence authorPersistence;
	@BeanReference(type = com.nabook.service.BookLocalService.class)
	protected com.nabook.service.BookLocalService bookLocalService;
	@BeanReference(type = BookPersistence.class)
	protected BookPersistence bookPersistence;
	@BeanReference(type = com.nabook.service.BookOrderLocalService.class)
	protected com.nabook.service.BookOrderLocalService bookOrderLocalService;
	@BeanReference(type = BookOrderPersistence.class)
	protected BookOrderPersistence bookOrderPersistence;
	@BeanReference(type = BookstoreLocalService.class)
	protected BookstoreLocalService bookstoreLocalService;
	@BeanReference(type = BookstorePersistence.class)
	protected BookstorePersistence bookstorePersistence;
	@BeanReference(type = com.nabook.service.CartLocalService.class)
	protected com.nabook.service.CartLocalService cartLocalService;
	@BeanReference(type = CartPersistence.class)
	protected CartPersistence cartPersistence;
	@BeanReference(type = com.nabook.service.OrderItemLocalService.class)
	protected com.nabook.service.OrderItemLocalService orderItemLocalService;
	@BeanReference(type = OrderItemPersistence.class)
	protected OrderItemPersistence orderItemPersistence;
	@BeanReference(type = com.nabook.service.StockItemLocalService.class)
	protected com.nabook.service.StockItemLocalService stockItemLocalService;
	@BeanReference(type = StockItemPersistence.class)
	protected StockItemPersistence stockItemPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.ratings.kernel.service.RatingsStatsLocalService.class)
	protected com.liferay.ratings.kernel.service.RatingsStatsLocalService ratingsStatsLocalService;
	@ServiceReference(type = RatingsStatsPersistence.class)
	protected RatingsStatsPersistence ratingsStatsPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}