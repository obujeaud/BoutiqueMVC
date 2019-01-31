package fr.formation.afpa.bo.services;

import java.util.List;

public interface IService <T, E extends Exception> {
	/**
	 * 
	 * @param t entity to create
	 * @return entity created (same as entity provided, but id was created)
	 * @throws E Possible errors : <br/>
	 * 				entity already created<br/>
	 * 				entity null<br/>
	 * 				entity not created with id
	 */
	public T create(T t) throws E;
	
	/**
	 * 
	 * @param id entity to find thank to the id provided
	 * @return entity found (with the same id as provided)
	 * @throws E Possible errors : <br/>
	 * 				id not found <br/>
	 */
	
	public T findById(Long id) throws E;
	
	/**
	 * 	
	 * @return list of entities declared in database
	 * @throws E Possible errors : <br/>
	 * 				No entities available <br/>
	 * 				list of entities empty or null <br/>
	 */
	
	public List<T> findAll() throws E;
	
	
	/**
	 * 
	 * @param t Entity to update
	 * @return entity updated (must have the same id as entity provided)
	 * @throws E Possible errors : <br/>
	 * 				entity provided null <br/>
	 * 				entity provided not found <br/>
	 */
	
	public T update(T t) throws E;
	
	
	/**
	 * 
	 * @param id id of the entity to delete (must find it with findById function)
	 * @throws E Possible errors : <br/>
	 * 				entity not found <br/>
	 * 				entity not valid (null or with id but not in database) <br/>
	 */
	
	public void deleteById(Long id) throws E;
	
	
	/**
	 * 
	 * @param t entity to delete
	 * @throws E Possible errors : <br/>
	 *  			entity not found <br/>
	 * 				entity not valid (null or with id but not in database) <br/>
	 */
	
	public void delete(T t) throws E;

}
