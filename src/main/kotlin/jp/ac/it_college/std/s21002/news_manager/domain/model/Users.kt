package jp.ac.it_college.std.s21002.news_manager.domain.model

data class Users(
    var id: Long,
    var username: String,
    var password: String,
    var viewName: String,
    var roletype: String
)