package com.truecaller.assignment.charsnwords.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResponsiveAccordionContainer(
    isSmallDevice: Boolean,
    everyNthChar: List<Char>?,
    wordCount: Map<String, Int>?
) {
    if (isSmallDevice) {
        Column {
            EveryNthCharacterContainer(
                everyNthChar,
                Modifier.fillMaxWidth(),
                Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            WordCountContainer(
                wordCount,
                Modifier.fillMaxWidth(),
                Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            )
        }
    } else {
        Row {
            EveryNthCharacterContainer(
                everyNthChar,
                Modifier.weight(0.5f),
                Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            WordCountContainer(
                wordCount,
                Modifier.weight(0.5f),
                Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            )
        }
    }
}

@Composable
fun EveryNthCharacterContainer(
    everyNthChar: List<Char>?,
    modifier: Modifier,
    modifierExpanded: Modifier
) {
    var everyNthExpanded by remember { mutableStateOf(true) }
    if (everyNthChar != null) {
        Accordion(
            title = "Every 15th Character",
            expanded = everyNthExpanded,
            onToggle = {
                everyNthExpanded = !everyNthExpanded
            },
            modifier = if (everyNthExpanded) modifierExpanded else modifier
        ) {
            Text(
                everyNthChar.joinToString(),
                fontSize = 16.sp,
                modifier = Modifier.verticalScroll(rememberScrollState())
            )
        }
    }
}

@Composable
fun WordCountContainer(
    wordCount: Map<String, Int>?,
    modifier: Modifier,
    modifierExpanded: Modifier
) {
    var wordCountExpanded by remember { mutableStateOf(true) }
    if (wordCount != null) {
        Accordion(
            title = "Word Count",
            expanded = wordCountExpanded,
            onToggle = { wordCountExpanded = !wordCountExpanded },
            modifier = if (wordCountExpanded) modifierExpanded else modifier
        ) {
            LazyColumn {
                items(
                    wordCount.toList()
                ) { (word, count) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(word, fontSize = 16.sp)
                        Text(
                            count.toString(),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
