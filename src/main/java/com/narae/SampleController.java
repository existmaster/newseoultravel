package com.narae;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by existmaster on 2016. 6. 12..
 */
@Component
@Path("/sample")
public class SampleController {

    @GET
    @Produces("application/json")
    public Sample sample() {
        return new Sample("sample");
    }
}
