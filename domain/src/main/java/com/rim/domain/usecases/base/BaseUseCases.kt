package com.rim.domain.usecases.base

interface BaseUseCase<out RESPONSE>  {
     suspend operator fun invoke(): RESPONSE
}

interface BaseUseCaseWithInput<in REQUEST, out RESPONSE> {
    suspend operator fun invoke(request: REQUEST): RESPONSE
}