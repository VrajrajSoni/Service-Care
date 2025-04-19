package org.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ServiceProviderDTO {
    private Integer serviceTypeId;
    private String servicePrice;
    private String serviceDes;
    private Integer status;
    private Integer userid;

}
