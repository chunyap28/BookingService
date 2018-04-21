package com.aws.codestar.projecttemplates.repository;
 
import com.aws.codestar.projecttemplates.entity.Booking;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
 
 
@EnableScan
public interface BookingRepository extends CrudRepository<Booking, String> { 
	List<Booking> findByUserId(String UserId);
}