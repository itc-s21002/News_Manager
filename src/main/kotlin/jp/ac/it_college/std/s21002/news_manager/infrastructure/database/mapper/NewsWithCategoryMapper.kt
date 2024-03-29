package jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21002.news_manager.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.category
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.id
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.name
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.body
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.createAt
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.news
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.publishAt
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.title
import jp.ac.it_college.std.s21002.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.userId
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select

@Mapper
interface NewsWithCategoryMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "NewsWithCategoryMapper", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            Result(column = "tittle", property = "tittle", jdbcType = JdbcType.VARCHAR),
            Result(column = "category_Id", property = "categoryId", jdbcType = JdbcType.BIGINT),
            Result(column = "publish_At", property = "publishAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "create_At", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "body", property = "body", jdbcType = JdbcType.VARCHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<NewsWithCategory>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("NewsWithCategory")
    fun selectOne(selectStatement: SelectStatementProvider): NewsWithCategory?
}

private val columnList = listOf(id, name, title, categoryId, publishAt, createAt, userId, body)

fun NewsWithCategoryMapper.select(completer: SelectCompleter): List<NewsWithCategory> =
    select(columnList) {
        from(news, "n")
        leftJoin(category) {
            on(news.id) equalTo category.id
        }
        completer()
    }.run(this::selectMany)

fun NewsWithCategoryMapper.selectByPrimaryKey(id_ : Long, completer: SelectCompleter):NewsWithCategory? =
    select(columnList) {
        from(news, "n")
        leftJoin(category, "c") {
            on(news.id) equalTo category.id
        }
        where {
            id isEqualTo id_
        }
        completer()
    }.run(this::selectOne)



