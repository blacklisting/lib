package com.blacklisting.lib.qq

import java.io.File

object FileHandler
{
    val data = mutableListOf<DataStructure>()

    var current = ""

    fun new(name: String) = data.apply {
        current = name
        removeAll { true }
    }

    fun read(filePath: String) = read(File(filePath))

    fun read(file: File) = data.apply {
        current = file.toRelativeString(File("./"))
        removeAll { true }
        addAll(file.readLines()
            .drop(1)
            .map(DataStructure::fromString)
        )
    }

    fun add(datum: DataStructure) = data.add(datum)

    fun write() = write(current)

    fun write(filePath: String) = write(File(filePath))

    fun write(file: File) = file.apply {
        parentFile.mkdirs()
        writeText(DataStructure.definitions.joinToString(separator = ",") + "\n")
        data.sorted().forEach {
            appendText("$it\n")
        }
    }
}
