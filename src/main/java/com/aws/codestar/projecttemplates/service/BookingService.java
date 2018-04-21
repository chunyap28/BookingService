/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.common.TimeSlot;
import com.aws.codestar.projecttemplates.entity.Booking;
import com.aws.codestar.projecttemplates.entity.Branch;
import com.aws.codestar.projecttemplates.repository.BookingRepository;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author chunyap
 */
@Service
public class BookingService {
    
    @Autowired
    private BookingRepository repo;
    
    @Autowired
    private RestTemplate restTemplate;

    public Booking addBooking(String userId, String lat, String _long, TimeSlot slot){
        //validate user
        
        //get nearest branch by lat long 
        Branch branch = new Branch();
        branch.setAddress("Blk 450 Clementi Avenue 3 #01-293/295");
        branch.setLatitude("1.31358");
        branch.setLongitude("103.76537");
        branch.setName("Clementi Branch");
        branch.setPostalCode("Singapore 120450");        
        
        String branchId = "821125"; //sample
        
        //get next available slot
        int r = (int) (Math.random() * (17 - 8)) + 8;
        LocalTime fromTime = LocalTime.of(r, 0, 0, 0);
        LocalTime toTime = LocalTime.of(r, 15, 0, 0);

        //save booking
        Booking booking = new Booking(userId, branchId, fromTime, toTime);
        booking.setBranch(branch);
        repo.save(booking);
        return booking;
    }
    
    public List<Booking> getAllBookings() throws Exception{
        List<Booking> bookingList = (List<Booking>) repo.findAll();
        if( bookingList.size() <= 0 ){
            throw new Exception("No Booking Found");
        }
        
        return bookingList;
    }
    
    //1.355000
    //103.867000
}
