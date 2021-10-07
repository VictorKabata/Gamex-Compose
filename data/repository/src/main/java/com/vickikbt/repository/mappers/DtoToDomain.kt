package com.vickikbt.repository.mappers

import com.vickikbt.domain.models.*
import com.vickikbt.network.models.*

internal fun GamesResponseDto.toDomain(): GamesResponse {
    return GamesResponse(
        count = this.count,
        games_count = this.games_count,
        next = this.next,
        previous = this.previous,
        recommendations_count = this.recommendations_count,
        results = this.games.map { it.toDomain() },
        reviews_count = this.reviews_count
    )

}

internal fun GenreDto.toDomain(): Genre {
    return Genre(
        games_count = this.gamesCount,
        id = this.id,
        image_background = this.imageBackground,
        name = this.name,
        slug = this.slug
    )

}

internal fun PlatformDto.toDomain(): Platform {
    return Platform(
        games_count = this.gamesCount,
        id = this.id,
        image = this.image,
        image_background = this.imageBackground,
        name = this.name,
        slug = this.slug,
        year_end = this.yearEnd,
        year_start = this.yearStart
    )
}

internal fun PlatformsDto.toDomain(): Platforms {
    return Platforms(
        platform = this.platform.toDomain()
    )

}

internal fun RatingDto.toDomain(): Rating {
    return Rating(
        count = this.count,
        id = this.id,
        percent = this.percent,
        title = this.title
    )
}

internal fun GameDto.toDomain(): Game {
    return Game(
        added = this.added,
        background_image = this.backgroundImage,
        clip = this.clip,
        community_rating = this.communityRating,
        dominant_color = this.dominantColor,
        genres = this.genres.map { it.toDomain() },
        id = this.id,
        name = this.name,
        platforms = this.platforms.map { it.toDomain() },
        playtime = this.playtime,
        rating = this.rating,
        rating_top = this.ratingTop,
        ratings = this.ratings.map { it.toDomain() },
        ratings_count = this.ratingsCount,
        released = this.released,
        reviews_count = this.reviewsCount,
        reviews_text_count = this.reviewsTextCount,
        saturated_color = this.saturatedColor,
        short_screenshots = this.shortScreenshots.map { it.toDomain() },
        slug = this.slug,
        suggestions_count = this.suggestionsCount,
        tags = this.tags.map { it.toDomain() },
        tba = this.tba,
        updated = this.updated
    )
}

internal fun ShortScreenshotDto.toDomain(): ShortScreenshot {
    return ShortScreenshot(
        id = this.id,
        image = this.image
    )
}

internal fun TagDto.toDomain(): Tag {
    return Tag(
        games_count = this.gamesCount,
        id = this.id,
        image_background = this.imageBackground,
        language = this.language,
        name = this.name,
        slug = this.slug
    )
}