package com.example.myapplication.util

import java.security.MessageDigest

/**
 * @author bao
 * @description:
 * @date :2019/11/14 14:17
 */
object MD5Util {
        fun getMD5Str(str:String):String{
            val messageDigest = MessageDigest.getInstance("MD5")
            messageDigest.reset()
            messageDigest.update(str.toByteArray(Charsets.UTF_8))
            val digest = messageDigest.digest()
            val md5StrBuff=StringBuffer()
            for(bb in digest){
                if (Integer.toHexString(255 and bb.toInt()).length == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(255 and bb.toInt()))
                } else {
                    md5StrBuff.append(Integer.toHexString(255 and bb.toInt()))
                }
            }
            return md5StrBuff.toString()
        }
}