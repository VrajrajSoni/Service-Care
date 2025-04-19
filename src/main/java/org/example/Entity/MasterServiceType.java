package org.example.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="master_servicetype")
public class MasterServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "msertypeid")
    private Integer mserTypeId;
    private String name;
}
