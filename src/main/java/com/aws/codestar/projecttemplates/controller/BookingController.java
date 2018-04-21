/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.common.ResponseMessage;
import com.aws.codestar.projecttemplates.common.TimeSlot;
import com.aws.codestar.projecttemplates.entity.Booking;
import com.aws.codestar.projecttemplates.service.BookingService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author chunyap
 */
@RestController
@EnableWebMvc
public class BookingController {
    @Autowired private BookingService serv;
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/booking", method = RequestMethod.POST)
    public Map<String,String> addBooking(
            @RequestParam(value="userId") String userId,
            @RequestParam(value="lat") String lat,
            @RequestParam(value="long") String _long,
            @RequestParam(value="slot") TimeSlot slot){
        try{
            Booking booking = serv.addBooking(userId, lat, _long, slot);
            return new ResponseMessage(booking.toMap(), "OK", "Booking Completed").toMap();
        }catch(Exception e){
            return this.handleError(e);
        }
    }
    
    /**
     * To add data to the booking such as voice memo
     * @param name
     * @return 
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/booking", method = RequestMethod.PUT)
    public Map<String,String> addUser(
            @RequestParam(value="name") String name){
        return new ResponseMessage("FAIL", "Testing").toMap();
    }
    
    /**
     * Retrieving bookings
     * TODO return list of bookings
     * @param id
     * @return 
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/booking", method = RequestMethod.GET)
    public Map<String,String> getAll(){
        try{
            List<Booking> bookingList = serv.getAllBookings();
            Map<String, String> result = new HashMap<>();
                                    
            return new ResponseMessage(result, "OK", "Bookings Retrieved").toMap();
        }catch(Exception e){
            return this.handleError(e);
        }
    }
    
    protected Map<String,String> handleError(Exception e){
        return new ResponseMessage("FAIL", e.getMessage().toString()).toMap();
    }
}
