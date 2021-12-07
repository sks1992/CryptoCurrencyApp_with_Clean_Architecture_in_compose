package sk.sandeep.cryptocurrencyappcompose.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import sk.sandeep.cryptocurrencyappcompose.data.remote.dto.CoinDetailDto
import sk.sandeep.cryptocurrencyappcompose.data.remote.dto.CoinDto

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}