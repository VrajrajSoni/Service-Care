package org.example.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.DTO.BookingDetailsDTO;
import org.example.DTO.ServiceProviderDTO;
import org.example.DTO.UserLoginDTO;
import org.example.DTO.UserRegisterDTO;
import org.example.Entity.MasterServiceType;
import org.example.Entity.UserDetails;
import org.example.Services.CommonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@RestController
public class UserRegisterController {


    @Autowired
    private CommonServices commonServices;


    @GetMapping(value = "/get-master-services-type")
    public List<MasterServiceType> getServicesType() {
        return commonServices.getServicesType();
    }

    @PostMapping(value = "/user-register")
    public Map<String, String> userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        return commonServices.insertUserRegister(userRegisterDTO);
    }

    @PostMapping(value = "/check-user-login")
    public Map<String, Object> checkUserLogin(@RequestBody UserLoginDTO userLoginDTO) {
        return commonServices.checkUserLogin(userLoginDTO);
    }

    @PostMapping(value = "/insert-service-provider")
    public Map<String, Object> insertSerProviderDetails(@RequestBody ServiceProviderDTO serviceProviderDTO) {
        return commonServices.insertSerProviderDetails(serviceProviderDTO);
    }
//    @PostMapping(value = "/edit-service-provider/(serprovierid)")
//    public Map<String, Object> insertSerProviderDetails(@PathVariable ("serprovierid") Integer serprovierid) {
//        return commonServices.insertSerProviderDetails(serviceProviderDTO);
//    }

    @GetMapping(value = "/get-user-details-byid/{id}")
    public UserDetails getUSerDetailsById(@PathVariable("id") Integer id) {
        return commonServices.getUSerDetailsById(id);
    }

    @GetMapping(value = "/get-service-pro-sevices/{userid}")
    public List<Map<String, Object>> getAllSerProServices(@PathVariable("userid") Integer id) {
        return commonServices.getAllSerProServices(id);
    }

    @PostMapping("/save-booking-details")
    public Map<String, String> saveBookingDetails(@RequestBody BookingDetailsDTO dto) {
        return commonServices.saveBookingDetails(dto);
    }

    @GetMapping("/get-list-service-provider/{serviceid}")
    public List<Map<String, String>> getListServiceProvider(@PathVariable("serviceid") Integer serviceid) {
        return commonServices.getListServiceProvider(serviceid);
    }

    @GetMapping("/get-all-client-services/{userid}")
    public List<Map<String, String>> getALLClientServices(@PathVariable("userid") Integer userid) {
        return commonServices.getALLClientServices(userid);
    }

    @GetMapping("/get-service-provider-all-details/{userid}")
    public List<Map<String, String>> getServiceProviderAllDetails(@PathVariable("userid") Integer userid) {
        return commonServices.getServiceProviderAllDetails(userid);
    }

    @GetMapping("/get-all-received-service-set-provider/{userid}")
    public List<Map<String, String>> getAllReceivedServiceSetProvider(@PathVariable("userid") Integer userid) {
        return commonServices.getAllReceivedServiceSetProvider(userid);
    }

    @GetMapping("/update-booking-status/{booking}")
    public Map<String, String> updateBookingId(@PathVariable("booking") Integer booking) {
        return commonServices.updateBookingId(booking);
    }

    @GetMapping("/update-booking-status-client/{booking}")
    public Map<String, String> updateClientBookingId(@PathVariable("booking") Integer booking) {
        return commonServices.updateClientBookingId(booking);
    }
    @GetMapping("/get-booking-all-details-admin")
    public List<Map<String, String>> getBookingAllDetailsToAdmin() {
        return commonServices.getBookingAllDetailsToAdmin();
    }


    @GetMapping("/admin-get-payment-done-details")
    public List<Map<String, String>> getPaymentDoneAllDetails() {
        return commonServices.getPaymentDoneAllDetails();
    }

    @GetMapping("/admin-new-service-provider-details")
    public List<Map<String, String>> getNewServiceProviderDetails() {
        return commonServices.getNewServiceProviderDetails();
    }

    @GetMapping("/admin-get-all-booking")
    public List<Map<String, String>> adminGetAllBooking() {
        return commonServices.adminGetAllBooking();
    }

    @GetMapping("/admin-get-all-pending-booking")
    public List<Map<String, String>> adminGetAllPendingBooking() {
        return commonServices.adminGetAllPendingBooking();
    }

    @GetMapping("/admin-get-all-accept-booking")
    public List<Map<String, String>> adminGetAllAcceptBooking() {
        return commonServices.adminGetAllAcceptBooking();
    }

    @GetMapping("/admin-get-all-rejetct-services")
    public List<Map<String, String>> adminGetAllRejectServices() {
        return commonServices.adminGetAllServices();
    }

    @GetMapping("/get-sales-details")
    public Map<String, Object> getSalesDetails() {
        return commonServices.getSalesDetails();
    }

    @GetMapping("/admin-get-service-provider-all-details")
    public List<Map<String, String>> getServiceProviderAllDetailsAdmin() {
        return commonServices.getServiceProviderAllDetailsAdmin();
    }

    @GetMapping("/admin-booking-chart-monthly")
    public List<Map<String, String>> adminBookingChart() {
        return commonServices.adminBookingChart();
    }

}
