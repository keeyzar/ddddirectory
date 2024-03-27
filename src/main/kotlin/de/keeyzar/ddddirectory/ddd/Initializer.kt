package de.keeyzar.ddddirectory.ddd

import com.fasterxml.jackson.databind.ObjectMapper
import de.keeyzar.ddddirectory.ddd.domain.repository.DDDSettingsRepository
import de.keeyzar.ddddirectory.ddd.infrastructure.mapper.DirectoryStructureMapper
import de.keeyzar.ddddirectory.ddd.infrastructure.repository.PreferencesDDDSettingsRepository
import de.keeyzar.ddddirectory.ddd.presentation.service.CreateDirectoryTreeService
import de.keeyzar.ddddirectory.ddd.presentation.service.SaveDirectoryTreeService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.mapstruct.factory.Mappers

class Initializer : KoinComponent {
    init {
        val appModule: Module = module {
            single<DirectoryStructureMapper> { Mappers.getMapper(DirectoryStructureMapper::class.java) }
            single<DDDSettingsRepository> { PreferencesDDDSettingsRepository(ObjectMapper(), get()) }
            single { SaveDirectoryTreeService(get()) }
            single { CreateDirectoryTreeService(get()) }
        }

        if(org.koin.core.context.GlobalContext.getOrNull() == null) {
            startKoin {
                modules(appModule)
            }
        }
    }

    val saveDirectoryTreeService: SaveDirectoryTreeService by inject();
    val createDirectoryStructureService: CreateDirectoryTreeService by inject();
}
