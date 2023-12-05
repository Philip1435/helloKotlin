package com.example.expensepartner.data.model

data class Subscription(
    val payment_method: String,
    val plan: String,
    val status: String,
    val term: String
)