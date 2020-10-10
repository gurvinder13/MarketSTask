package com.example.marketstask.data.remote;

import android.util.Log;

import java.io.IOException;

import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        logRequestDetails(request, chain.connection());
        return chain.proceed(request);
    }

    private synchronized void logRequestDetails(Request request, Connection connection)
            throws IOException {
        RequestBody requestBody = request.body();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        String requestStartMessage =
                "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
        if (requestBody != null) {
            requestStartMessage += " (" + requestBody.contentLength() + "-byte body)";
        }
        Log.d("REQUEST", requestStartMessage);
    }

}
