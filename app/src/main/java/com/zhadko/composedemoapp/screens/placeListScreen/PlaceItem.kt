package com.zhadko.composedemoapp.screens.placeListScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import com.google.accompanist.flowlayout.FlowRow
import com.zhadko.composedemoapp.R
import com.zhadko.composedemoapp.models.Category
import com.zhadko.composedemoapp.models.Image
import com.zhadko.composedemoapp.models.Place
import com.zhadko.composedemoapp.models.Tag
import com.zhadko.composedemoapp.ui.MyTypography

@Composable
fun PlaceItem(place: Place) {
    Column(
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.size_10))
    ) {
        Box(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.size_170))
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(id = R.dimen.size_24),
                    bottom = dimensionResource(id = R.dimen.size_10)
                )
        ) {
            AsyncImage(
                model = place.cover_photo.media_url,
                contentDescription = "Photo cover",
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.size_10))),
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.no_image_placeholder),
            )

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.size_10)))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.grey_transparent),
                                colorResource(id = R.color.black_secondary)
                            )
                        )
                    )
                    .fillMaxSize()
            )

            val checkedState = remember { mutableStateOf(place.favorited) }
            IconButton(
                onClick = {
                    checkedState.value = !checkedState.value
                },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(dimensionResource(id = R.dimen.size_36)),
            ) {
                Image(
                    painter = painterResource(
                        id = if (checkedState.value) {
                            R.drawable.favorite_checked
                        } else {
                            R.drawable.favorite_unchecked
                        }
                    ),
                    modifier = Modifier
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.size_18)))
                        .background(
                            if (checkedState.value) {
                                colorResource(R.color.green)
                            } else {
                                colorResource(R.color.white)
                            }
                        ),
                    contentDescription = "Favorite image",
                )
            }

            Text(
                text = place.area_served, modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        bottom = dimensionResource(id = R.dimen.size_8),
                        start = dimensionResource(id = R.dimen.size_8)
                    )
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.size_16)))
                    .background(colorResource(R.color.white))
                    .padding(
                        start = dimensionResource(id = R.dimen.size_8),
                        top = dimensionResource(id = R.dimen.size_2),
                        end = dimensionResource(id = R.dimen.size_8),
                        bottom = dimensionResource(id = R.dimen.size_2)
                    ), style = MyTypography.bodyMedium
            )
        }

        Text(
            text = place.company_name,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.size_6)),
            style = MyTypography.headlineMedium,
            color = colorResource(R.color.grey_primary)
        )

        FlowRow {
            place.categories.forEach { category ->
                CategoryItem(category = category)
            }
        }

        FlowRow(
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.size_6))
        ) {
            place.tags.forEach { tag ->
                TagItem(tags = tag)
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Row(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.size_8))) {
        AsyncImage(
            model = category.image.media_url,
            imageLoader = ImageLoader.Builder(LocalContext.current).components {
                add(SvgDecoder.Factory())
            }.build(),
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.size_22)),
        )
        Text(
            text = category.name,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(
                    start = dimensionResource(id = R.dimen.size_6),
                    end = dimensionResource(id = R.dimen.size_14)
                ),
            style = MyTypography.bodyMedium,
            color = colorResource(R.color.grey_primary),
        )
    }
}

@Composable
fun TagItem(tags: Tag) {
    Row {
        Text(
            text = "• ${tags.name} ",
            color = colorResource(R.color.grey_secondary),
            style = MyTypography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaceItem(
        place = Place(
            1,
            company_name = "Company Name",
            area_served = "Zaporizhzhya",
            shop_type = "mall",
            favorited = true,
            follow = true,
            business_type = "products",
            categories = listOf(Category(1, "Category", Image(1, ""))),
            tags = listOf(Tag(1, "Tag")),
            cover_photo = Image(1, "qwe")
        )
    )
}