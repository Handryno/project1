package com.example.project1.config;

import com.example.project1.dto.MitraPostReq;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="switching-client", url="${sample.base.url}", configuration = SampleConfiguration.class)
public interface SampleClient {

    @PostMapping(value="sample/inquiry/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    LinkedTreeMap getDataByPost(@RequestBody MitraPostReq req) throws Exception;

    @GetMapping(value="/sample/inquiry/get/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    LinkedTreeMap getDataByGet(@PathVariable String name) throws Exception;
}