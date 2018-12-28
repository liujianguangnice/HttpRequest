package com.mp5a5.www.httprequest

import android.os.Bundle
import com.mp5a5.www.httprequest.net.api.NBAService
import com.mp5a5.www.httprequest.net.api.NBAServiceT
import com.mp5a5.www.httprequest.net.entity.NBAEntity
import com.mp5a5.www.library.use.BaseObserver
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnNBA.setOnClickListener {
            NBAService
                .getNBAInfo("6949e822e6844ae6453fca0cf83379d3")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.bindToLifecycle())
                .subscribe(object : BaseObserver<NBAEntity>() {
                    override fun onSuccess(response: NBAEntity?) {
                        toast(response?.result?.title!!)
                    }

                })
        }

        tvTest.setOnClickListener {
            NBAServiceT
                .getNBAInfo("6949e822e6844ae6453fca0cf83379d3")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.bindToLifecycle())
                .subscribe(object : BaseObserver<NBAEntity>() {
                    override fun onSuccess(response: NBAEntity?) {
                        toast(response?.result?.title!!)
                    }

                })
        }

    }
}
