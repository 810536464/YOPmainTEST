import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class UnionPayAlipayTest {

	@Test
	public void signTest() {
		try {
			Map<String, String> result = new HashMap<String, String>();
			String BASE_URL = "https://open.yeepay.com/yop-center";
			//appkey:商户编号
			//secretKey:商户私钥（字符串形式）如果不填，使用src/config下的配置文件内的私钥
			String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCjuhbMeQcPE+7kFeIDRdrg2dAGXrmXGs7Qw3CC/s/aReSnlfDpUiXUvwszx869R467/SQP6YCffx2kR2syps6ZWdXoE+OLhqAeuwDoVW5jl1fJwrpP69zQ5UF8LarYQv60oEnmq29QJq1ESgIIaK9DhhMJVeRR+sDv8eL3pq7Z8DJs3vy9BNCpQ+dKnxWYncGXQZ58MCij2jD2WeJiFziQ7bE8BDn+7bsLZAD06zMwWNsHE2zloI+PHJZCvSlrK9ivfXU2bOp7tgJIfJl4+utYrqjc6GHzuSb04ec551kXsgLzKn4XqywaeEJar4ko3pxj/03+/vIxdKsJtDpQhK49AgMBAAECggEBAIbOrQD00dwXVIZWgj6hoMOsc/0at4L0Hr+DfDtPpUKac9eMvMzPx7hxCL880DvHFH4ywyOa5j3tQzHFYD1XXRqk/lxVK/DxCxvia6/gz8COl0jX3eH6WVliulWNoHLqTp/YrqCQHVoITnfA3AWidFSLq1bvcswRRBUMvA2fH67vJZU7SenPxWQWUzxqeLybmJh3+fY87Sdu6IFDE2gJuXYUnrVMNFMAdi7gxzll97ue6hOBCX4U5sXM6fz4I/DjmVFj/q8sljBt0vG8uOkxIaEX1dcx20hcLUpnG5ypUVUESIyZkNcNOblKNiTVXu8kQtjolO3lfomvBpsoEyAKuOECgYEA34M9LzSpCj65m7P8fczaYf3ngNLEJ9wnZgku5mDU8AMERMZHkpzKv36aXkciCS+srTXlCd9KtuDyiTdSuwxbKKMVnri7pq/+pmjnhVd2wlY9DIGzyPUjcS6NMSR1gVPGW9jT33T/gxzBt8kOds/rpg3OAKi79qE3Sd9QBsD5oKUCgYEAu4ZC5lz3EJ7QE2BCRXrCewZWSQgusnKKUgtUHPeDhw9GfukNxrGhhKZoBN0A6roUvyED+B+1w8FWQNxmg0v4Atf9lk5szgWRCdlLDC4baOrKuvJPAZLotMfLgoeuCW9md5EfTPPB7iiYi+4jVCCtddNtVLAqlgrLDGo4kC9ui7kCgYAFb7G7RjKeVyw4h0Yq4SKmo4BP99Bhj889gher7sr/E3O1IIV5IWslATVL+brwMkKm69qoRNASZqI/iCLw/bnx4RWTiLa3tSwibAbFjX0L+QD/HuB6kMvN4u34NgTNonX+oeV1V+knDToA+Fjrtt7qaQeLqI75zq4Dk/TkVSk9KQKBgCWqtk1nZwkjnVAHCcjC+8WSZEqPJjIZ58bLF74pyXWbj+F2FppOm871TfeMHN8JOZmanB1+4RfNAfJNUxoUbGDF2d4TKq/HVnbP+s8bg83zO32Jpmz+gVeuuiYh8sdaZQ6nS849ODsKVHnm/5mqZq1AJrnYGPXCfT6lJ29u15mhAoGBAKYCL9D/jeuF9olwTpgFfh7tSttBKQSMZ0JXhUork4+2v2Il1pFopLeDVPBhtMA3iO/C+syRCGBqTeGZP8JsH5JlaqI1YmcU1JW29jKY2SoAU2zYPblDmNU6+cnL8YR7at0S2aX/GXvsp/QR/Vlq80tGkqqDDnu4vLz9KTTBj5qr";
			YopRequest request = new YopRequest("OPR:10025150614", privateKey);
			//参数
			request.addParam("identityid", "10025150614");
			request.addParam("serialNo", UUID.randomUUID().toString());
			request.addParam("parentMerchantNo", "10025150614");
			request.addParam("gatewayType", "UP_ALIPAY");
			request.addParam("unsignedData", "app_id=1266000048250000&biz_content={\"out_trade_no\":\"5362311657181018\"}&charset=utf-8&format=JSON&method=alipay.trade.query&sign_type=RSA2&timestamp=2018-10-18 21:27:56&version=1.0");
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
			YopRequest request = new YopRequest("OPR:10025150614", privateKey);
			//参数
			request.addParam("identityid", "10025150614");
			request.addParam("serialNo", UUID.randomUUID().toString());
			request.addParam("parentMerchantNo", "10025150614");
			request.addParam("gatewayType", "UP_ALIPAY");
			request.addParam("signedData", "{\"alipay_trade_query_response\":{\"msg\":\"Success\",\"code\":\"10000\",\"buyer_user_id\":\"2088422794209184\",\"invoice_amount\":\"0.00\",\"out_trade_no\":\"5362311657181018\",\"total_amount\":\"5.00\",\"trade_status\":\"WAIT_BUYER_PAY\",\"trade_no\":\"122018101822001409185400029383\",\"buyer_logon_id\":\"150****9920\",\"receipt_amount\":\"0.00\",\"point_amount\":\"0.00\",\"buyer_pay_amount\":\"0.00\"},\"sign\":\"FRlbtPE6nHYLulTT1RlEcwT3g8dEpdbNBg3N4abNDahUJ2hYMG4ZMwmjcjmE9l4kwneMUc2D7ShICGCSUJYqQew6i7LYZbUWdUJB6NUEt5gO3/tMXRWqzh2Y4nOe/1bgwibVWDFYyZruS6hZ60H1Lqf8eqUBPeYdjwpRpYN0BMeV/vvtd65EjzZRxTjj2JBrVIH7utjbMyieZ57bc9Q0ZVrDbYSUUpI2mZjgeLfxYMG6oxNmQUyekqvnh+lxBtoLkfSIDmiALBo0LUyBfaHDT71bTvAdD0PPDTNredoMbo9iL5tDubj1K/mK/bT2h0pNCnqHolhBCXo4n3xpfO9EZQ==\"}");
			request.addParam("requestMethod", "alipay.trade.query");
			//request.addParam("requestMethod", "alipay_trade_query");
			//arg0:接口的uri（参见手册）
			//arg1:配置好的方法
			YopResponse response = YopClient3.postRsa("/rest/v1.0/new-retail/bank-encryption/validate-data", request);
			System.out.println(response.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
