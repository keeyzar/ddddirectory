package de.keeyzar.ddddirectory.ddd.presentation.service

import com.intellij.openapi.vfs.VirtualFile
import de.keeyzar.ddddirectory.ddd.domain.entity.DirectoryStructure
import de.keeyzar.ddddirectory.ddd.domain.repository.DDDSettingsRepository

class SaveDirectoryTreeService(private val repository: DDDSettingsRepository) {
    fun saveDirectoryTree(projectName: String, directoryTree: List<VirtualFile>, root: VirtualFile) {
        val directoryStructureTree = directoryTree
            .map { it.path }
            .map { it.replace(root.path, "") }

        val directoryStructure = DirectoryStructure(directoryStructureTree)

        repository.saveDirectoryStructure(projectName, directoryStructure)
    }
}
