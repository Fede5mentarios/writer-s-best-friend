package com.bernst.d.federico.writesbestfriend.dagger.modules

import com.bernst.d.federico.writesbestfriend.core.WritersbfApplication
import com.bernst.d.federico.writesbestfriend.views.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideApplication(app: WritersbfApplication): WritersbfApplication {
        return app
    }

    @Provides
    @Singleton
    fun provideNavigator(): Navigator {
        return Navigator()
    }
}
