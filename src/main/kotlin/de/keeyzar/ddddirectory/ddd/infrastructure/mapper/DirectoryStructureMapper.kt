package de.keeyzar.ddddirectory.ddd.infrastructure.mapper

import de.keeyzar.ddddirectory.ddd.domain.entity.DirectoryStructure
import de.keeyzar.ddddirectory.ddd.infrastructure.model.DirectoryStructureModel
import org.mapstruct.Mapper


@Mapper
interface DirectoryStructureMapper {
    fun toModel(entity: DirectoryStructure): DirectoryStructureModel

    fun toEntity(model: DirectoryStructureModel): DirectoryStructure
}
