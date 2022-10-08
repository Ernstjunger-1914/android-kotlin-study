package com.ssd.koin.di

import com.ssd.koin.module.Asd
import com.ssd.koin.module.Asdf
import org.koin.dsl.module

val AppModule = module {
    single {
        Asd()
    }

    factory {
        Asdf(
            get()
        )
    }
}

