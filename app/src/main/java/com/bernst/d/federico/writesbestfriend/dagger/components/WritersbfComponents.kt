package com.bernst.d.federico.writesbestfriend.dagger.components

import android.app.Application
import com.bernst.d.federico.writesbestfriend.core.WritersbfApplication
import com.bernst.d.federico.writesbestfriend.dagger.modules.*
import com.bernst.d.federico.writesbestfriend.viewmodel.CharacterViewModel
import com.bernst.d.federico.writesbestfriend.viewmodel.CharactersViewModel
import com.bernst.d.federico.writesbestfriend.viewmodel.FormViewModel
import com.bernst.d.federico.writesbestfriend.viewmodel.HomeViewModel
import com.bernst.d.federico.writesbestfriend.views.activities.CharacterListActivity
import com.bernst.d.federico.writesbestfriend.views.activities.FormActivity
import com.bernst.d.federico.writesbestfriend.views.activities.HomeActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    DataModule::class, ActivityModule::class,
    FragmentModule::class, ViewModelModule::class])
interface WritersbfComponents : AndroidInjector<WritersbfApplication> {
    fun inject(homeActivity: HomeActivity)
    fun inject(characterListActivity: CharacterListActivity)
    fun inject(formActivity: FormActivity)

    fun inject(homeViewModel: HomeViewModel)

    fun inject(charactersViewModel: CharactersViewModel)
    fun inject(formViewModel: FormViewModel)
    fun inject(characterViewModel: CharacterViewModel)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): WritersbfComponents
    }
}

