package com.vot.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier

@Qualifier
annotation class ActivityModule

@Qualifier
annotation class FragmentModule

@InstallIn(ActivityComponent::class)
@Module
abstract class DataActivityModule {
    @ActivityModule
    @ActivityScoped
    @Binds  // interface에 사용할 구현을 hilt에 알리려면 hilt 모듈 내 함수에 해당 어노테이션을 사용해야
    abstract fun bindData(impl: DataStateListenerImpl): OnDataStateListener
}

@InstallIn(FragmentComponent::class)
@Module
abstract class DataFragmentModule {
    @FragmentModule
    @ActivityScoped
    @Binds
    abstract fun bindData(impl: DataStateListenerImpl): OnDataStateListener
}