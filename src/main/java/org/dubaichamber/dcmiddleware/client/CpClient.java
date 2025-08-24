package org.dubaichamber.dcmiddleware.client;

import org.dubaichamber.dcmiddleware.client.config.AuthClientConfig;
import org.dubaichamber.dcmiddleware.client.config.CommonClientConfig;
import org.dubaichamber.dcmiddleware.client.config.CpClientConfig;
import org.dubaichamber.dcmiddleware.dto.cp.ValuesListWsRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "cp-client", url = "${rest-ws.cp-services.base-url}" ,
        configuration = {CommonClientConfig.class, CpClientConfig.class }
)
public interface CpClient {

    @PostMapping("${rest-ws.cp-services.list-values.url}")
    Object valuesList(@RequestBody ValuesListWsRequestDTO request);

    @PostMapping("${rest-ws.cp-services.license-info.url}")
    Object licenseInfo(@RequestBody Object request);

    @PostMapping("${rest-ws.cp-services.validate-member-license.url}")
    Object validateAccount(@RequestBody Object request);

    @PostMapping("${rest-ws.cp-services.get-srs-services-fees.url}")
    Object serviceFees(@RequestBody Object request);

    @PostMapping("${rest-ws.cp-services.verify-signature.url}")
    Object verifySignature(@RequestBody Object request);

    @PostMapping("${rest-ws.cp-services.query-svs.url}")
    Object querySvs(@RequestBody Object request);

    @PostMapping("${rest-ws.cp-services.auth-cert.url}")
    Object authCert(@RequestBody Object request);

    @PostMapping("${rest-ws.cp-services.true-copy.url}")
    Object trueCopy(@RequestBody Object request);
}
