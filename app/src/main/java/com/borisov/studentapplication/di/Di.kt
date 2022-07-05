package com.borisov.studentapplication.di

import com.borisov.studentapplication.data.repository.RepositoryImpl
import com.borisov.studentapplication.data.repository.datasource.DataSource
import com.borisov.studentapplication.data.repository.datasource.MockDataSourceImpl
import com.borisov.studentapplication.domain.repository.Repository
import com.borisov.studentapplication.domain.usecases.GetExamUseCase
import com.borisov.studentapplication.domain.usecases.GetHomeWorkUseCase
import com.borisov.studentapplication.domain.usecases.GetLessonUseCase
import com.borisov.studentapplication.ui.classes.ClassesViewModel
import com.borisov.studentapplication.ui.favourite.FavouriteViewModel
import com.borisov.studentapplication.ui.home.HomeViewModel
import com.borisov.studentapplication.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Borisov Andrey on 04.07.2022
 **/
object Di {

    fun viewModelModule() = module {
        viewModel() {
            ClassesViewModel(
                getLessonUseCase = get()
            )
        }

        viewModel() {
            FavouriteViewModel()
        }

        viewModel() {
            HomeViewModel(
                getLessonUseCase = get(),
                getHomeWorkUseCase = get(),
                getExamUseCase = get()
            )
        }

        viewModel() {
            ListViewModel()
        }
    }

    fun useCasesModule() = module {
        factory<GetLessonUseCase> {
            GetLessonUseCase(repository = get())
        }
        factory<GetHomeWorkUseCase> {
            GetHomeWorkUseCase(repository = get())
        }
        factory<GetExamUseCase> {
            GetExamUseCase(repository = get())
        }
    }

    fun repositoryModule() = module {
        single<Repository>() {
            RepositoryImpl(
                dataSource = get()
            )
        }

        single<DataSource> {
            MockDataSourceImpl()
        }
    }
}