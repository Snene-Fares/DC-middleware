package org.dubaichamber.dcmiddleware.service;

import org.dubaichamber.dcmiddleware.dto.cp.ValuesListRequestDTO;
import org.dubaichamber.dcmiddleware.dto.cp.ValuesListWsRequestDTO;

import java.util.List;

public interface CpService {
    Object valuesList(ValuesListRequestDTO request);

    Object licenseInfo(Object request);

    Object validateAccount(Object request);

    Object serviceFees(Object request);

    Object verifySignature(Object request);

    Object querySvs(Object request);

    Object authCert(Object request);

    Object trueCopy(Object request);
}
