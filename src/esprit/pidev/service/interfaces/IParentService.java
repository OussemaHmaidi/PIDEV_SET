/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.interfaces;

import esprit.pidev.models.Parent;

/**
 *
 * @author ousse
 */
public interface IParentService extends IObjetPersistantService<Parent> {
    public Parent getLoginAccount(String login,String passwort); 
    
}
