package org.example.Repository;

import org.example.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {


//    @Query(value = "select userid,name,password,email,phone, xstatus,isactive,usertypeid from user_details where email=:email",nativeQuery = true)
//    UserDetails getUserDetailsByEmailId(String email);

    UserDetails findByEmail(String trim);

    UserDetails findByUserId(Integer id);

    @Query(value = "select * from user_details ud inner join service_provider_details s \n" +
            "on ud.userid = s.userid and servicestatus=1\n" +
            "where ud.userid=:id", nativeQuery = true)
    List<Map<String, Object>> getAllSerProServices(Integer id);


}
