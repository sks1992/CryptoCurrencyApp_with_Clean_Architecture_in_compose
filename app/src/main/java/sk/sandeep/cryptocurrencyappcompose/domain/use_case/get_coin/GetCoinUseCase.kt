package sk.sandeep.cryptocurrencyappcompose.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import sk.sandeep.cryptocurrencyappcompose.common.Resource
import sk.sandeep.cryptocurrencyappcompose.data.remote.dto.toCoinDetail
import sk.sandeep.cryptocurrencyappcompose.domain.model.CoinDetail
import sk.sandeep.cryptocurrencyappcompose.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach server.Check Internet connection"))
        }
    }
}