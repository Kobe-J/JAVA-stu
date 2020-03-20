package InterfaceTEST;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yxl
 * 模拟接口工具 测试
 * HttpClient java
 * date  2020.3.13
 * */
public class case_01 {

    public static void main(String[] args) throws IOException {
        case_01 case_01 = new case_01();
        case_01.get();
        case_01.post();

    }

    private  void  get() throws IOException {
        String url="http://127.0.0.1:8001/login";
        url += "?name=yx1&pwd=123";
        HttpGet httpGet= new HttpGet(url);
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpGet);
        String res = EntityUtils.toString(response.getEntity());
        System.out.println(res);
    }

    private void  post() throws IOException {
        //请求地址
        String url="http://127.0.0.1:8001/login";
        //请求方法
        HttpPost post = new HttpPost(url);
        //请求参数


        List<NameValuePair> Parameters = new ArrayList<NameValuePair>();
        Parameters.add(new BasicNameValuePair("name","yxl"));
        Parameters.add(new BasicNameValuePair("pwd","123"));
        post.setEntity(new UrlEncodedFormEntity(Parameters));
        //调用HttpClients工具类发起请求
        HttpClient httpClient = HttpClients.createDefault();
        //请求返回的参数
        HttpResponse response = httpClient.execute(post);
        //把请求返回的参数转字符串
        String res = EntityUtils.toString(response.getEntity());
        //打印  断言。。
        System.out.println(res);
    }
}
