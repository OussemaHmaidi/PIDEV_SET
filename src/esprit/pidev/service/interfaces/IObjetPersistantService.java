/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.interfaces;

/**
 *
 * @author ousse
 */
import java.util.List;


import esprit.pidev.models.ObjetPersistant;

public interface IObjetPersistantService <T extends ObjetPersistant>  {
	public T save(T t);
	public List<T> getAll();
	public T getOne(int id);
        public T set(T t);
        public void delete(int id);
}

