/*
 * Copyright (C) 2023 The Android Open Source Project by Lukoh Nam, goForer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */

package com.goforer.profiler.presentation.ui.screen.home.notification.content

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.goforer.profiler.data.model.datum.response.mynetwork.Person
import com.goforer.profiler.data.model.datum.response.notification.Notification
import com.goforer.profiler.presentation.stateholder.ui.notification.content.ContentContentState
import com.goforer.profiler.presentation.ui.ext.noRippleClickable
import com.goforer.profiler.presentation.ui.theme.ProfilerTheme

@Composable
fun ContentContent(
    modifier: Modifier = Modifier,
    state: ContentContentState,
    contentPadding: PaddingValues = PaddingValues(4.dp),
    userId: Int
) {
    val notification = state.onGetNotification(userId)
    val scrollState = rememberScrollState()

    notification?.let {
        Column(
            modifier = modifier
                .padding(
                    0.dp,
                    contentPadding.calculateTopPadding(),
                    0.dp,
                    16.dp
                )
                .noRippleClickable { }
                .verticalScroll(scrollState)
        ) {
            TitleItem(modifier = Modifier, it)
            Spacer(modifier = Modifier.height(4.dp))
            PictureItem(modifier = Modifier, it)
            Spacer(modifier = Modifier.height(4.dp))
            NameItem(modifier = Modifier, it)
            Spacer(modifier = Modifier.height(4.dp))
            TeamItem(modifier = Modifier, it)
            Spacer(modifier = Modifier.height(16.dp))
            ContentItem(modifier = Modifier, it)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    showSystemUi = true
)
@Composable
fun MyNetworkSectionPreview(modifier: Modifier = Modifier) {
    ProfilerTheme {
        val scrollState = rememberScrollState()

        Column(
            modifier = modifier
                .padding(
                    0.dp,
                    56.dp,
                    0.dp,
                    16.dp
                )
                .animateContentSize()
                .noRippleClickable { }
                .verticalScroll(scrollState)
        ) {
            val notification = Notification(0,"LLyyiok", "Development", "Android",
                Person(0,"LLyyiok", "남성", true,true,"https://avatars.githubusercontent.com/u/18302717?v=4", "sociable & gregarious", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective. He is proficient in managing projects with consistent and successful results.\n" +
                    "I am confident that his leadership experience and expertise in SW development will make him a good SW engineer who works with many colleagues, and should come up with creative awesome ideas.\n" +
                    "He is an expert and architect in Android application development which has resulted in excellent reviews from all collegue. Lukoh is an honest and hardworking team lead, always willing to pitch in to help the team. He is efficient in planning projects, punctual in meeting deadlines, and conscientiously adheres to company standards and guidelines. On the other he understands the technical design and development, techniques and constraints. Lukoh has a true talent for communicating and negotiating where the outcome is beneficial for all involved. He is absolutely a valuable strength to any team as team lead!", false)
                , "Coding Rules",3, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager")

            TitleItem(modifier = Modifier, notification)
            Spacer(modifier = Modifier.height(4.dp))
            PictureItem(modifier = Modifier, notification)
            Spacer(modifier = Modifier.height(4.dp))
            NameItem(modifier = Modifier, notification)
            Spacer(modifier = Modifier.height(4.dp))
            TeamItem(modifier = Modifier, notification)
            Spacer(modifier = Modifier.height(16.dp))
            ContentItem(modifier = Modifier, notification)
        }
    }
}