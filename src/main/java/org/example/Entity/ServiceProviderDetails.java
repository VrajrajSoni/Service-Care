package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "service_provider_details")
public class ServiceProviderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serprovierid")
    private Integer serProviderId;

    @Column(name = "userid")
    private Integer userId;

    @Column(name = "msertypeid")
    private String serviceTypeId;

    @Column(name = "serviceprice")
    private String servicePrice;

    @Column(name = "servicedescription")
    private String serviceDescription;

    @Column(name = "servicestatus")
    private int serviceStatus ; // default value of '1' (active)

}
