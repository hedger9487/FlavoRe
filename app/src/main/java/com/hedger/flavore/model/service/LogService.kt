package com.hedger.flavore.model.service

interface LogService {
    fun logNonFatalCrash(throwable: Throwable)
}