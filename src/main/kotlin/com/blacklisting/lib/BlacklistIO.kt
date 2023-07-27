package com.blacklisting.lib

import java.io.File

class BlacklistIO(val domain: Domain)
{
    constructor(domain: String) : this(Domain.valueOf(domain))

    fun read(filePath: String) = read(File(filePath))

    fun read(file: File) = file.readLines()
        .drop(1)
        .map { line ->
            line.split(Regex("\"?,\"?")).mapIndexed { rowIndex, cell ->
                Cell(domain.rowDefs[rowIndex], cell)
            }
        }

    fun write(file: File, data: List<List<Cell>>) = file.apply {
        writeText(domain.rowDefs.joinToString(separator = ",", postfix = "\n", transform = RowDef::fieldName))
        data.sortedBy { cells ->
            cells[domain.sortIndex]
        }.forEach { datum ->
            appendText(datum.joinToString(",") { cell ->
                if (cell.def.needQuote) "\"${cell.value}\"" else cell.value
            })
        }
    }
}
