/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.entity;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author chunyap
 */
public class User {
    protected String id;
    protected String name;
    protected String mobile;
    
    public User(){}
    
    public User(String id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }
    
    public String getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
    
    public String getMobile() {
        return mobile;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
    public Map<String, String> toMap(){
        ObjectMapper oMapper = new ObjectMapper();
        // object -> Map
        return oMapper.convertValue(this, Map.class);
    }
}