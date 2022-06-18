package me.ingannatore.pocs.commons.errors

class ErrorData(
    val code: String,
    val status: String,
    val title: String,
    val detail: String,
    val source: ErrorSource? = null,
)