package com.imooc.web.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @program: immoc-security-learn
 * @description: Mock服务器
 * @author: linxinting
 * @create: 2020-11-25 17:40
 **/
public class MockServer {
    public static void main(String[] args) throws IOException {
        //指定已经启动完毕的wireMock.jar包的端口
        WireMock.configureFor(9090);
        WireMock.removeAllMappings();
        ClassPathResource resource = new ClassPathResource("/mock/resource/01.txt");
        String content = FileUtils.readFileToString(resource.getFile());
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/order/1"))
                .willReturn(WireMock.aResponse().withBody("{\"id\":1}").withStatus(200)));
    }
}
