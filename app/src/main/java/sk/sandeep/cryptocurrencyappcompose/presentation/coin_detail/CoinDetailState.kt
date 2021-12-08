package sk.sandeep.cryptocurrencyappcompose.presentation.coin_detail

import sk.sandeep.cryptocurrencyappcompose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)