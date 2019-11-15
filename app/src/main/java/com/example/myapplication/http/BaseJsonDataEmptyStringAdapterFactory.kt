package com.example.myapplication.http

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

/**
 * @author bao
 * @description:
 * @date :2019/11/12 14:54
 */
class BaseJsonDataEmptyStringAdapterFactory: TypeAdapterFactory {

    override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T> {
        val rawType: Class<in T>? = type?.rawType
        val originAdapter:TypeAdapter<T>?=gson?.getAdapter(type)
        return (if (String::class.java == rawType) originAdapter else Adapter(originAdapter)) as TypeAdapter
    }

    private inner class Adapter<E> (var componentTypeAdapter:TypeAdapter<E>?):TypeAdapter<E>(){
        override fun write(out: JsonWriter?, value: E) {
            componentTypeAdapter?.write(out,value)
        }

        override fun read(`in`: JsonReader?): E ?{
            return if (`in`?.peek()  == JsonToken.STRING) {
                `in`.skipValue()
                null
            } else {
                this.componentTypeAdapter?.read(`in`)
            }
        }

    }
}