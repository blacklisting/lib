package com.blacklisting.lib

import com.opencsv.CSVReader
import java.io.File

class BlacklistIO(val domain: Domain)
{
    constructor(domain: String) : this(Domain.valueOf(domain))

    fun read(filePath: String) = read(File(filePath))

    fun read(file: File) = CSVReader(file.reader()).readAll()
        .drop(1)
        .map { line ->
            line.mapIndexed { rowIndex, content ->
                Cell(domain.rowDefs[rowIndex], content)
            }.toMutableList()
        }
        .toMutableList()

    fun write(file: File, data: List<List<Cell>>) = file.apply {
        writeText(domain.rowDefs.joinToString(separator = ",", postfix = "\n", transform = RowDef::representName))
        data.sortedBy { cells ->
            cells[domain.sortIndex]
        }.forEach { datum ->
            appendText(datum.joinToString(",", postfix = "\n") { cell ->
                if (cell.def.needQuote) "\"${cell.value}\"" else cell.value
            })
        }
    }
}
