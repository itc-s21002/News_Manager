package jp.ac.it_college.std.s21002.news_manager.domain.model

import java.time.LocalDateTime
import java.util.*

data class NewsWithCategory(
    val news: News,
    val category: Category?
) {
    val isCategory: Boolean
        get() = category !=null
}