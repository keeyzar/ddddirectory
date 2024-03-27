package de.keeyzar.ddddirectory.ddd.infrastructure.model

class DirectoryStructureModel(
    private var subDirectories: List<String>
) {
    //getter, setter, no args constructor
    constructor() : this(emptyList())

    fun getSubDirectories(): List<String> {
        return subDirectories
    }

    fun setSubDirectories(subDirectories: List<String>) {
        this.subDirectories = subDirectories
    }
}
