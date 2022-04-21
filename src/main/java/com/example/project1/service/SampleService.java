package com.example.project1.service;

import com.example.project1.config.SampleClient;
import com.example.project1.dto.*;
import com.example.project1.entity.TblSample;
import com.example.project1.exception.DataNotFoundException;
import com.example.project1.repository.SampleRepository;
import com.example.project1.util.ResponseUtil;
import com.google.gson.internal.LinkedTreeMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;
    private final SampleClient sampleClient;

    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    @Transactional
    public BaseResponse addData(AddDataSampleReq req) throws Exception {
        log.info("Start service addData sample");
        TblSample sample = new TblSample();
        sample.setId(System.currentTimeMillis());
        sample.setAddress(req.getAddress());
        sample.setDob(date.parse(req.getDob()));
        sample.setName(req.getName());
        sample.setGender(req.getGender());
        sample.setCreateDate(new Date());
        sampleRepository.save(sample);
        return ResponseUtil.setResponse("success", sample);
    }

    public BaseResponse getDataByNameDob(GetDataSampleReq req) throws Exception{
        log.info("Start service getDataByNameDob");
        GetDataSampleResp resp = new GetDataSampleResp();

        TblSample sample = sampleRepository.findByNameAndDob(req.getName(), req.getDob());
        if(sample == null){
            throw new DataNotFoundException("Data tidak ditemukan");
        }
        resp.setDob(sample.getDob().toString());
        resp.setAddress(sample.getAddress());
        resp.setGender(sample.getGender());
        resp.setName(sample.getName());

        return ResponseUtil.setResponse("success", resp);
    }

    public BaseResponse testMitraPost(GedDataByPostReq req) throws Exception{
        log.info("Stasrt service testMitraPost");
        MitraPostReq mitraRequest = new MitraPostReq();
        mitraRequest.setAddress(req.getAlamat());
        mitraRequest.setDob(req.getTglLahir());
        mitraRequest.setName(req.getNama());
        mitraRequest.setGender(req.getJenisKelamin());

        LinkedTreeMap response = sampleClient.getDataByPost(mitraRequest);
        if(response.get("statu").toString().equals("00")){
            return ResponseUtil.setResponse("success", response.get("data"));
        }
        return ResponseUtil.setResponse("failed", "data not found");
    }

    public BaseResponse testMitraGet(String name) throws Exception{
        log.info("Start service testMItraGet");
        LinkedTreeMap response = sampleClient.getDataByGet(name);
        if(response.get("statu").toString().equals("00")){
            return ResponseUtil.setResponse("success", response.get("data"));
        }
        return ResponseUtil.setResponse("failed", "data not found");
    }

}
