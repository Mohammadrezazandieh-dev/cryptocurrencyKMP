package org.example.project.app.trade.presentation.buy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.app.coins.domain.GetCoinDetailsUseCase
import org.example.project.app.core.domain.Result
import org.example.project.app.core.util.formatFiat
import org.example.project.app.core.util.toUiText
import org.example.project.app.portfolio.domain.PortfolioRepository
import org.example.project.app.trade.domain.BuyCoinUseCase
import org.example.project.app.trade.presentation.common.TradeState
import org.example.project.app.trade.presentation.common.UiTradeCoinItem
import org.example.project.app.trade.presentation.mapper.toCoin

class BuyViewModel(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val portfolioRepository: PortfolioRepository,
    private val buyCoinUseCase: BuyCoinUseCase
): ViewModel() {
private val tempCoinId = "1" // todo: will be removed later and replace by parameter
private val _amount = MutableStateFlow("")
private val _state = MutableStateFlow(TradeState())
    val state = combine(
        _state,
        _amount
    ){ state, amount ->
        state.copy(
            amount = amount
        )
    }.onStart {
        val balance = portfolioRepository.cashBalanceFlow().first()
        getCoinDetails(balance)
    }.stateIn (
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = TradeState(isLoading = true)
    )


    private suspend fun getCoinDetails(balance: Double) {
        when(val coinResponse = getCoinDetailsUseCase.execute(tempCoinId)){
            is Result.Success -> {
                _state.update {
                    it.copy(
                        coin = UiTradeCoinItem(
                            id = coinResponse.data.coin.id,
                            name = coinResponse.data.coin.name,
                            symbol = coinResponse.data.coin.symbol,
                            iconUrl = coinResponse.data.coin.iconUrl,
                            price = coinResponse.data.price,
                        ),
                        availableAmountL = "Available: ${formatFiat(balance)}"
                    )
                }
            }

            is Result.Error -> {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = coinResponse.error.toUiText()
                    )
                }
            }
        }
    }


    fun onAmountChanged(amount: String) {
        _amount.value = amount
    }

    fun onBuyClicked() {
        val tradeCoin = state.value.coin ?: return
        viewModelScope.launch {
            val buyCoinResponse = buyCoinUseCase.buyCoin(
                coin = tradeCoin.toCoin(),
                amountInFiat = _amount.value.toDouble(),
                price = tradeCoin.price
            )

            when(buyCoinResponse) {
                is Result.Success -> {
                    // todo: Navigate to next screen with event
                }

                is Result.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = buyCoinResponse.error.toUiText()
                        )
                    }
                }
            }
        }
    }

}









