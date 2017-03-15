<%@ include file="../init.jsp" %>

<%
	String backURL = ParamUtil.getString(request, "backURL");
	long companyId = CompanyThreadLocal.getCompanyId();
	PortletURL iteratorURL = renderResponse.createActionURL();
	iteratorURL.setParameter("mvcPath", "/bookstore/store.jsp");
	iteratorURL.setParameter("backURL", themeDisplay.getURLCurrent());
%>

<liferay-ui:header backURL="<%= backURL %>" title="bookstore.list"/>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/bookstore/search.jsp"/>
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"/>
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL.toString() %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar" >
			<aui:input name="keywords" label="none" inlineField="<%= true %>" type="text"/>
			<aui:button type="submit" icon="icon-search" value="label.search" ></aui:button>
		</span>
	</div>
	<div style="clear:both"></div>
</aui:form>

<aui:panel>
	<liferay-ui:search-container delta="5"
		total="<%= BookstoreLocalServiceUtil.countBookstores()%>"
		emptyResultsMessage="message.empty.bookstore" 
		iteratorURL="<%= iteratorURL %>">
		<liferay-ui:search-container-results 
			results="<%= BookstoreLocalServiceUtil.getAllBookstores(searchContainer.getStart(),
					searchContainer.getEnd())%>" />

		<liferay-ui:search-container-row 
			className="com.nabook.model.Bookstore" 
			modelVar="bookstore">
			
			<portlet:renderURL var="viewBookstoreURL">
				<portlet:param name="mvcPath" value="/bookstore/detail.jsp" />
				<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent()%>"/>
				<portlet:param name="Id" value="<%=String.valueOf(bookstore.getBookstoreId())%>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text property="name" href="<%=viewBookstoreURL.toString()%>"
				name="bookstore.name" />
			<liferay-ui:search-container-column-text name="bookstore.address" href="<%=viewBookstoreURL.toString()%>"
				value='<%=LanguageUtil.get(request, "symbol.postal") + bookstore.getZip() + ", " + bookstore.getCity() + ", " 
						+ bookstore.getPrefecture() + ", " + bookstore.getStreet()%>' />

			<liferay-ui:search-container-column-text property="phone" name="bookstore.phone" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="true"/>
	</liferay-ui:search-container>
</aui:panel>