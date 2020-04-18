package com.example.apiexam

data class Country(val name:String,val topLevelDomain:List<String>, val alpha2Code:String, val alpha3Code:String, val callingCodes: List<String>, val capital:String,
                   val altSpellings:List<String>, val region:String, val subregion:String, val population:Int, val latlng:List<Float>, val demonym:String, val area:Float,
                   val gini:Float, val timezones:List<String>, val borders:List<String>, val nativeName:String, val numericCode:String, val currencies:List<Cur>, val languages:List<Lang>,
                   val translations:Trans, val flag:String, val regionalBlocs:List<RegBl>, val cioc:String)
{
    data class Cur(val code:String, val name:String, val symbol:String)
    data class Lang(val iso639_1:String, val iso639_2:String, val name:String, val nativeName:String)
    data class Trans(val de:String, val es:String, val fr:String, val ja:String, val it:String, val br:String, val pt:String, val nl:String, val hr:String, val fa:String)
    data class RegBl(val acronym:String, val name:String, val otherAcronyms:List<String>, val otherNames:List<String>)
}