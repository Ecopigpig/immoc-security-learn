package com.imooc.web.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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
        WireMock.configureFor(8062);
        WireMock.removeAllMappings();
        mock("/order/1","01");
        mock("/order/2","02");

    }

    private static void mock(String url,String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource("/resources/mock/resource/"+fileName+".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(),"UTF-8").toArray(),"\n");
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo(url))
                .willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }
}
