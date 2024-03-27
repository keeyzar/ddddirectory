package de.keeyzar.ddddirectory.ddd.domain.repository

import de.keeyzar.ddddirectory.ddd.domain.entity.DirectoryStructure

interface DDDSettingsRepository {
    fun saveDirectoryStructure(projectName: String, directoryStructure: DirectoryStructure)
    fun getDirectoryStructure(projectName: String): DirectoryStructure?
}
