package de.keeyzar.ddddirectory.features.ddd.infrastructure.mapper

import de.keeyzar.ddddirectory.ddd.domain.entity.DirectoryStructure
import de.keeyzar.ddddirectory.ddd.infrastructure.mapper.DirectoryStructureMapper
import de.keeyzar.ddddirectory.ddd.infrastructure.model.DirectoryStructureModel
import org.assertj.core.api.Assertions.*
import org.junit.Test
import org.mapstruct.factory.Mappers

class DirectoryStructureMapperTest {
    val sut = Mappers.getMapper(DirectoryStructureMapper::class.java)
    @Test
    fun `toModel should map entity to model`() {
        val entity = DirectoryStructure(
            subDirectories = listOf("sub1", "sub2")
        )

        val model = sut.toModel(entity)

        assertThat(model.getSubDirectories()).isEqualTo(entity.subDirectories)
    }


    @Test
    fun `toModel should map model to entity`() {
        val model = DirectoryStructureModel(
            subDirectories = listOf("sub1", "sub2")
        )

        val entity = sut.toEntity(model)

        assertThat(entity.subDirectories).isEqualTo(model.getSubDirectories())
    }
}
