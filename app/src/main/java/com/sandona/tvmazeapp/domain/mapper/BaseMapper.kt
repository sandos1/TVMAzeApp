package com.sandona.tvmazeapp.domain.mapper

interface BaseMapper<DTO, ENTITY> {

    fun mapDtoToEntity(dataResponse: DTO): ENTITY

    // fun mapEntityToDto(entity: ENTITY): DTO
}
