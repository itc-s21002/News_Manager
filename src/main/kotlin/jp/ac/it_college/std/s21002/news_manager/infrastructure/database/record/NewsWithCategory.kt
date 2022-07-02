package jp.ac.it_college.std.s21002.news_manager.infrastructure.database.record

import java.time.LocalDateTime
import java.util.*

data class NewsWithCategory(
    var id: Long? = null,
    var name: String? = null,
    var title: String? = null,
    var categoryId: Long? = null,
    var publishAt: LocalDateTime? = null,
    var createAt: LocalDateTime? = null,
    var userId: Long? = null,
    var body: String? = null
)
