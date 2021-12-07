package sk.sandeep.cryptocurrencyappcompose.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import sk.sandeep.cryptocurrencyappcompose.common.Resource
import sk.sandeep.cryptocurrencyappcompose.data.remote.dto.toCoin
import sk.sandeep.cryptocurrencyappcompose.domain.model.Coin
import sk.sandeep.cryptocurrencyappcompose.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())

            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach server.Check Internet connection"))
        }
    }
}