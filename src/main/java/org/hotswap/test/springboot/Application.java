package org.hotswap.test.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private Statistics statistics;

    @RequestMapping("/simple")
    public String home() {
        //statistics.updateStatistic(0);
        return "ok";
    }

    @RequestMapping("/statistic")
    public Map<String, Object> getStatistic() {
    	Map<String, Object> map = new HashMap<>();
        map.put("total_requests", String.valueOf(statistics.getTotalRequests()));
        map.put("total_nanos", statistics.getTotalNanos());
        map.put("avg_throughput", statistics.getAvgThroughput());
        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
