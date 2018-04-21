/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author chunyap
 */
@DynamoDBTable(tableName = "User")
public class Booking {
    protected String id;
    protected String userId;   //mobile number
    protected String branchId; //branch postal 
    protected Branch branch;
    protected String bookingFromTime;
    protected String bookingToTime;

    public Booking(){}

    public Booking(String userId, String branchId, LocalTime fromTime, LocalTime toTime) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.branchId = branchId;
        this.bookingFromTime = fromTime.toString();
        this.bookingToTime = toTime.toString();
    }
    
    /**
     * @return the id
     */
    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the user_id
     */
    @DynamoDBAttribute(attributeName = "UserId")
    public String getUserId() {
        return userId;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the branch_id
     */
    @DynamoDBAttribute(attributeName = "BranchId")
    public String getBranchId() {
        return branchId;
    }

    /**
     * @param branch_id the branch_id to set
     */
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    /**
     * @return the booking_from_time
     */
    @DynamoDBAttribute(attributeName = "BookingFromTime")
    public String getBookingFromTime() {
        return bookingFromTime;
    }

    /**
     * @param booking_from_time the booking_from_time to set
     */
    public void setBookingFromTime(String bookingFromTime) {
        this.bookingFromTime = bookingFromTime;
    }

    /**
     * @return the booking_to_time
     */
    @DynamoDBAttribute(attributeName = "BookingToTime")
    public String getBookingToTime() {
        return bookingToTime;
    }

    /**
     * @param booking_to_time the booking_to_time to set
     */
    public void setBookingToTime(String bookingToTime) {
        this.bookingToTime = bookingToTime;
    }
    
    public void setBranch(Branch branch){
        this.branch = branch;
    }
    
    @DynamoDBIgnore
    public Branch getBranch(){
        return this.branch;
    }
    
    public Map<String, String> toMap(){
        ObjectMapper oMapper = new ObjectMapper();
        // object -> Map
        return oMapper.convertValue(this, Map.class);
    }
}
