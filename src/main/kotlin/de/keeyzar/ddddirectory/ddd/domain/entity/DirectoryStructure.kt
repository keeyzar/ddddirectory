package de.keeyzar.ddddirectory.ddd.domain.entity

import groovy.transform.builder.Builder

/**
 * saves the desired directory structure
 */
@Builder
data class DirectoryStructure(
    val subDirectories: List<String>
)
