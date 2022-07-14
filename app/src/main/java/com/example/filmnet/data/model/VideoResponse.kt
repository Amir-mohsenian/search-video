package com.example.filmnet.data.model

import com.google.gson.annotations.SerializedName

class VideoResponse(
    @SerializedName("status") val status: String,
    @SerializedName("title") val title: String,
    @SerializedName("page_title") val pageTitle: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("summary") val summary: String,
    @SerializedName("rate") val rate: Float,
    @SerializedName("cover_image") val coverImage: CoverImage,
    @SerializedName("poster_image") val posterImage: PosterImage,
    @SerializedName("alter_cover_image") val alterCoverImage: AlterCoverImage,
    @SerializedName("type") val type: String,
    @SerializedName("flag") val flag: String,
    @SerializedName("conditional_flag") val conditionalFlag: String,
    @SerializedName("age_restriction") val ageRestriction: String,
    @SerializedName("year") val year: Int,
    @SerializedName("imdb_rank_percent") val imdbRankByPercent: String,
    @SerializedName("original_name") val originalName: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("categories") val categories: List<CategoryResponse>,
    @SerializedName("id") val id: String,
    @SerializedName("short_id") val shortId: String
) {

    inner class CoverImage(@SerializedName("path") val path: String)
    inner class PosterImage(@SerializedName("path") val path: String)
    inner class AlterCoverImage(@SerializedName("path") val path: String)
}