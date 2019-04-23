package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String port;
    String memorylimit;
    String index;
    String address;

    public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory.limit:NOT SET}") String memorylimit, @Value("${cf.instance.index:NOT SET}")String index, @Value("${cf.instance.addr:NOT SET}")String address) {

        this.port = port;
        this.memorylimit = memorylimit;
        this.index = index;
        this.address = address;
    }

    @GetMapping("/env")
    public Map<String,String> getEnv(){
          Map<String, String> env = new HashMap<>();


          env.put("PORT", this.port);
        env.put("MEMORY_LIMIT", this.memorylimit);
        env.put("CF_INSTANCE_INDEX", this.index);
        env.put("CF_INSTANCE_ADDR", this.address);


          return env;
    }

}
