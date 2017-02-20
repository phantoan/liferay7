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

import com.nabook.model.Cart;

import com.nabook.service.CartLocalService;
import com.nabook.service.persistence.AddressPersistence;
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
 * Provides the base implementation for the cart local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.nabook.service.impl.CartLocalServiceImpl}.
 * </p>
 *
 * @author phantoan
 * @see com.nabook.service.impl.CartLocalServiceImpl
 * @see com.nabook.service.CartLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class CartLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CartLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.nabook.service.CartLocalServiceUtil} to access the cart local service.
	 */

	/**
	 * Adds the cart to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cart the cart
	 * @return the cart that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Cart addCart(Cart cart) {
		cart.setNew(true);

		return cartPersistence.update(cart);
	}

	/**
	 * Creates a new cart with the primary key. Does not add the cart to the database.
	 *
	 * @param cartId the primary key for the new cart
	 * @return the new cart
	 */
	@Override
	public Cart createCart(long cartId) {
		return cartPersistence.create(cartId);
	}

	/**
	 * Deletes the cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cartId the primary key of the cart
	 * @return the cart that was removed
	 * @throws PortalException if a cart with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Cart deleteCart(long cartId) throws PortalException {
		return cartPersistence.remove(cartId);
	}

	/**
	 * Deletes the cart from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cart the cart
	 * @return the cart that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Cart deleteCart(Cart cart) {
		return cartPersistence.remove(cart);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Cart.class,
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
		return cartPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nabook.model.impl.CartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return cartPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nabook.model.impl.CartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return cartPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return cartPersistence.countWithDynamicQuery(dynamicQuery);
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
		return cartPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Cart fetchCart(long cartId) {
		return cartPersistence.fetchByPrimaryKey(cartId);
	}

	/**
	 * Returns the cart matching the UUID and group.
	 *
	 * @param uuid the cart's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cart, or <code>null</code> if a matching cart could not be found
	 */
	@Override
	public Cart fetchCartByUuidAndGroupId(String uuid, long groupId) {
		return cartPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cart with the primary key.
	 *
	 * @param cartId the primary key of the cart
	 * @return the cart
	 * @throws PortalException if a cart with the primary key could not be found
	 */
	@Override
	public Cart getCart(long cartId) throws PortalException {
		return cartPersistence.findByPrimaryKey(cartId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(cartLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Cart.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("cartId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(cartLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Cart.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("cartId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(cartLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Cart.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("cartId");
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

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Cart>() {
				@Override
				public void performAction(Cart cart) throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						cart);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(Cart.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return cartLocalService.deleteCart((Cart)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return cartPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the carts matching the UUID and company.
	 *
	 * @param uuid the UUID of the carts
	 * @param companyId the primary key of the company
	 * @return the matching carts, or an empty list if no matches were found
	 */
	@Override
	public List<Cart> getCartsByUuidAndCompanyId(String uuid, long companyId) {
		return cartPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of carts matching the UUID and company.
	 *
	 * @param uuid the UUID of the carts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of carts
	 * @param end the upper bound of the range of carts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching carts, or an empty list if no matches were found
	 */
	@Override
	public List<Cart> getCartsByUuidAndCompanyId(String uuid, long companyId,
		int start, int end, OrderByComparator<Cart> orderByComparator) {
		return cartPersistence.findByUuid_C(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the cart matching the UUID and group.
	 *
	 * @param uuid the cart's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cart
	 * @throws PortalException if a matching cart could not be found
	 */
	@Override
	public Cart getCartByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {
		return cartPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nabook.model.impl.CartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of carts
	 * @param end the upper bound of the range of carts (not inclusive)
	 * @return the range of carts
	 */
	@Override
	public List<Cart> getCarts(int start, int end) {
		return cartPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of carts.
	 *
	 * @return the number of carts
	 */
	@Override
	public int getCartsCount() {
		return cartPersistence.countAll();
	}

	/**
	 * Updates the cart in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cart the cart
	 * @return the cart that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Cart updateCart(Cart cart) {
		return cartPersistence.update(cart);
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
	public com.nabook.service.BookstoreLocalService getBookstoreLocalService() {
		return bookstoreLocalService;
	}

	/**
	 * Sets the bookstore local service.
	 *
	 * @param bookstoreLocalService the bookstore local service
	 */
	public void setBookstoreLocalService(
		com.nabook.service.BookstoreLocalService bookstoreLocalService) {
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
	public CartLocalService getCartLocalService() {
		return cartLocalService;
	}

	/**
	 * Sets the cart local service.
	 *
	 * @param cartLocalService the cart local service
	 */
	public void setCartLocalService(CartLocalService cartLocalService) {
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

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.nabook.model.Cart",
			cartLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister("com.nabook.model.Cart");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CartLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Cart.class;
	}

	protected String getModelClassName() {
		return Cart.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = cartPersistence.getDataSource();

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
	@BeanReference(type = com.nabook.service.BookLocalService.class)
	protected com.nabook.service.BookLocalService bookLocalService;
	@BeanReference(type = BookPersistence.class)
	protected BookPersistence bookPersistence;
	@BeanReference(type = com.nabook.service.BookOrderLocalService.class)
	protected com.nabook.service.BookOrderLocalService bookOrderLocalService;
	@BeanReference(type = BookOrderPersistence.class)
	protected BookOrderPersistence bookOrderPersistence;
	@BeanReference(type = com.nabook.service.BookstoreLocalService.class)
	protected com.nabook.service.BookstoreLocalService bookstoreLocalService;
	@BeanReference(type = BookstorePersistence.class)
	protected BookstorePersistence bookstorePersistence;
	@BeanReference(type = CartLocalService.class)
	protected CartLocalService cartLocalService;
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
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}