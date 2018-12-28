package com.mp5a5.www.httprequest.net.api

import android.util.ArrayMap
import com.mp5a5.www.httprequest.net.entity.NBAEntity
import com.mp5a5.www.library.use.RetrofitFactory
import io.reactivex.Observable

/**
 * @describe
 * @author ：mp5a5 on 2018/12/28 19：52
 * @email：wwb199055@126.com
 */
object NBAServiceT {

    private val mNBAApi = RetrofitFactory.getInstance().create("http://www.baidu.com",NBAApi::class.java)

    fun getNBAInfo(key: String): Observable<NBAEntity> {
        val arrayMap = ArrayMap<String, Any>()
        arrayMap["key"] = key
        return mNBAApi.getNBAInfo(arrayMap)
    }
}