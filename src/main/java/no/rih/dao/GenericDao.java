package no.rih.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	void create(T entity);

	void create(T entity, ID id);

	T findById(ID id);
	
	T findAll();

	void update(T entity);

	void delete(T entity);
}