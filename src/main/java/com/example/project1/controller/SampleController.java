package com.example.project1.controller;

import com.example.project1.dto.AddDataSampleReq;
import com.example.project1.dto.BaseResponse;
import com.example.project1.dto.GedDataByPostReq;
import com.example.project1.dto.GetDataSampleReq;
import com.example.project1.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/sample")
public class SampleController {
    private final SampleService sampleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse addData(@RequestBody AddDataSampleReq req, BindingResult result) throws Exception {
        return sampleService.addData(req);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse getData(@RequestBody GetDataSampleReq req, BindingResult result) throws Exception {
        return sampleService.getDataByNameDob(req);
    }

    @PostMapping(value = "/mitra/post", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse mitraPost(@RequestBody GedDataByPostReq req, BindingResult result) throws Exception{
        return sampleService.testMitraPost(req);
    }

    @GetMapping(value = "mitra/get/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse mitraGet(@PathVariable String name, BindingResult result) throws Exception {
        return sampleService.testMitraGet(name);
    }


}
