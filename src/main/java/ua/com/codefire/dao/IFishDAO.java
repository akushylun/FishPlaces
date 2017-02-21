/*
s * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import java.util.List;

import ua.com.codefire.dao.entity.Fish;

/**
 *
 * @author 1
 */
public interface IFishDAO {
    
    List<Fish> getAll();
    void addFish(Fish fish);
    Fish getByName (String name);   
    
}
