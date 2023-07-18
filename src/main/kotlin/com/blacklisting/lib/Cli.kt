package com.blacklisting.lib

import com.blacklisting.lib.entries.Zhihu
import java.io.IOException
import kotlin.system.exitProcess

object Cli
{
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
                    "zhihu" -> Zhihu.cli()
                }
            }
            catch (e: Exception)
            {
                exitProcess(0)
            }
        }
    }
}
