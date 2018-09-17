package com.bernst.d.federico.writesbestfriend.dagger.modules

import com.bernst.d.federico.writesbestfriend.views.activities.CharacterListActivity
import com.bernst.d.federico.writesbestfriend.views.activities.FormActivity
import com.bernst.d.federico.writesbestfriend.views.activities.HomeActivity
import com.bernst.d.federico.writesbestfriend.views.activities.StoriesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivityInjector(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeFormActivityInjector(): FormActivity

    @ContributesAndroidInjector
    abstract fun contributeStoriesActivityInjector(): StoriesActivity

    @ContributesAndroidInjector
    abstract fun contributeCharacterListActivityInjector(): CharacterListActivity
}
