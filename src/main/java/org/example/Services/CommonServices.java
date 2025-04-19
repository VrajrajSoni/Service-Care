package org.example.Services;

import jakarta.websocket.OnClose;
import org.example.DTO.BookingDetailsDTO;
import org.example.DTO.ServiceProviderDTO;
import org.example.DTO.UserLoginDTO;
import org.example.DTO.UserRegisterDTO;
import org.example.Entity.BookingDetails;
import org.example.Entity.MasterServiceType;
//import org.example.Entity.ServiceProviderDetails;
import org.example.Entity.ServiceProviderDetails;
import org.example.Entity.UserDetails;
import org.example.Repository.BookingDetailsRepository;
import org.example.Repository.MasterServiceTypeRepository;
//import org.example.Repository.ServiceProviderDetailsRepository;
import org.example.Repository.ServiceProviderDetailsRepository;
import org.example.Repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServices {
    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private  UserDetailsRepository userDetailsRepository;
    @Autowired
    private MasterServiceTypeRepository masterServiceTypeRepository;

    @Autowired
    private ServiceProviderDetailsRepository serviceProviderDetailsRepository;


    public Map<String, String> insertUserRegister(UserRegisterDTO userRegisterDTO) {
        Map<String, String> status = new HashMap<>();
       UserDetails userDetail = userDetailsRepository.findByEmail(userRegisterDTO.getEmail().trim());
        if (userDetail != null && userDetail.getEmail().equals(userRegisterDTO.getEmail().trim())) {
            status.put("stauts", "2");
            status.put("message", "This Email Address is already registered");
            return status;
        }


        try {

            UserDetails userDetails = new UserDetails();
            userDetails.setEmail(userRegisterDTO.getEmail());
            userDetails.setName(userRegisterDTO.getUsername());
            userDetails.setUserTypeId(userRegisterDTO.getUserType());
//            userDetails.setLoginId(userRegisterDTO.getEmail());
            userDetails.setPassword(userRegisterDTO.getPassword());
            userDetails.setPhone(userRegisterDTO.getPhone());
            userDetails.setIsactive(1);
            userDetailsRepository.save(userDetails);
            status.put("satus", "1");
            status.put("userType", userDetails.getUserTypeId().toString());
            status.put("message", "USer Details Successfully inserted");
            return status;
        } catch (Exception e) {
            status.put("satus", "1");
            status.put("message", "USer Details Successfully inserted");
            return status;
        }

    }



    public Map<String, Object> checkUserLogin(UserLoginDTO userRegisterDTO) {
        Map<String, Object> map = new HashMap<>();
        UserDetails userDetails = userDetailsRepository.findByEmail(userRegisterDTO.getEmail().trim());
        if (userDetails!= null   && userDetails.getPassword().equals(userRegisterDTO.getPassword().trim())) {
            map.put("status", "1");
            map.put("data", userDetails);
            return map;
        }
        map.put("status", 2);
        return map;
    }

    public List<MasterServiceType> getServicesType() {
        return masterServiceTypeRepository.findAll();
    }

    public Map<String, Object> insertSerProviderDetails(ServiceProviderDTO serviceProviderDTO) {

        Map<String , Object> map =new HashMap<>();
        try {
            ServiceProviderDetails serviceProviderDetails = new ServiceProviderDetails();
            serviceProviderDetails.setServicePrice(serviceProviderDTO.getServicePrice());
            serviceProviderDetails.setServiceDescription(serviceProviderDTO.getServiceDes());
            serviceProviderDetails.setServiceTypeId(serviceProviderDTO.getServiceTypeId().toString());
            serviceProviderDetails.setServiceStatus(serviceProviderDTO.getStatus());
            serviceProviderDetails.setUserId(serviceProviderDTO.getUserid());

            serviceProviderDetailsRepository.save(serviceProviderDetails);
            map.put("status","1");
            return map;
        }catch (Exception e){
            map.put("status","1");
            return map;
        }
    }

    public UserDetails getUSerDetailsById(Integer id) {
        return userDetailsRepository.findByUserId(id);
    }

    public List<Map<String, Object>> getAllSerProServices(Integer id) {
        return userDetailsRepository.getAllSerProServices(id);
    }


    public Map<String , String> saveBookingDetails(BookingDetailsDTO dto) {
        Map<String, String> res = new HashMap<>();

        try {
            BookingDetails booking = new BookingDetails();

            booking.setUserid(dto.getUserid());
            booking.setPreferredtime(dto.getPreferredtime());
            booking.setServiceproid(dto.getServiceproid());
            booking.setStateid(dto.getStateid());
            booking.setDescrictid(dto.getDescrictid());
            booking.setAreaid(dto.getAreaid());
            booking.setCardnumber(dto.getCardnumber());
            booking.setExpriydate(dto.getExpriydate());
            booking.setCvv(dto.getCvv());
            booking.setCardholhernem(dto.getCardholhernem());
            booking.setStatus(0);
            booking.setMsertypeid(dto.getMsertypeid());
            booking.setCreatedon(LocalDateTime.now());
            booking.setAddress(dto.getAddress());
            booking.setPincode(dto.getPincode());

            bookingDetailsRepository.save(booking);
            res.put("stauts", "1");
            return res;
        }catch (Exception e){
            res.put("stauts", "2");
            return res;
        }
    }

    public List<Map<String, String>> getListServiceProvider(Integer msertypeid) {
        return serviceProviderDetailsRepository.getListServiceProvider(msertypeid);
    }

    public List<Map<String, String>> getALLClientServices(Integer userid) {
        return bookingDetailsRepository.getALLClientServices(userid);
    }

    public List<Map<String, String>> getServiceProviderAllDetails(Integer userid) {
        return serviceProviderDetailsRepository.getServiceProviderAllDetails(userid);
    }

    public List<Map<String, String>> getAllReceivedServiceSetProvider(Integer userid) {
        return bookingDetailsRepository.getAllReceivedServiceSetProvider(userid);
    }

    public Map<String, String> updateClientBookingId(Integer booking) {
        Map<String, String > map = new HashMap<>();
        try{
            BookingDetails bookingDetails = bookingDetailsRepository.findByBookingid(booking);
            bookingDetails.setStatus(1);
            bookingDetails.setUpdatedon(LocalDateTime.now());
            bookingDetailsRepository.save(bookingDetails);
            map.put("status","1");
            return map;
        }catch (Exception e){
            map.put("status","2");
            return map;
        }
    }

    public Map<String, String> updateBookingId(Integer booking) {
        Map<String, String > map = new HashMap<>();
        try{
            BookingDetails bookingDetails = bookingDetailsRepository.findByBookingid(booking);
            bookingDetails.setStatus(2);
            bookingDetails.setUpdatedon(LocalDateTime.now());
            bookingDetailsRepository.save(bookingDetails);
            map.put("status","1");
            return map;
        }catch (Exception e){
            map.put("status","2");
            return map;
        }
    }

    public List<Map<String, String>> getBookingAllDetailsToAdmin() {
        return serviceProviderDetailsRepository.getBookingAllDetailsToAdmin();
    }


    public List<Map<String, String>> adminGetAllBooking() {
        return bookingDetailsRepository.adminGetAllBooking();
    }
    public List<Map<String, String>> adminGetAllServices() {
        return bookingDetailsRepository.adminGetAllServices();
    }

    public List<Map<String, String>> getPaymentDoneAllDetails() {
        return bookingDetailsRepository.getPaymentDeoneALlDetails();

    }

    public List<Map<String, String>> getNewServiceProviderDetails() {
        return serviceProviderDetailsRepository.getNewServiceProviderDetails();

    }

    public Map<String, Object> getSalesDetails() {
        Map<String,Object> map = new HashMap<>();
        Map<String,String> monthDetails = bookingDetailsRepository.getMonthlyDetails();
        Map<String,String>   total = bookingDetailsRepository.getTotalDetails();
        map.put("monthDetails",monthDetails);
        map.put("total",total);
        return map;
    }

    public List<Map<String, String>> adminGetAllPendingBooking() {
        return bookingDetailsRepository.adminGetAllPendingBooking();
    }

    public List<Map<String, String>> adminGetAllAcceptBooking() {
        return bookingDetailsRepository.adminGetAllAcceptBooking();
    }

    public List<Map<String, String>> getServiceProviderAllDetailsAdmin() {
        return serviceProviderDetailsRepository.getServiceProviderAllDetailsAdmin();

    }

    public List<Map<String, String>> adminBookingChart() {
        return bookingDetailsRepository.adminBookingChart();
    }
}
