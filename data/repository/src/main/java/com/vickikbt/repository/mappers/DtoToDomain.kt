package com.vickikbt.data.mappers

import com.vickikbt.data.dto.*
import com.vickikbt.domain.models.*

internal fun GamesResponseDto.toDomain(): GamesResponse {
    return GamesResponse(
        count = this.count,
        games_count = this.games_count,
        next = this.next,
        previous = this.previous,
        recommendations_count = this.recommendations_count,
        results = this.results.map { it.toDomain() },
        reviews_count = this.reviews_count
    )

}

internal fun GenreDto.toDomain(): Genre {
    return Genre(
        games_count = this.games_count,
        id = this.id,
        image_background = this.image_background,
        name = this.name,
        slug = this.slug
    )

}

internal fun PlatformDto.toDomain(): Platform {
    return Platform(
        games_count = this.games_count,
        id = this.id,
        image = this.image,
        image_background = this.image_background,
        name = this.name,
        slug = this.slug,
        year_end = this.year_end,
        year_start = this.year_start
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
        background_image = this.background_image,
        clip = this.clip,
        community_rating = this.community_rating,
        dominant_color = this.dominant_color,
        genres = this.genres.map { it.toDomain() },
        id = this.id,
        name = this.name,
        platforms = this.platforms.map { it.toDomain() },
        playtime = this.playtime,
        rating = this.rating,
        rating_top = this.rating_top,
        ratings = this.ratings.map { it.toDomain() },
        ratings_count = this.ratings_count,
        released = this.released,
        reviews_count = this.reviews_count,
        reviews_text_count = this.reviews_text_count,
        saturated_color = this.saturated_color,
        short_screenshots = this.short_screenshots.map { it.toDomain() },
        slug = this.slug,
        suggestions_count = this.suggestions_count,
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
        games_count = this.games_count,
        id = this.id,
        image_background = this.image_background,
        language = this.language,
        name = this.name,
        slug = this.slug
    )
}