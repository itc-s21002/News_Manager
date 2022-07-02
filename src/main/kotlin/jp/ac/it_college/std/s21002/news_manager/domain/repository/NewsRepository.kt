package jp.ac.it_college.std.s21002.news_manager.domain.repository

import jp.ac.it_college.std.s21002.news_manager.domain.model.NewsWithCategory

interface NewsRepository {
    fun findAllWithCategory(): List<NewsWithCategory>

    fun findWithCategory(id: Long): NewsWithCategory?
}
