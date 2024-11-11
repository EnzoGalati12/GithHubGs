package br.com.rm1234.ondeeh

import android.app.Application
import br.com.rm1234.ondeeh.di.databaseModule
import br.com.rm1234.ondeeh.di.networkModule
import br.com.rm1234.ondeeh.di.repositoryModule
import br.com.rm1234.ondeeh.di.useCaseModule
import br.com.rm1234.ondeeh.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class OndeEhApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@OndeEhApplication)
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}
