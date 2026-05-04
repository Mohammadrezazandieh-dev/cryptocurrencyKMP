package org.example.project.app.payment.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.theme.CryptocurrencyTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun PaymentGatewayItemDefaultPreview() {
    CryptocurrencyTheme {
        PaymentGatewayItem(
            paymentGateway = PaymentGateway(
                id = "stripe",
                name = "Stripe",
                iconUrl = "https://example.com/stripe-icon.png",
                isEnabled = true,
                processingFee = 2.9
            ),
            isSelected = false,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun PaymentGatewayItemSelectedPreview() {
    CryptocurrencyTheme {
        PaymentGatewayItem(
            paymentGateway = PaymentGateway(
                id = "paypal",
                name = "PayPal",
                iconUrl = "https://example.com/paypal-icon.png",
                isEnabled = true,
                processingFee = 3.5
            ),
            isSelected = true,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun PaymentGatewayItemDisabledPreview() {
    CryptocurrencyTheme {
        PaymentGatewayItem(
            paymentGateway = PaymentGateway(
                id = "square",
                name = "Square",
                iconUrl = "https://example.com/square-icon.png",
                isEnabled = false,
                processingFee = 2.6
            ),
            isSelected = false,
            onClick = {}
        )
    }
}

@Preview()
@Composable
private fun PaymentGatewayItemNoFeePreview() {
    CryptocurrencyTheme {
        PaymentGatewayItem(
            paymentGateway = PaymentGateway(
                id = "crypto",
                name = "Crypto Payment",
                iconUrl = "https://example.com/crypto-icon.png",
                isEnabled = true,
                processingFee = 0.0
            ),
            isSelected = false,
            onClick = {}
        )
    }
}

@Preview()
@Composable
private fun PaymentGatewayItemMultiplePreview() {
    CryptocurrencyTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PaymentGatewayItem(
                paymentGateway = PaymentGateway(
                    id = "stripe",
                    name = "Stripe",
                    iconUrl = "https://example.com/stripe-icon.png",
                    isEnabled = true,
                    processingFee = 2.9
                ),
                isSelected = true,
                onClick = {}
            )
            
            PaymentGatewayItem(
                paymentGateway = PaymentGateway(
                    id = "paypal",
                    name = "PayPal",
                    iconUrl = "https://example.com/paypal-icon.png",
                    isEnabled = true,
                    processingFee = 3.5
                ),
                isSelected = false,
                onClick = {}
            )
            
            PaymentGatewayItem(
                paymentGateway = PaymentGateway(
                    id = "square",
                    name = "Square",
                    iconUrl = "https://example.com/square-icon.png",
                    isEnabled = false,
                    processingFee = 2.6
                ),
                isSelected = false,
                onClick = {}
            )
        }
    }
} 