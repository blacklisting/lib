package com.blacklisting.lib.bilibili

data class DataStructure(
    var username: String,
    var uid: String,
    var videoTitle: String,
    var videoBv: String,
    var comment: String,
    var time: String,
    var ip: String
) : Comparable<DataStructure>
{
    override operator fun compareTo(other: DataStructure): Int = uid.compareTo(other.uid)

    override fun toString(): String = "\"$username\",\"$uid\",\"$videoTitle\",\"$videoBv\",\"$comment\",\"$time\",\"$ip\""

    companion object
    {
        val definitions = listOf("用户名", "UID", "评论视频标题", "评论视频 BV", "评论内容", "评论时间", "IP 属地")

        fun fromString(string: String): DataStructure = with(string.split("\",\"").map { it.trim('"') }) {
            DataStructure(get(0), get(1), get(2), get(3), get(4), get(5), get(6))
        }
    }
}
