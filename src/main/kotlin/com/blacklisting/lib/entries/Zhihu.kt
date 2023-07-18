package com.blacklisting.lib.entries

import com.blacklisting.lib.zhihu.DataStructure
import com.blacklisting.lib.zhihu.FileHandler
import java.io.File
import kotlin.system.exitProcess

object Zhihu
{
    fun cli()
    {
        while (true)
        {
            print("zhihu > ")
            try
            {
                val input = readln().split(Regex("\t"))
                when (input[0])
                {
                    "exit", "quit" -> return
                    "new" ->
                    {
                        print("Name: ")
                        FileHandler.current = "zhihu/" + readln() + ".csv"
                    }
                    "add" ->
                    {
                        FileHandler.add(
                            DataStructure(
                                DataStructure.definitions.map { def->
                                    print("$def: ")
                                    readln()
                                }
                            )
                        )
                    }
                    "read" ->
                    {
                        print("Name: ")
                        FileHandler.read("zhihu/" + readln() + ".csv")
                    }
                    "write" ->
                    {
                        FileHandler.write()
                    }
                    "dump" ->
                    {
                        FileHandler.data.forEach(::println)
                    }
                }
            }
            catch (e: Exception)
            {
                e.printStackTrace()
                exitProcess(0)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>)
    {
        File("zhihu").walkTopDown()
            .onEnter {
                !it.name.startsWith(".")
            }
            .filter {
                !it.isDirectory
            }
            .forEach {
                println(it)
                FileHandler.read(it)
                FileHandler.write(it)
            }
    }
}
