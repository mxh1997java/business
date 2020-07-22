package www.maxinhai.com.businessmodule.feign;

import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.util.Map;

@Component
@Import(FeignClientsConfiguration.class)
public class TrackingFeignClientHandler {

    private TrackingFeignClient trackingFeignClient;

    @Autowired
    public TrackingFeignClientHandler(Decoder decoder, Encoder encoder) {
        trackingFeignClient = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .target(Target.EmptyTarget.create(TrackingFeignClient.class));
    }

    public Map<String, Object> hello(URI baseUri, String name) throws Exception {
        return trackingFeignClient.hello(baseUri,name);
    }

    public Map<String, Object> test(URI baseUri) throws Exception {
        return trackingFeignClient.test(baseUri);
    }

}
