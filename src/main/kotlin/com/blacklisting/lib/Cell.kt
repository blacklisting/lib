package com.blacklisting.lib

data class Cell(
    val def: RowDef,
    val value: String
) : Comparable<Cell>
{
    override fun compareTo(other: Cell): Int = if (!def.sortNumerically) value.compareTo(other.value) else value.toLong().compareTo(other.value.toLong())
}
