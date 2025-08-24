package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.CpClient;
import org.dubaichamber.dcmiddleware.dto.cp.ValuesListRequestDTO;
import org.dubaichamber.dcmiddleware.dto.cp.ValuesListWsRequestDTO;
import org.dubaichamber.dcmiddleware.mapper.CpMapper;
import org.dubaichamber.dcmiddleware.service.CpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CpServiceImpl implements CpService {
    private final CpClient cpClient;
    private final CpMapper cpMapper;

    @Override
    public Object valuesList(ValuesListRequestDTO request) {
        return cpClient.valuesList(cpMapper.mapValuesListRequest(request));
    }

    @Override
    public Object licenseInfo(Object request) {
        return cpClient.licenseInfo(request);
    }

    @Override
    public Object validateAccount(Object request) {
        return cpClient.validateAccount(request);
    }

    @Override
    public Object serviceFees(Object request) {
        return cpClient.serviceFees(request);
    }

    @Override
    public Object verifySignature(Object request) {
        return cpClient.verifySignature(request);
    }

    @Override
    public Object querySvs(Object request) {
        return cpClient.querySvs(request);
    }

    @Override
    public Object authCert(Object request) {
        return cpClient.authCert(request);
    }

    @Override
    public Object trueCopy(Object request) {
        return cpClient.trueCopy(request);
    }
}
