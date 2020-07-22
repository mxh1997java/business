package www.maxinhai.com.businessshare.appservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import www.maxinhai.com.businessshare.appservice.callback.HelloServiceCallBack;
import java.util.Map;

@FeignClient(value = "business", fallback = HelloServiceCallBack.class)
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> hello(String name) throws Exception;

}
