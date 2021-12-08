package sk.sandeep.cryptocurrencyappcompose.presentation.coin_list

import sk.sandeep.cryptocurrencyappcompose.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)