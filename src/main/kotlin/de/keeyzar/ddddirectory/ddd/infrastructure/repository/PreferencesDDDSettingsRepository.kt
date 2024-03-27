package de.keeyzar.ddddirectory.ddd.infrastructure.repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.intellij.ide.util.PropertiesComponent
import de.keeyzar.ddddirectory.ddd.domain.entity.DirectoryStructure
import de.keeyzar.ddddirectory.ddd.domain.repository.DDDSettingsRepository
import de.keeyzar.ddddirectory.ddd.infrastructure.mapper.DirectoryStructureMapper
import de.keeyzar.ddddirectory.ddd.infrastructure.model.DirectoryStructureModel

private const val DDD_SETTINGS_REPOSITORY_KEY_DIRECTORY_STRUCTURE = "de.keeyzar.ddd.directory.structure"

class PreferencesDDDSettingsRepository(
    private val objectMapper: ObjectMapper,
    private val directoryStructureMapper: DirectoryStructureMapper,

    ) : DDDSettingsRepository {
    override fun saveDirectoryStructure(projectName: String, directoryStructure: DirectoryStructure) {
        val model = directoryStructureMapper.toModel(directoryStructure)
        val properties = PropertiesComponent.getInstance()
        val serialized = objectMapper.writeValueAsString(model);
        properties.setValue("$DDD_SETTINGS_REPOSITORY_KEY_DIRECTORY_STRUCTURE.$projectName", serialized)
    }

    override fun getDirectoryStructure(projectName: String): DirectoryStructure? {
        val properties = PropertiesComponent.getInstance()
        val serialized = properties.getValue("$DDD_SETTINGS_REPOSITORY_KEY_DIRECTORY_STRUCTURE.$projectName") ?: return null
        val model = objectMapper.readValue(serialized, DirectoryStructureModel::class.java)
        return directoryStructureMapper.toEntity(model);
    }
}
