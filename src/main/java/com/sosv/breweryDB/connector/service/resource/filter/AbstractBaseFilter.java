package com.sosv.breweryDB.connector.service.resource.filter;

import java.util.Collection;

/**
 * Abstract class for a base filter. Implement {@link IBaseFilter}
 * @author ssommerf
 *
 */
public abstract class AbstractBaseFilter implements IBaseFilter {

	private Collection<String> ids;
	private String name;
	protected Boolean organic;
	private Long since;
	private Sorting sort;

	/**
	 * Default c'tor
	 */
	public AbstractBaseFilter() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.service.resource.filter.IBaseFilter#getIds()
	 */
	@Override
	public Collection<String> getIds() {
		return ids;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.service.resource.filter.IBaseFilter#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.service.resource.filter.IBaseFilter#getSince()
	 */
	@Override
	public Long getSince() {
		return since;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.service.resource.filter.IBaseFilter#getSort()
	 */
	@Override
	public Sorting getSort() {
		return sort;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.service.resource.filter.IBaseFilter#isOrganic()
	 */
	@Override
	public Boolean isOrganic() {
		return organic;
	}

	public void setOrganic(Boolean organic) {
		this.organic = organic;
	}

	public void setIds(Collection<String> ids) {
		this.ids = ids;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSince(Long since) {
		this.since = since;
	}

	public void setSort(Sorting sort) {
		this.sort = sort;
	}

}