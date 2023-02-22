package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utils.DBUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class question02StepDefs {

   private static int count = 0;

    @Given("{string} {string} {string} should match with the result")
    public void should_match_with_the_result(String month_name, String full_name, String total_amount) {
        String query = "SELECT TO_CHAR(payment_date,'Month') AS month_name,CONCAT(s.first_name,' ',s.last_name) AS full_name,\n" +
                "SUM(amount) AS total_amount\n" +
                "FROM payment p\n" +
                "JOIN staff s ON p.staff_id=s.staff_id\n" +
                "GROUP BY EXTRACT(MONTH FROM payment_date), p.staff_id, TO_CHAR(payment_date, 'Month'),CONCAT(s.first_name,' ',s.last_name)\n" +
                "ORDER BY EXTRACT(MONTH FROM payment_date)";

        List<Map<String, Object>> resultMap = DBUtils.getQueryResultMap(query);
        Map<String,Object> map=resultMap.get(count++);
        Assert.assertEquals(map.get("month_name").toString().trim(),month_name);
        Assert.assertEquals(map.get("full_name").toString().trim(),full_name);
        Assert.assertEquals(map.get("total_amount").toString().trim(),total_amount);

        System.out.println("---------------------------------------");
        System.out.println(map.get("month_name").toString().trim());
        System.out.println(map.get("full_name").toString().trim());
        System.out.println(map.get("total_amount").toString().trim());
        System.out.println("---------------------------------------");
    }

}
