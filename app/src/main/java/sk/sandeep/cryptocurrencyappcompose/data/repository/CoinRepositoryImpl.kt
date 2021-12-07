package sk.sandeep.cryptocurrencyappcompose.data.repository

import sk.sandeep.cryptocurrencyappcompose.data.remote.CoinPaprikaApi
import sk.sandeep.cryptocurrencyappcompose.data.remote.dto.CoinDetailDto
import sk.sandeep.cryptocurrencyappcompose.data.remote.dto.CoinDto
import sk.sandeep.cryptocurrencyappcompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}