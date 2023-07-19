package com.blacklisting.lib.bilibili

import java.io.File

object FileHandler
{
    val data = mutableListOf<DataStructure>()

    fun new() = data.apply {
        removeAll { true }
    }

    fun read(filePath: String) = read(File(filePath))

    fun read(file: File) = data.apply {
        removeAll { true }
        addAll(file.readLines()
            .drop(1)
            .map(DataStructure::fromString)
        )
    }

    fun add(datum: DataStructure) = data.add(datum)

    fun write(filePath: String) = write(File(filePath))

    fun write(file: File) = file.apply {
        writeText(DataStructure.definitions.joinToString(separator = ",") + "\n")
        data.sorted().forEach {
            appendText("$it\n")
        }
    }
}
