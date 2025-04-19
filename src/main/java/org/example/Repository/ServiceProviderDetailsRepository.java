package org.example.Repository;

import org.example.Entity.ServiceProviderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ServiceProviderDetailsRepository extends JpaRepository<ServiceProviderDetails, Integer> {
    @Query(value = "select ud.name,spd.serprovierid, spd.serviceprice from service_provider_details spd inner join user_details ud on \n" +
            "ud.userid = spd.userid \n" +
            "inner join master_servicetype ms on  ms.msertypeid = spd.msertypeid where spd.msertypeid=:msertypeid and spd.servicestatus =1 ", nativeQuery = true)
    List<Map<String, String>> getListServiceProvider(Integer msertypeid);

    @Query(value = "select spd.serviceprice, spd.servicedescription, ud.name as username, ms.name as servicename ,\n" +
            "case when spd.servicestatus =1 then 'Active' else 'InActive' end AS serivceStatus\n" +
            " from service_provider_details spd \n" +
            "inner join master_servicetype ms on spd.msertypeid = ms.msertypeid\n" +
            "inner join user_details ud on \tud.userid = spd.userid \n" +
            "where spd.userid =:userid", nativeQuery = true)
    List<Map<String, String>> getServiceProviderAllDetails(Integer userid);

    @Query(value = "select concat(\"BOOKINGID_\",bd.bookingid) as bookingid,bd.preferredtime ,ud.name as username , ms.name as sevicesname, spd.serviceprice,\n" +
            "case when bd.status = 0 then 'Pending' else 'Completed' end AS serivceStatus,\n" +
            "ud1.name as serviceProvidername\n" +
            " from service_provider_details spd \n" +
            "inner join booking_details bd on bd.serviceproid = spd.serprovierid\n" +
            "inner join user_details ud on ud.userid = bd.userid \n" +
            "inner join user_details ud1 on ud1.userid = spd.userid \n" +
            "inner join master_servicetype ms  on ms.msertypeid = bd.msertypeid\n" +
            "; ",nativeQuery = true)
    List<Map<String, String>> getBookingAllDetailsToAdmin();

    @Query(value = "SELECT ur.name as username , ur.email , ur.phone, ms.name as masterservicename \n" +
            "from service_provider_details sp inner join user_details ur on sp.userid = ur.userid\n" +
            "inner join master_servicetype ms on ms.msertypeid = sp.msertypeid\n" +
            "where sp.servicestatus=1 order by sp.serprovierid desc limit 10 ",nativeQuery = true)
    List<Map<String, String>> getNewServiceProviderDetails();
    @Query(value = "select concat(\"ServicePro_\",spd.serprovierid) as serprovierid,spd.serviceprice, spd.servicedescription, spd.serviceprice,ud.name as username, ms.name as servicename ,\n" +
            "case when spd.servicestatus =1 then 'Active' else 'InActive' end AS serivceStatus\n" +
            " from service_provider_details spd \n" +
            "inner join master_servicetype ms on spd.msertypeid = ms.msertypeid\n" +
            "inner join user_details ud on \tud.userid = spd.userid " +
            " order by spd.serprovierid desc  ", nativeQuery = true)
    List<Map<String, String>> getServiceProviderAllDetailsAdmin();
}