/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service;

import esprit.pidev.models.ObjectPersistant;
import java.util.List;

/**
 *
 * @author LACRIM
 * @param <T>
 */
public interface IObjectPersistantService <T extends ObjectPersistant>{
     public T add(T o) ;
     public List<T> getAll() ;
     public T getOne(Long id);
     public void delete(Long id) ;
     public boolean Update(Long id);
}
