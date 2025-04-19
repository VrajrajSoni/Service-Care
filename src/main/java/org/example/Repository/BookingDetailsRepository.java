package org.example.Repository;

import org.example.Entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
    @Query(value = "SELECT \n" +
            "    CONCAT('BOOKINGID_', bd.bookingid) AS booking_id,\n" +
            "    mst.name AS service_name,bd.bookingid,mst.msertypeid as servicetypid ,\n" +
            "    ud1.name AS service_provider_name,\n" +
            "    CASE \n" +
            "        WHEN bd.status = 0 THEN 'Pending'\n" +
            "        WHEN bd.status = 1 THEN 'Completed'\n" +
            "        ELSE 'In progress'\n" +
            "    END AS status\n" +
            "FROM \n" +
            "    booking_details bd\n" +
            "INNER JOIN \n" +
            "    user_details ud ON ud.userid = bd.userid\n" +
            "INNER JOIN \n" +
            "    service_provider_details spd ON spd.serprovierid = bd.serviceproid\n" +
            "INNER JOIN \n" +
            "    user_details ud1 ON ud1.userid = spd.userid\n" +
            "INNER JOIN \n" +
            "    master_servicetype mst ON mst.msertypeid = bd.msertypeid\n" +
            "WHERE \n" +
            "    bd.userid =:userid ", nativeQuery = true)
    List<Map<String, String>> getALLClientServices(Integer userid);

    @Query(value = "select concat(\"BOOKINGID_\",bd.bookingid) as bookingid,bd.bookingid as id, bd.preferredtime ,ud.name as username , ms.name as sevicesname, spd.serviceprice,\n" +
            "case when bd.status = 0 then 'Pending' " +
            " when bd.status = 1 then 'Completed' " +
            "  else 'In Progress' end AS serivceStatus\n" +
            " from service_provider_details spd \n" +
            "inner join booking_details bd on bd.serviceproid = spd.serprovierid\n" +
            "inner join user_details ud on ud.userid = bd.userid \n" +
            "inner join master_servicetype ms  on ms.msertypeid = bd.msertypeid\n" +
            "where spd.userid =:userid ",nativeQuery = true)
    List<Map<String, String>> getAllReceivedServiceSetProvider(Integer userid);

    BookingDetails findByBookingid(Integer bokkingid);

    @Query(value = "select concat(\"BOOKINGID_\",bd.bookingid) as bookingid,bd.preferredtime ,ud.name as username , ms.name as sevicesname, spd.serviceprice,\n" +
            "case when bd.status = 0 then 'Pending'" +
            " when bd.status = 1 then 'Completed' " +
            "  else 'In Progress' end AS serivceStatus,\n" +
            " ud1.name as serviceProvidername , ud.name from booking_details bd\n" +
            " inner join user_details ud on ud.userid = bd.userid\n" +
            " inner join master_servicetype ms on ms.msertypeid = bd.msertypeid\n" +
            " inner join service_provider_details spd on spd.serprovierid = bd.serviceproid\n" +
            " inner join user_details ud1  on spd.userid = ud1.userid;",nativeQuery = true)
    List<Map<String, String>> adminGetAllBooking();

    @Query(value = "select concat(\"BOOKINGID_\",spd.serprovierid) as serprovierid, spd.serviceprice, spd.servicedescription, ud.name as username, ms.name as servicename ,\n" +
            "case when spd.servicestatus =1 then 'Active' else 'InActive' end AS serivceStatus\n" +
            " from service_provider_details spd \n" +
            " inner join master_servicetype ms on spd.msertypeid = ms.msertypeid\n" +
            " inner join user_details ud on \tud.userid = spd.userid ",nativeQuery = true)
    List<Map<String, String>> adminGetAllServices();

    @Query(value = "SELECT concat(\"Payment from #\",bookingid) as paymentid , updatedon , spd.serviceprice ,\n" +
            " case when 1 then 'Completed'  " +
            " when 0  then 'Pending' " +
            " else 'In Progress' end as status\n" +
            "from booking_details bd inner join service_provider_details spd on spd.serprovierid = bd.serviceproid\n" +
            "where bd.status=1 order by bd.bookingid desc limit 10",nativeQuery = true)
    List<Map<String, String>> getPaymentDeoneALlDetails();

    @Query(value = "SELECT \n" +
            "  COUNT(bd.bookingid) AS monthlyBookings,\n" +
            "  SUM(sp.serviceprice) AS monthlyAmount\n" +
            "FROM \n" +
            "  booking_details bd\n" +
            "INNER JOIN  \n" +
            "  service_provider_details sp  \n" +
            "  ON sp.serprovierid = bd.serviceproid\n" +
            "WHERE \n" +
            "  MONTH(bd.createdon) = MONTH(CURRENT_DATE())\n" +
            "  AND YEAR(bd.createdon) = YEAR(CURRENT_DATE())",nativeQuery = true)
    Map<String,String> getMonthlyDetails();

    @Query(value = "SELECT \n" +
            "  COUNT(bd.bookingid) AS totalBookings,\n" +
            "  SUM(sp.serviceprice) AS totalAmount\n" +
            "FROM \n" +
            "  booking_details bd\n" +
            "INNER JOIN  \n" +
            "  service_provider_details sp  \n" +
            "  ON sp.serprovierid = bd.serviceproid\n",nativeQuery = true)
    Map<String,String> getTotalDetails();

    @Query(value = "select concat(\"BOOKINGID_\",bd.bookingid) as bookingid,bd.preferredtime ,ud.name as username , ms.name as sevicesname, spd.serviceprice,\n" +
            "case when bd.status = 0 then 'Pending' " +
            "   when bd.status = 1 then 'Completed' " +
            " else 'In Progress' end AS serivceStatus,\n" +
            " ud1.name as serviceProvidername , ud.name from booking_details bd\n" +
            " inner join user_details ud on ud.userid = bd.userid\n" +
            " inner join master_servicetype ms on ms.msertypeid = bd.msertypeid\n" +
            " inner join service_provider_details spd on spd.serprovierid = bd.serviceproid\n" +
            " inner join user_details ud1  on spd.userid = ud1.userid and bd.status=1 " +
            " order by bd.bookingid desc ;",nativeQuery = true)
    List<Map<String, String>> adminGetAllAcceptBooking();

    @Query(value = "select concat(\"BOOKINGID_\",bd.bookingid) as bookingid,bd.preferredtime ,ud.name as username , ms.name as sevicesname, spd.serviceprice,\n" +
            "case when bd.status = 0 then 'Pending' " +
            " when bd.status = 1 then 'Completed' " +
            "   else 'In Progress' end AS serivceStatus, " +
            " ud1.name as serviceProvidername , ud.name from booking_details bd\n" +
            " inner join user_details ud on ud.userid = bd.userid\n" +
            " inner join master_servicetype ms on ms.msertypeid = bd.msertypeid\n" +
            " inner join service_provider_details spd on spd.serprovierid = bd.serviceproid\n" +
            " inner join user_details ud1  on spd.userid = ud1.userid and bd.status in (0,2) " +
            " order by bd.bookingid desc ;",nativeQuery = true)
    List<Map<String, String>>   adminGetAllPendingBooking();

    @Query(value =
            "SELECT DATE_FORMAT(preferredtime, '%Y-%m') AS month,SUM(spd.serviceprice) as income, COUNT(*) AS total_orders FROM booking_details bd\n" +
            "inner join service_provider_details spd on spd.serprovierid = bd.serviceproid \n" +
            "GROUP BY month ORDER BY month; ",nativeQuery = true)
    List<Map<String, String>> adminBookingChart();


}