package com.blacklisting.lib.zhihu

data class DataStructure(
    var username: String,
    var id: String,
    var question: String,
    var questionLink: String,
    var comment: String,
    var time: String,
    var answerLink: String
) : Comparable<DataStructure>
{
    constructor(input: List<String>) : this(input[0], input[1], input[2], input[3], input[4], input[5], input[6])

    override operator fun compareTo(other: DataStructure): Int = id.compareTo(other.id)

    override fun toString(): String = "\"$username\",\"$id\",\"$question\",\"$questionLink\",\"$comment\",\"$time\",\"$answerLink\""

    companion object
    {
        val definitions = listOf("用户名", "ID", "问题", "问题链接", "评论", "时间", "回答链接")

        fun fromString(string: String): DataStructure = with(string.split("\",\"").map { it.trim('"') }) {
            DataStructure(get(0), get(1), get(2), get(3), get(4), get(5), get(6))
        }
    }
}
