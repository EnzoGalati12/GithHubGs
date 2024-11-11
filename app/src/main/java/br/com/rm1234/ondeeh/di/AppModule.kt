package br.com.rm1234.ondeeh.di

import androidx.room.Room
import br.com.rm1234.ondeeh.data.local.AppDatabase
import br.com.rm1234.ondeeh.data.remote.api.GitService
import br.com.rm1234.ondeeh.data.repository.GitRepositoryImpl
import br.com.rm1234.ondeeh.domain.repository.GitRepository
import br.com.rm1234.ondeeh.domain.usecase.DeleteAllHistoryUseCase
import br.com.rm1234.ondeeh.domain.usecase.DeleteItemHistoryUseCase
import br.com.rm1234.ondeeh.domain.usecase.GetHistoryGitUseCase
import br.com.rm1234.ondeeh.domain.usecase.GetGitUseCase
import br.com.rm1234.ondeeh.presentation.detail.DetalheViewModel
import br.com.rm1234.ondeeh.presentation.history.GitHistoryViewModel
import br.com.rm1234.ondeeh.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitService::class.java)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "cep_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().gitDao() }
}


val repositoryModule = module {
    single<GitRepository> { GitRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    factory { GetGitUseCase(get()) }
    factory { GetHistoryGitUseCase(get()) }
    factory { DeleteItemHistoryUseCase(get()) }
    factory { DeleteAllHistoryUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { DetalheViewModel(get()) }
    viewModel { GitHistoryViewModel(get(), get(), get()) }
}

