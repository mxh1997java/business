package www.maxinhai.com.businessmodule.feign;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.Map;

@FeignClient("SERVICE-TRACKING")
public interface TrackingFeignClient {

    @RequestLine("GET")
    @RequestMapping(value = "http://localhost:10001/tracking/hello", method = RequestMethod.GET)
    Map<String, Object> hello(URI baseUri, @RequestParam("name") String name) throws Exception;

}
