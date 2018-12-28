package com.mp5a5.www.library.net.interceptor;

import com.mp5a5.www.library.utils.ApiConfig;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.annotations.EverythingIsNonNull;

import java.io.IOException;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author ：王文彬 on 2018/5/23 13：31
 * @describe：
 * @email：wwb199055@126.com
 */
@SuppressWarnings("ALL")
public class HttpHeaderInterceptor implements Interceptor {

    @Override
    @EverythingIsNonNull
    public Response intercept(Chain chain) throws IOException {
        String accessToken = "token";
        String tokenType = "tokenType";
        Request originalRequest = chain.request();

        Map<String, String> heads = ApiConfig.getHeads();

        Request.Builder authorization = originalRequest.newBuilder()
                .header("Content-type", "application/json")
                .header("Authorization", tokenType + " " + accessToken)
                .addHeader("Connection", "close")
                .addHeader("Accept-Encoding", "identity");

        //动态添加Header
        if (null != heads) {
            heads.forEach(new BiConsumer<String, String>() {
                @Override
                public void accept(String key, String value) {
                    authorization.addHeader(key, value);
                }
            });
        }

        Request build = authorization.build();

        return chain.proceed(build);
    }
}
