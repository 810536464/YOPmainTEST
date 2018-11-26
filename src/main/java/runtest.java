import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.g3.sdk.yop.utils.InternalConfig;



public class runtest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> result = new HashMap<String, String>();
		String BASE_URL = "https://open.yeepay.com/yop-center";
		
		
		
		//appkey:商户编号
		//secretKey:商户私钥（字符串形式）如果不填，使用src/config下的配置文件内的私钥
		//String privatekey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDCC2oVe6OYd8ZtuhW9AN8wV9bat5wz3rva5H8iPAv99VQkORANnh6l+a7RNVfN9w+Yii6UeavhSsulgicDUngJdCHaPIsuXRWt26ejSsLeHmxXnWPG2AObZcnyYzUzwZ4MiAWJ6RcRrF7BZGpAPkBGK0kLBeZ9e8Ko8SgRUXzVHmPjg8oF5vV0xMNDj92X0oZBVfzt0rOSqlGVWWgRkgIBz6CZKiy9pmLnKOnpG5qOOdiTdth+DsAR7ABK4lzkPeesAsR1VzP4EqW/TKC64YKhMA3N1ovfMC9EpQ2oCPwvairAsQcB/pvXxHBXttF/BTrTw/Ks9tkh2QMRBvZGHpfAgMBAAECggEABr/1GibTEyKXi4uQjGolg9eyQdNPgiAuBQdVjdzAAriRlITiPSyRKD+K8zqogy8teUk1L+PoLkJ95vhzmRZWJ+XKyC7vyr4C8DSizigXf4/FNQ3YoHaYjCW5E6OeTZgcjTSH0pxYKyi5G809o6cZLKVIxgQ/cv7oQXQOPPNUlyQ/aBl1c1cSDAWbyX7BDduqZmk5BPnyud9vtEOuKAQqFwPfy3/ZfkibilUYcvtNqRSUl/7VinZeAisSXPbKre2qk5ll/YXeavxkBZxdq6/JS5O4ivBtrQy9Fnil+7hBe6Qfw4Lt7Fv5NdObJIVwzq7cMTHGxnUaf3MNRpdkHvJsgQKBgQDrPt7vI5BuMvzM6wILXnxQ76quYPFE9nJ1glYPCpCAirKP5kAEjmH/2mJ4IqTi2uT5pgoPb0zGspL7R1tsJcSgGa98qEgyeG1n+6C9M2a+vmht8VTj0nrZeIIigQH2dF16K8c87H1jgg0N5VrjG+pRKG23dQ0rX4O0B+3MoHUN3QKBgQCOl5hCO2OVvillvvk0Wabll3ytWYZZRN/4COWtDaXY10RkpeBRyDZvAUE9Gyi/ZegfvTfZzV5gPnVFtXqbIEY8u0xD4MQSAuncY4V16cv70cvu4u3xGEZKgzgk8TOfPNxInCWUles6lP451x5B3HIAa63Ii1j3Qd0ceuI8iqT7awKBgQCh8M7Q+r+DTPBANItcvjeAE+yATFXqrmjOweFyS0h8ZH5VlyB8wnNuCKz+nIK7dApqXUXRqEHHCskp1850nW9E80md286Ph91w1oSpmkfhiPwkqxxQFOXi7RVQoVRzj1mGL7rhEr+ij7Vi2n99lgrwwY792sMtF3x3o3mtAsxxtQKBgAf5YFFr4tDP9p6zBFqyHMxAIX/MPuAlIuVLEhUQa1LqDvAV+qp4KNsiVdSl/Sxe9ZE40rPCcWGufH5ufLHKJ0NkMgqlujFLqmphwmfqsDaf7+inFilicyPdnLksJ/fivmrtGIjrrWD0ThdL+WwzeMifPPO3Hz2MmGHsWVSLaFiLAoGBANL7mp+y+J9Olx9LPjR14lanOg4PhnhIJ/CQt41WWgkEbSXfign0LaYwJQ2ly6y8KoaVPN/VeICTQ9RXsvIAwUmy0YB4hvRS6kfsdsP+9MWMooecsnsz+fUgY+Ff6pJL3dhnr0cPqiB0J0xH2gMD80i9QFUfaWAmLD7KvB1y3XA4";
		String SQKKkey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCrS0KstpuJs75jrO2Tc7x5WfeQ8ER1tPr34OPiJfETinvTQeNzZc13V1Wm+yhk5Xsv4OWuSHCok5MwhEgc4cb03loTcS4pqAHL4u13hEycf+fTkoIQ88IpmFMcnu0l3dYqzj34fEgH7EN4byCDDd9cNtZWuzA9iitwJuoCjx4sJqxvftxPQV6gbPZEwIWPw3i1ALG8LgKDRiB/i8hw4PfRCGrYtwjOjwKsiEetxNUpROs8nUSpRBQnr8G1Z85sN6wH83eH3y2uJ4O4G/Eao3FG8rHVWPIiQaXtyFqFx8B3pFAwqYuxWaciInlNPTLMd1Ee+BDqQ9FN/tzy/q5CSTevAgMBAAECggEBAJiAYbT4wpMfNrLxI3ayhKsZgQJGFv0gioujad9OXkpCcamMsJ5tlTbZx0TpuHXTpQ/kTzgSAFLlSBbavoUQMZySVWmXyzyE+kx2FWrhm399lHzVo/zJuCRmHCCQEZwz21ey1JNkupBrNUqEzVJASIqFu9/tua4gVDn+OzraBkfREWV9E6CmQ0xl7SNz9awWpg/8zTqLMsXSR3Q6+ezd5vHZTZvkG5sLh2cKgylZoZawJgrGpW5mt+nXlPhvXmW6XcX730DWNvTgIOtduDZ0Ig5JEya8V9XC+1OcHAkpXXMG2ohABZtIKKS4yLWSwgCFErgVyien5T2kdEIGPbnE55ECgYEA88r2DHhssH9fSIzHo6yL3VMit30Qs6fjxmQXcqxewYtk11yPpn2ROaGBYitzsv/kgVLECRsfIREGsUjPqz7Al8NpgqoQEf27zWaf6x59cs3g2vB6rtilvng8C3dnSFjKZQ/tbXv/QHDz/A549rwm4fO689ptjegS3zcAaptF7okCgYEAs976k3NCpln7FzGKtMrMk5my/ed8Dj70cntxdwNBcsOhbbh1HbCsn2F/PLdqd6bJc+Qdi7hIGecUZ/6/CuEDY/8jZqm9b6B4vnxZFBTUyqHcL8cXmMUDi9p7SoSsCZ92RCD0x4SbOjhym7yuvw14gk+hlBSvWuC+YhEMRlinJncCgYBJ+12Pizvwk7amnZI36TTIhWITrLBU1K4almVHN2fJ9DM157DwJUrc4lYRJH6H43/EfwleegyITFJrmlzq6rAnXfW24UTfMNC9FFeTUj1fiXqi9jdEuBoUIwiVsjZ1jfxdjufOQcLEG4LvCrVKqu5hw0UIm1CDr9mKQ3as41HlgQKBgCjBD+NSzTolzxdtOTFHddzHiV+wEFKl/vrlb0r46N5Y5v2WOqr0edhO3eZi5HOhzak9eVhL88IyslPxy1VqsDr69wlu0iY1pMX8JK7BHYmf7OTCZl1N3kTUxvSWZOh1QfWjxfJi4Ezrt0QEF0/gfHqCEmkb2rNrkpdjp3VU5uJ3AoGBANhQ1Jl3X3UOVXQm0ZXQ7OkPkWE5XZIOb+WUcB7JTXKmpAArqI2FOe3Ki+8rMWDNgDUu+/nvSSWzrAsG8+jR9Hp+fSQ6poagwpWcitPjFYQip6RUBx6Cv6mBCMXDGnxOQIi8GJCITT86SsF1YbirDmi/Yd58xPEBbQdjysRWhr8e";

		YopRequest request = new YopRequest("SQKK10000469946",SQKKkey);

		//参数
		request.addParam("identityid", "10014929805");
		//request.addParam("identitytype", "10014929805");


		//arg0:接口的uri（参见手册）
		//arg1:配置好的方法
		YopResponse response = YopClient3.postRsa("/rest/v1.0/paperorder/auth/bindcard/list", request);
		
		System.out.println(response.toString());

		
		return ;
		
	}

}
