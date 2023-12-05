package com.example.expensepartner.data.model

data class History(
    val change_status: ChangeStatus,
    val committed_at: String,
    val url: String,
    val user: User,
    val version: String
)