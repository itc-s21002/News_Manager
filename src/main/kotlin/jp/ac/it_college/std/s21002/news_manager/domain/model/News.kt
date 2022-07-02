package jp.ac.it_college.std.s21002.news_manager.domain.model

import java.time.LocalDateTime

data class News(
    var id: Long,
    var name: String,
    var title: String,
    var categoryId: Long,
    var publishAt: LocalDateTime,
    var createAt: LocalDateTime,
    var userId: Long,
    var body: String
)