package sk.sandeep.cryptocurrencyappcompose.domain.repository

import sk.sandeep.cryptocurrencyappcompose.data.remote.dto.CoinDetailDto
import sk.sandeep.cryptocurrencyappcompose.data.remote.dto.CoinDto


interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}