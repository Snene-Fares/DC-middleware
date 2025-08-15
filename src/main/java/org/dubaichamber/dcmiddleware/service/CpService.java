package org.dubaichamber.dcmiddleware.service;

import java.util.List;

public interface CpService {
    List<Object> valuesList(Object request);

    Object licenseInfo(Object request);

    Object validateAccount(Object request);

    Object serviceFees(Object request);

    Object verifySignature(Object request);

    Object querySvs(Object request);

    Object authCert(Object request);

    Object trueCopy(Object request);
}
