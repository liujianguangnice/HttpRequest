package com.mp5a5.www.httprequest

import android.app.Application
import com.mp5a5.www.library.utils.ApiConfig

/**
 * @author ：mp5a5 on 2018/12/28 15：12
 * @describe
 * @email：wwb199055@126.com
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        val baseUrl = "http://op.juhe.cn/"
        val build = ApiConfig.Builder()
            .setBaseUrl(baseUrl)
            .setInvalidateToken(200)
            .setSucceedCode(0)
            .setFilter("com.mp5a5.quit.broadcastFilter")
            .build()
        build.init(this)

    }
}
