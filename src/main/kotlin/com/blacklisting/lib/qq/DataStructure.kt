package com.blacklisting.lib.qq

data class DataStructure(
    var username: String,
    var id: Long,
    var description: String
) : Comparable<DataStructure>
{
    constructor(input: List<String>) : this(input[0], input[1].toLong(), input[2])

    override operator fun compareTo(other: DataStructure): Int = id.compareTo(other.id)

    override fun toString(): String = "\"$username\",$id,\"$description\""

    companion object
    {
        val definitions = listOf("昵称", "QQ 号", "描述")

        fun fromString(string: String): DataStructure = with(string.split("\",\"").map { it.trim('"') }) {
            DataStructure(get(0), get(1).toLong(), get(2))
        }
    }
}
