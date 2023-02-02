package com.playnoob.viewmodel

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var name = ""
    private var numberOfGames = 0
    private var numOfOpenedTiles=0
    private var easyMode=false

    fun getModeEasy(): Boolean {
        return easyMode
    }

    fun setEasyMode(mode:Boolean){
        easyMode=mode
    }

    fun buyOneGame() {
        numberOfGames++
    }

    fun minusOneGame() {
        numberOfGames--
    }

    fun getAttempts(): Int {
        return numberOfGames
    }

    fun setName(n: String) {
        name = n
    }

    fun getName(): String {
        return name
    }

    fun addOpenedTiles(){
        numOfOpenedTiles++
    }

    fun getNumberOfOpenedTiles(): Int {
        return numOfOpenedTiles
    }
}