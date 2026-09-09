package com.techlads.nabz.core.designsystem.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object NabzIcons {
    val Home: ImageVector by lazy {
        image(name = "Home") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 3.2f)
                lineTo(3.4f, 10.6f)
                curveTo(3.15f, 10.82f, 3f, 11.14f, 3f, 11.48f)
                verticalLineTo(19.2f)
                curveTo(3f, 19.86f, 3.54f, 20.4f, 4.2f, 20.4f)
                horizontalLineTo(9.2f)
                verticalLineTo(14.7f)
                horizontalLineTo(14.8f)
                verticalLineTo(20.4f)
                horizontalLineTo(19.8f)
                curveTo(20.46f, 20.4f, 21f, 19.86f, 21f, 19.2f)
                verticalLineTo(11.48f)
                curveTo(21f, 11.14f, 20.85f, 10.82f, 20.6f, 10.6f)
                close()
            }
        }
    }

    val Search: ImageVector by lazy {
        image(name = "Search") {
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
            ) {
                moveTo(6.2f, 11f)
                arcToRelative(4.8f, 4.8f, 0f, true, true, 9.6f, 0f)
                arcToRelative(4.8f, 4.8f, 0f, true, true, -9.6f, 0f)
                moveTo(14.8f, 14.8f)
                lineTo(18.6f, 18.6f)
            }
        }
    }

    val Drop: ImageVector by lazy {
        image(name = "Drop") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 2.6f)
                curveTo(14.8f, 6.4f, 18.4f, 9.6f, 18.4f, 13.2f)
                curveTo(18.4f, 16.8f, 15.6f, 19.6f, 12f, 19.6f)
                curveTo(8.4f, 19.6f, 5.6f, 16.8f, 5.6f, 13.2f)
                curveTo(5.6f, 9.6f, 9.2f, 6.4f, 12f, 2.6f)
                close()
            }
        }
    }

    val Pin: ImageVector by lazy {
        image(name = "Pin") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 2.8f)
                curveTo(9.1f, 2.8f, 6.8f, 5.1f, 6.8f, 8f)
                curveTo(6.8f, 12.2f, 12f, 21.2f, 12f, 21.2f)
                reflectiveCurveToRelative(5.2f, -9f, 5.2f, -13.2f)
                curveTo(17.2f, 5.1f, 14.9f, 2.8f, 12f, 2.8f)
                close()
                moveTo(12f, 10.4f)
                arcToRelative(2.2f, 2.2f, 0f, true, true, 0f, -4.4f)
                arcToRelative(2.2f, 2.2f, 0f, true, true, 0f, 4.4f)
                close()
            }
        }
    }

    val Person: ImageVector by lazy {
        image(name = "Person") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 12f)
                curveTo(14.2f, 12f, 16f, 10.2f, 16f, 8f)
                curveTo(16f, 5.8f, 14.2f, 4f, 12f, 4f)
                curveTo(9.8f, 4f, 8f, 5.8f, 8f, 8f)
                curveTo(8f, 10.2f, 9.8f, 12f, 12f, 12f)
                close()
                moveTo(12f, 13.6f)
                curveTo(8.7f, 13.6f, 5.2f, 15.3f, 5.2f, 18.2f)
                verticalLineTo(20f)
                horizontalLineTo(18.8f)
                verticalLineTo(18.2f)
                curveTo(18.8f, 15.3f, 15.3f, 13.6f, 12f, 13.6f)
                close()
            }
        }
    }

    val Bell: ImageVector by lazy {
        image(name = "Bell") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 21.2f)
                curveTo(13.1f, 21.2f, 14f, 20.3f, 14f, 19.2f)
                horizontalLineTo(10f)
                curveTo(10f, 20.3f, 10.9f, 21.2f, 12f, 21.2f)
                close()
                moveTo(18.4f, 16.4f)
                verticalLineTo(11.2f)
                curveTo(18.4f, 8.3f, 16.8f, 5.9f, 14.2f, 5.2f)
                verticalLineTo(4.6f)
                curveTo(14.2f, 3.4f, 13.3f, 2.5f, 12.1f, 2.5f)
                curveTo(10.9f, 2.5f, 10f, 3.4f, 10f, 4.6f)
                verticalLineTo(5.2f)
                curveTo(7.4f, 5.9f, 5.8f, 8.3f, 5.8f, 11.2f)
                verticalLineTo(16.4f)
                lineTo(4f, 18.2f)
                verticalLineTo(19.1f)
                horizontalLineTo(20.2f)
                verticalLineTo(18.2f)
                close()
            }
        }
    }

    val ChevronLeft: ImageVector by lazy {
        image(name = "ChevronLeft") {
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(14.5f, 5.5f)
                lineTo(8.5f, 12f)
                lineTo(14.5f, 18.5f)
            }
        }
    }

    val Phone: ImageVector by lazy {
        image(name = "Phone") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(7.2f, 3.6f)
                horizontalLineTo(9.4f)
                lineTo(10.4f, 8.1f)
                lineTo(8.6f, 9.2f)
                curveTo(9.4f, 10.8f, 10.7f, 12.2f, 12.4f, 13.2f)
                lineTo(13.5f, 11.4f)
                lineTo(18f, 12.4f)
                verticalLineTo(14.6f)
                curveTo(18f, 15.3f, 17.4f, 15.9f, 16.7f, 15.9f)
                curveTo(10.6f, 15.9f, 5.6f, 10.9f, 5.6f, 4.8f)
                curveTo(5.6f, 4.1f, 6.2f, 3.6f, 7.2f, 3.6f)
                close()
            }
        }
    }

    val Check: ImageVector by lazy {
        image(name = "Check") {
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(5f, 12.5f)
                lineTo(10f, 17.2f)
                lineTo(19f, 7f)
            }
        }
    }

    val Plus: ImageVector by lazy {
        image(name = "Plus") {
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
            ) {
                moveTo(12f, 5f)
                lineTo(12f, 19f)
                moveTo(5f, 12f)
                lineTo(19f, 12f)
            }
        }
    }

    val Heart: ImageVector by lazy {
        image(name = "Heart") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 20.4f)
                lineTo(10.6f, 19.1f)
                curveTo(5.4f, 14.4f, 2f, 11.3f, 2f, 7.6f)
                curveTo(2f, 4.5f, 4.4f, 2.2f, 7.4f, 2.2f)
                curveTo(9.1f, 2.2f, 10.7f, 3f, 12f, 4.2f)
                curveTo(13.3f, 3f, 14.9f, 2.2f, 16.6f, 2.2f)
                curveTo(19.6f, 2.2f, 22f, 4.5f, 22f, 7.6f)
                curveTo(22f, 11.3f, 18.6f, 14.4f, 13.4f, 19.1f)
                close()
            }
        }
    }

    val Hospital: ImageVector by lazy {
        image(name = "Hospital") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(4.4f, 21f)
                verticalLineTo(8.4f)
                horizontalLineTo(9.2f)
                verticalLineTo(3.6f)
                horizontalLineTo(14.8f)
                verticalLineTo(8.4f)
                horizontalLineTo(19.6f)
                verticalLineTo(21f)
                close()
                moveTo(11.1f, 18.2f)
                horizontalLineTo(12.9f)
                verticalLineTo(15.2f)
                horizontalLineTo(15.9f)
                verticalLineTo(13.4f)
                horizontalLineTo(12.9f)
                verticalLineTo(10.4f)
                horizontalLineTo(11.1f)
                verticalLineTo(13.4f)
                horizontalLineTo(8.1f)
                verticalLineTo(15.2f)
                horizontalLineTo(11.1f)
                close()
            }
        }
    }

    val Calendar: ImageVector by lazy {
        image(name = "Calendar") {
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.6f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(5f, 6.5f)
                horizontalLineTo(19f)
                curveTo(19.8f, 6.5f, 20.4f, 7.1f, 20.4f, 7.9f)
                verticalLineTo(19f)
                curveTo(20.4f, 19.8f, 19.8f, 20.4f, 19f, 20.4f)
                horizontalLineTo(5f)
                curveTo(4.2f, 20.4f, 3.6f, 19.8f, 3.6f, 19f)
                verticalLineTo(7.9f)
                curveTo(3.6f, 7.1f, 4.2f, 6.5f, 5f, 6.5f)
                close()
                moveTo(8f, 3.6f)
                verticalLineTo(6.5f)
                moveTo(16f, 3.6f)
                verticalLineTo(6.5f)
                moveTo(3.6f, 10.4f)
                horizontalLineTo(20.4f)
            }
        }
    }

    val Shield: ImageVector by lazy {
        image(name = "Shield") {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 2.5f)
                lineTo(4.4f, 5.8f)
                verticalLineTo(11.2f)
                curveTo(4.4f, 16f, 7.6f, 20.4f, 12f, 21.5f)
                curveTo(16.4f, 20.4f, 19.6f, 16f, 19.6f, 11.2f)
                verticalLineTo(5.8f)
                close()
            }
        }
    }

    val ArrowRight: ImageVector by lazy {
        image(name = "ArrowRight") {
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(5f, 12f)
                lineTo(19f, 12f)
                moveTo(13.5f, 6.5f)
                lineTo(19f, 12f)
                lineTo(13.5f, 17.5f)
            }
        }
    }
}

private fun image(
    name: String,
    block: androidx.compose.ui.graphics.vector.ImageVector.Builder.() -> Unit,
): ImageVector {
    return ImageVector.Builder(
        name = name,
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply(block).build()
}
