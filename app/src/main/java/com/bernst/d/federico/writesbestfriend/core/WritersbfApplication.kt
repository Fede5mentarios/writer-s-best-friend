package com.bernst.d.federico.writesbestfriend.core

import android.app.Activity
import android.support.multidex.MultiDexApplication
import com.bernst.d.federico.writesbestfriend.dagger.components.DaggerWritersbfComponents
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.db.FormDataBase
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class WritersbfApplication : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>


    lateinit var component: WritersbfComponents
    lateinit var db: FormDataBase

    override fun onCreate() {
        super.onCreate()
        db = FormDataBase.getInstance(this)
        component = DaggerWritersbfComponents.builder()
                .create(this)
                .build()
        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}
