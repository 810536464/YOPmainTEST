import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class DirectWechatTest {

    @Test
    public void signTest() {
        try {
            Map<String, String> result = new HashMap<String, String>();
            String BASE_URL = "https://open.yeepay.com/yop-center";
            //appkey:商户编号
            //secretKey:商户私钥（字符串形式）如果不填，使用src/config下的配置文件内的私钥
            String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCjuhbMeQcPE+7kFeIDRdrg2dAGXrmXGs7Qw3CC/s/aReSnlfDpUiXUvwszx869R467/SQP6YCffx2kR2syps6ZWdXoE+OLhqAeuwDoVW5jl1fJwrpP69zQ5UF8LarYQv60oEnmq29QJq1ESgIIaK9DhhMJVeRR+sDv8eL3pq7Z8DJs3vy9BNCpQ+dKnxWYncGXQZ58MCij2jD2WeJiFziQ7bE8BDn+7bsLZAD06zMwWNsHE2zloI+PHJZCvSlrK9ivfXU2bOp7tgJIfJl4+utYrqjc6GHzuSb04ec551kXsgLzKn4XqywaeEJar4ko3pxj/03+/vIxdKsJtDpQhK49AgMBAAECggEBAIbOrQD00dwXVIZWgj6hoMOsc/0at4L0Hr+DfDtPpUKac9eMvMzPx7hxCL880DvHFH4ywyOa5j3tQzHFYD1XXRqk/lxVK/DxCxvia6/gz8COl0jX3eH6WVliulWNoHLqTp/YrqCQHVoITnfA3AWidFSLq1bvcswRRBUMvA2fH67vJZU7SenPxWQWUzxqeLybmJh3+fY87Sdu6IFDE2gJuXYUnrVMNFMAdi7gxzll97ue6hOBCX4U5sXM6fz4I/DjmVFj/q8sljBt0vG8uOkxIaEX1dcx20hcLUpnG5ypUVUESIyZkNcNOblKNiTVXu8kQtjolO3lfomvBpsoEyAKuOECgYEA34M9LzSpCj65m7P8fczaYf3ngNLEJ9wnZgku5mDU8AMERMZHkpzKv36aXkciCS+srTXlCd9KtuDyiTdSuwxbKKMVnri7pq/+pmjnhVd2wlY9DIGzyPUjcS6NMSR1gVPGW9jT33T/gxzBt8kOds/rpg3OAKi79qE3Sd9QBsD5oKUCgYEAu4ZC5lz3EJ7QE2BCRXrCewZWSQgusnKKUgtUHPeDhw9GfukNxrGhhKZoBN0A6roUvyED+B+1w8FWQNxmg0v4Atf9lk5szgWRCdlLDC4baOrKuvJPAZLotMfLgoeuCW9md5EfTPPB7iiYi+4jVCCtddNtVLAqlgrLDGo4kC9ui7kCgYAFb7G7RjKeVyw4h0Yq4SKmo4BP99Bhj889gher7sr/E3O1IIV5IWslATVL+brwMkKm69qoRNASZqI/iCLw/bnx4RWTiLa3tSwibAbFjX0L+QD/HuB6kMvN4u34NgTNonX+oeV1V+knDToA+Fjrtt7qaQeLqI75zq4Dk/TkVSk9KQKBgCWqtk1nZwkjnVAHCcjC+8WSZEqPJjIZ58bLF74pyXWbj+F2FppOm871TfeMHN8JOZmanB1+4RfNAfJNUxoUbGDF2d4TKq/HVnbP+s8bg83zO32Jpmz+gVeuuiYh8sdaZQ6nS849ODsKVHnm/5mqZq1AJrnYGPXCfT6lJ29u15mhAoGBAKYCL9D/jeuF9olwTpgFfh7tSttBKQSMZ0JXhUork4+2v2Il1pFopLeDVPBhtMA3iO/C+syRCGBqTeGZP8JsH5JlaqI1YmcU1JW29jKY2SoAU2zYPblDmNU6+cnL8YR7at0S2aX/GXvsp/QR/Vlq80tGkqqDDnu4vLz9KTTBj5qr";
            YopRequest request = new YopRequest("OPR:10025518419", privateKey);
            //参数
            request.addParam("identityid", "10025518419");
            request.addParam("serialNo", UUID.randomUUID().toString());
            request.addParam("parentMerchantNo", "10025518419");
            request.addParam("gatewayType", "DIRECT_WECHAT");
            request.addParam("unsignedData", "appid=wx9e13bd68a8f1921e&jsapi_path=https://order.duolabao.com/active/&mch_id=1501264521&sub_mch_id=248012873");
            //arg0:接口的uri（参见手册）
            //arg1:配置好的方法
            YopResponse response = YopClient3.postRsa("/rest/v1.0/new-retail/bank-encryption/sign-data", request);
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void validateTest() {
        try {
            Map<String, String> result = new HashMap<String, String>();
            String BASE_URL = "https://open.yeepay.com/yop-center";
            //appkey:商户编号
            //secretKey:商户私钥（字符串形式）如果不填，使用src/config下的配置文件内的私钥
            String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCjuhbMeQcPE+7kFeIDRdrg2dAGXrmXGs7Qw3CC/s/aReSnlfDpUiXUvwszx869R467/SQP6YCffx2kR2syps6ZWdXoE+OLhqAeuwDoVW5jl1fJwrpP69zQ5UF8LarYQv60oEnmq29QJq1ESgIIaK9DhhMJVeRR+sDv8eL3pq7Z8DJs3vy9BNCpQ+dKnxWYncGXQZ58MCij2jD2WeJiFziQ7bE8BDn+7bsLZAD06zMwWNsHE2zloI+PHJZCvSlrK9ivfXU2bOp7tgJIfJl4+utYrqjc6GHzuSb04ec551kXsgLzKn4XqywaeEJar4ko3pxj/03+/vIxdKsJtDpQhK49AgMBAAECggEBAIbOrQD00dwXVIZWgj6hoMOsc/0at4L0Hr+DfDtPpUKac9eMvMzPx7hxCL880DvHFH4ywyOa5j3tQzHFYD1XXRqk/lxVK/DxCxvia6/gz8COl0jX3eH6WVliulWNoHLqTp/YrqCQHVoITnfA3AWidFSLq1bvcswRRBUMvA2fH67vJZU7SenPxWQWUzxqeLybmJh3+fY87Sdu6IFDE2gJuXYUnrVMNFMAdi7gxzll97ue6hOBCX4U5sXM6fz4I/DjmVFj/q8sljBt0vG8uOkxIaEX1dcx20hcLUpnG5ypUVUESIyZkNcNOblKNiTVXu8kQtjolO3lfomvBpsoEyAKuOECgYEA34M9LzSpCj65m7P8fczaYf3ngNLEJ9wnZgku5mDU8AMERMZHkpzKv36aXkciCS+srTXlCd9KtuDyiTdSuwxbKKMVnri7pq/+pmjnhVd2wlY9DIGzyPUjcS6NMSR1gVPGW9jT33T/gxzBt8kOds/rpg3OAKi79qE3Sd9QBsD5oKUCgYEAu4ZC5lz3EJ7QE2BCRXrCewZWSQgusnKKUgtUHPeDhw9GfukNxrGhhKZoBN0A6roUvyED+B+1w8FWQNxmg0v4Atf9lk5szgWRCdlLDC4baOrKuvJPAZLotMfLgoeuCW9md5EfTPPB7iiYi+4jVCCtddNtVLAqlgrLDGo4kC9ui7kCgYAFb7G7RjKeVyw4h0Yq4SKmo4BP99Bhj889gher7sr/E3O1IIV5IWslATVL+brwMkKm69qoRNASZqI/iCLw/bnx4RWTiLa3tSwibAbFjX0L+QD/HuB6kMvN4u34NgTNonX+oeV1V+knDToA+Fjrtt7qaQeLqI75zq4Dk/TkVSk9KQKBgCWqtk1nZwkjnVAHCcjC+8WSZEqPJjIZ58bLF74pyXWbj+F2FppOm871TfeMHN8JOZmanB1+4RfNAfJNUxoUbGDF2d4TKq/HVnbP+s8bg83zO32Jpmz+gVeuuiYh8sdaZQ6nS849ODsKVHnm/5mqZq1AJrnYGPXCfT6lJ29u15mhAoGBAKYCL9D/jeuF9olwTpgFfh7tSttBKQSMZ0JXhUork4+2v2Il1pFopLeDVPBhtMA3iO/C+syRCGBqTeGZP8JsH5JlaqI1YmcU1JW29jKY2SoAU2zYPblDmNU6+cnL8YR7at0S2aX/GXvsp/QR/Vlq80tGkqqDDnu4vLz9KTTBj5qr";
            YopRequest request = new YopRequest("OPR:10025518419", privateKey);
            //参数
            request.addParam("identityid", "10025518419");
            request.addParam("serialNo", UUID.randomUUID().toString());
            request.addParam("parentMerchantNo", "10025518419");
            request.addParam("gatewayType", "DIRECT_WECHAT");
            request.addParam("signedData", "<xml> <return_code><![CDATA[SUCCESS]]></return_code> <return_msg><![CDATA[OK]]></return_msg> <result_code><![CDATA[FAIL]]></result_code> <sign><![CDATA[408AF238357E757D57F0B3F13F90915F]]></sign> <err_code><![CDATA[INVALID_REQUEST]]></err_code> <err_code_des><![CDATA[公众号支付支付域名已存在，请勿重复配置]]></err_code_des> </xml>");
            //arg0:接口的uri（参见手册）
            //arg1:配置好的方法
            YopResponse response = YopClient3.postRsa("/rest/v1.0/new-retail/bank-encryption/validate-data", request);
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
