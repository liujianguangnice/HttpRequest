package com.mp5a5.www.library.utils;

import android.content.Context;
import android.util.ArrayMap;
import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * @author ：mp5a5 on 2018/12/27 20：51
 * @describe 网络请求配置文件
 * @email：wwb199055@126.com
 */
public class ApiConfig {

    private static int mInvalidateToke;
    private static String mBaseUrl;
    private static int mDefaultTimeout = 2000;
    private static int mSucceedCode;
    private static String mQuitBroadcastReceiverFilter;
    private static ArrayMap<String , String> mHeads;

    private ApiConfig(Builder builder) {
        mInvalidateToke = builder.mToken;
        mBaseUrl = builder.mBaseUrl;
        mDefaultTimeout = builder.defaultTimeout;
        mSucceedCode = builder.succeedCode;
        mQuitBroadcastReceiverFilter = builder.mFilter;
        mHeads=builder.heads;
    }

    public void init(Context appContext) {
        AppContextUtils.init(appContext);
    }

    public static int getInvalidateToke() {
        return mInvalidateToke;
    }

    public static String getBaseUrl() {
        return mBaseUrl;
    }

    public static int getDefaultTimeout() {
        return mDefaultTimeout;
    }

    public static int getSucceedCode() {
        return mSucceedCode;
    }

    public static String getQuitBroadcastReceiverFilter() {
        return mQuitBroadcastReceiverFilter;
    }

    public static ArrayMap<String, String> getHeads() {
        return mHeads;
    }

    public static void setHeads(ArrayMap<String, String> mHeads) {
        ApiConfig.mHeads = mHeads;
    }

    public static final class Builder implements Serializable {

        private int mToken;

        private String mBaseUrl;

        private int defaultTimeout;

        private int succeedCode;

        private String mFilter;

        private ArrayMap<String, String> heads;

        public Builder setHeads(ArrayMap<String, String> heads) {
            this.heads = heads;
            return this;
        }

        public Builder setFilter(@NonNull String filter) {
            this.mFilter = filter;
            return this;
        }


        public Builder setSucceedCode(int succeedCode) {
            this.succeedCode = succeedCode;
            return this;
        }

        public Builder setBaseUrl(String mBaseUrl) {
            this.mBaseUrl = mBaseUrl;
            return this;
        }

        public Builder setInvalidateToken(int invalidateToken) {
            this.mToken = invalidateToken;
            return this;
        }

        public void setDefaultTimeout(int defaultTimeout) {
            this.defaultTimeout = defaultTimeout;
        }

        public ApiConfig build() {
            return new ApiConfig(this);
        }
    }
}
