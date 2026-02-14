/*
package com.nishant.ctplbackend.aspect;


import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CtplInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> ctplBackend = new HashMap<>();
        ctplBackend.put("App Name", "CTPL Backend");
        ctplBackend.put("App Description", "Backend of the CTPL application.");
        ctplBackend.put("App Version", "1.0.0");
        ctplBackend.put("Contact Email", "Ctpl@gmail.com");
        ctplBackend.put("Contact Mobile", "+9777");
        builder.withDetail("ctpl-backend-info", ctplBackend);
    }
}
*/
