package com.blacklisting.lib.entries

import com.blacklisting.lib.qq.DataStructure
import com.blacklisting.lib.qq.FileHandler
import java.io.File
import kotlin.system.exitProcess

object QQ
{
    fun cli()
    {
        while (true)
        {
            print("qq > ")
            try
            {
                val input = readln().split(Regex("\t"))
                when (input[0])
                {
                    "exit", "quit" -> return
                    "new" ->
                    {
                        print("Name: ")
                        FileHandler.new("qq/" + readln() + ".csv")
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
                        FileHandler.read("qq/" + readln() + ".csv")
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
        File("qq").walkTopDown()
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
