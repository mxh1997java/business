package www.maxinhai.com.businessmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import www.maxinhai.com.businessmodule.feign.TrackingFeignClientHandler;
import www.maxinhai.com.businessshare.appservice.HelloService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "business")
@RestController
public class HelloController implements HelloService {

    @Autowired
    private TrackingFeignClientHandler trackingFeignClientHandler;

    @RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = "application/json")
    @Override
    public Map<String, Object> hello(String name) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "business模块");
        result.put("success", true);
        result.put("code", 200);
        return result;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() throws Exception {
        Map<String, Object> map = trackingFeignClientHandler.hello(new URI("http://127.0.0.1:10001/tracking/hello"), "maxinhai");
        System.out.println(map.toString());
    }

}
