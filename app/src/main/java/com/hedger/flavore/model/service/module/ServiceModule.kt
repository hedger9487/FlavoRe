package com.hedger.flavore.model.service.module

import com.hedger.flavore.model.service.AccountService
import com.hedger.flavore.model.service.LogService
import com.hedger.flavore.model.service.impl.AccountServiceImpl
import com.hedger.flavore.model.service.impl.LogServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule{
    // telling hilt if somewhere call type AccountService, the impl should be AccountServiceImpl
    // so it is easier to modify the implementation one day
    @Binds abstract fun provideAccountService(impl: AccountServiceImpl):AccountService

    @Binds abstract fun provideLogService(impl: LogServiceImpl): LogService
}