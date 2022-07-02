package jp.ac.it_college.std.s21002.news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21002.news_manager.domain.model.News
import jp.ac.it_college.std.s21002.news_manager.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21002.news_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsMapper
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsWithCategoryMapper
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.select
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.selectByPrimaryKey
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.record.NewsWithCategory as RecordNewsWithCategory1
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.record.NewsWithCategory as RecordNewsWithCategory

@Repository

class NewsRepositoryImpl(
    private val newsWithCategoryMapper: NewsWithCategoryMapper
    private val newsMapper: NewsMapper
) : NewsRepository {
    override fun findAllWithCategory(): List<NewsWithCategory> {
        return newsWithCategoryMapper.select {  }.map { toModel(it) }
    }

    override fun findWithCategory(id: Long): NewsWithCategory? {
        return newsWithCategoryMapper.select {  }.map { toModel(it) }
    }

    private fun toModel(record: RecordNewsWithCategory1): NewsWithCategory {
        val news = News(
            record.id!!,
            record.title!!,
            record.categoryId!!,
            record.publishAt!!,
            record.createAt!!,
            record.userId!!,
            record.body!!
        )
    }

}