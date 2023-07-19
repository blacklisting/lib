package com.blacklisting.lib

import com.blacklisting.lib.entries.QQ
import com.blacklisting.lib.entries.Zhihu
import kotlin.system.exitProcess

object Cli
{
    fun batch()
    {

    }

    fun commit()
    {

    }

    @JvmStatic
    fun main(args: Array<String>)
    {
        while (true)
        {
            print("> ")
            try
            {
                val input = readln().split(Regex("\t"))
                when (input[0])
                {
                    "exit", "quit" -> exitProcess(0)
                    "batch" -> batch()
                    "qq" -> QQ.cli()
                    "zhihu" -> Zhihu.cli()
                    "commit" -> commit()
                }
            }
            catch (e: Exception)
            {
                exitProcess(0)
            }
        }
    }
}
