package org.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "booking_details")
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingid;

    private Integer userid;

    private String preferredtime;

    private Integer serviceproid;

    private Integer stateid;

    private Integer descrictid;

    private Integer areaid;

    private String cardnumber;

    private String expriydate;

    private String cvv;

    private String cardholhernem;
    private String address;
    private String pincode;
    private Integer status;
    private Integer msertypeid;
    private LocalDateTime updatedon;
    private LocalDateTime createdon;
}
