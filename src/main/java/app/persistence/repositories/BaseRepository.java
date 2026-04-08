package app.persistence.repositories;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import app.persistence.entities.Page;
import app.persistence.repositories.exceptions.DataNotFoundException;

public class BaseRepository<E> {
	
	@PersistenceContext
    protected EntityManager entityManager;
	
	private Class<E> entityType;
	
	// Inject pageSize from APP configurations	
    private int pageSize;
	
	public void save(E entity) {
		
		entityManager.persist(entity);
	}
	
	public E findById(int id) {
		
		String query = "SELECT entity " + 
					   "FROM   " + entityType.getName() + " entity " +
					   "WHERE  entity.id = :idParam";

		E entity;
		try {
			
			entity = entityManager.createQuery(query, entityType)
									.setParameter("idParam", id)
									.getSingleResult();
			
		} catch (NoResultException e) {
			throw new DataNotFoundException();
		}
	
		return entity;
	}
	
	public Page<Object[]> findByPage(int pageIndex, HashSet<String> pathsOfFields) {
		
		String fields = "";
		int cursor = 0;
		Iterator<String> iterator = pathsOfFields.iterator();
		while ( iterator.hasNext() ) {
			
			fields += iterator.next();
			if ( cursor < pathsOfFields.size() - 1  ) {
				fields += ", ";
			}
			cursor++;
		}
		
		String dataQuery = "SELECT " + fields + " " +
		                   "FROM   " + entityType.getName() + " entity ";
		
		// pageIndex is zero based => will be translated to the index of the first requested element later
		int firstElementIndex = pageIndex * pageSize;
		
		List<Object[]> rawData = entityManager.createQuery(dataQuery, Object[].class)
												.setFirstResult(firstElementIndex)
												.setMaxResults(pageSize)
												.getResultList();		
		if (rawData.isEmpty()) {
			throw new DataNotFoundException();
		}
		
		String countQuery = "SELECT COUNT(*) " + 
							"FROM   " + entityType.getName() + " entity ";
		
		long totalElements = entityManager.createQuery(countQuery, Long.class)
											.getSingleResult();
		
		int totalPages = (int) Math.ceil((totalElements * 1.0) / pageSize);		
		boolean isFirstPage = (pageIndex == 0);
		boolean isLastPage = ((pageIndex + 1) == totalPages);
		
		Page<Object[]> page = new Page<Object[]>();
		page.setData(rawData);
		page.setFirstPage(isFirstPage);
		page.setLastPage(isLastPage);
		
		return page;
	}
	
	public <U> void update(int id, HashSet<String> pathsOfFields, U entityUpdateModel) {
		
		String columnsToBeModified = "";
		int cursor = 0;
		Iterator<String> iterator = pathsOfFields.iterator();
		while ( iterator.hasNext() ) {
			
			String pathOfField = iterator.next();
			String fieldName = pathOfField.substring(pathOfField.lastIndexOf(".") + 1);
			
			String columnToBeModified = pathOfField + " = :" + fieldName + "Param";
			
			if ( cursor < pathsOfFields.size() - 1  ) {
				columnToBeModified += ", ";
			}
			
			columnsToBeModified += columnToBeModified;
			cursor++;
		}
		
		String updateStatement = "UPDATE " + entityType.getName() + " entity " + 
								 "SET    " + columnsToBeModified +
								 "WHERE  entity.id = :idParam";

		Query query = entityManager.createQuery(updateStatement);
		
		Class<?> classOfUpdateModel = entityUpdateModel.getClass();
		Field[] fieldsOfUpdateModel = classOfUpdateModel.getDeclaredFields();
		for (int index = 0; index < fieldsOfUpdateModel.length; index++) {
			
            try {
            	
            	Field field = fieldsOfUpdateModel[index];
                field.setAccessible(true); // grant access to private fields
                                
                query.setParameter(field.getName() + "Param", field.get(entityUpdateModel));

            } catch (IllegalAccessException e) { }
        }
		
		query.setParameter("idParam", id)
				.executeUpdate();
	}
	
	public void delete(int id) {
		
		String deleteStatement = "DELETE FROM " + entityType.getName() + " entity " +
				 				 "WHERE  entity.id = :idParam";

		entityManager.createQuery(deleteStatement)
						.setParameter("idParam", id)
						.executeUpdate();
	}

}
