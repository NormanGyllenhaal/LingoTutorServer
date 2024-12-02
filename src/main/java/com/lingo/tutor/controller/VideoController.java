package com.lingo.tutor.controller;

import com.lingo.tutor.util.RtcTokenBuilder2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Value("${agora.app.id}")
    private String appId;

    @Value("${agora.app.certificate}")
    private String appCertificate;

    @GetMapping
    public Map<String,String> getToken(@RequestParam("id") Integer id,
                                       @RequestParam(name = "channel") String channel) {
        RtcTokenBuilder2 token = new RtcTokenBuilder2();
        String string = token.buildTokenWithUid(appId, appCertificate,
                channel, id, RtcTokenBuilder2.Role.ROLE_PUBLISHER, 86400, 86400);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", string);
        return map;
    }

}
