package com.blacklisting.lib

enum class Domain(val rowDefs: List<RowDef>, val sortIndex: Int)
{
    Bilibili(
        rowDefs = listOf(
            RowDef("username", "用户名", true),
            RowDef("uid", "UID", true),
            RowDef("videoTitle", "评论视频标题", true),
            RowDef("videoBv", "评论视频 BV", true),
            RowDef("content", "评论内容", true),
            RowDef("time", "评论时间", true),
            RowDef("ip", "IP 属地", true)
        ),
        sortIndex = 1
    ),
    Qq(
        rowDefs = listOf(
            RowDef("nickname", "昵称", true),
            RowDef("qq", "QQ 号", false),
            RowDef("description", "描述", true),
        ),
        sortIndex = 1
    ),
    Weixin(
        rowDefs = listOf(
            RowDef("nickname", "昵称", true),
            RowDef("wxid", "wxid", false),
            RowDef("id", "微信号", false),
            RowDef("description", "描述", true)
        ),
        sortIndex = 1
    ),
    Zhihu(
        rowDefs = listOf(
            RowDef("username", "用户名", true),
            RowDef("id", "ID", true),
            RowDef("question", "问题", true),
            RowDef("questionLink", "问题链接", true),
            RowDef("comment", "评论", true),
            RowDef("time", "时间", true),
            RowDef("answerLink", "回答链接", true)
        ),
        sortIndex = 1
    )
}
