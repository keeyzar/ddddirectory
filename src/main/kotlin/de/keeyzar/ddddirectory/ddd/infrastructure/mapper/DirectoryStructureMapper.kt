package de.keeyzar.ddddirectory.ddd.infrastructure.mapper

import de.keeyzar.ddddirectory.ddd.domain.entity.DirectoryStructure
import de.keeyzar.ddddirectory.ddd.infrastructure.model.DirectoryStructureModel
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper
interface DirectoryStructureMapper {
    fun toModel(entity: DirectoryStructure): DirectoryStructureModel

    @Mapping(target = "copy", ignore = true) // from data class of kotlin
    fun toEntity(model: DirectoryStructureModel): DirectoryStructure
}
