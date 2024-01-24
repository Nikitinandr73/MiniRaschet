package com.mihaha.miniraschet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mihaha.miniraschet.ui.theme.LDarkBG
import com.mihaha.miniraschet.ui.theme.LaytBG
import kotlin.math.PI

@Composable
fun SchetDweKnopki() {
    MaterialTheme {
        val summNaruzhPlosk = remember { mutableStateOf(0f) }
        val summVnutrPlosk = remember { mutableStateOf(0f) }
        val summGlobal = remember { mutableStateOf(0f) }
        var sum_nar_pl: Float = 0f
        var sum_vn_pl: Float = 0f
        var sum_torc_pl: Float = 0f
        var max_diam_detali: Float = 0f
        var min_diam_vnenr_otv: Float = 0f
        var global_summ: Float = 0f

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val MaxVisotaDetali = remember {
                mutableStateOf("") }
            val MaxDiametrDetali = remember {
                mutableStateOf("") }
            val KolvoNaruznihPloskostey = remember {
                mutableStateOf("") }
            val SummaNaruznihPloskostey = remember {
                mutableStateOf("") }
            val KolvoVnutrennihPloskostey = remember {
                mutableStateOf("") }
            val SummaVnutrennihPloskostey = remember {
                mutableStateOf("") }
            val MinDiametrVnutrennihPloskostey = remember {
                mutableStateOf("") }
            val SummaTorcevihihPloskostey = remember {
                mutableStateOf("") }


//TODO Поле ввода Max высота детали

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = MaxVisotaDetali.value,
                onValueChange = { MaxVisotaDetali.value = it },
                label = {
                    Text(
                        "Max высота детали", fontSize = 20.sp,
                        color = LDarkBG
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp)
            )
//TODO Поле ввода Max диаметр детали

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = MaxDiametrDetali.value,
                onValueChange = { MaxDiametrDetali.value = it },
                label = {
                    Text(
                        "Max диаметр детали", fontSize = 20.sp,
                        color = LDarkBG
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp),


                )
//TODO Поле ввода количества наружних плоскостей

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = KolvoNaruznihPloskostey.value,
                onValueChange = { KolvoNaruznihPloskostey.value = it },
                label = {
                    Text(
                        "Кол-во наружних плоскостей", fontSize = 20.sp,
                        color = LDarkBG
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp)

            )
            val knp: Int = KolvoNaruznihPloskostey.value.toIntOrNull() ?: 0


//TODO Добавляем  наружные плоскости:
            if (knp > 1) {
                (1..knp).forEach() { i ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),  //всю ширину и отступ
                        shape = RoundedCornerShape(15.dp),  //Закругленные края
                        elevation = CardDefaults.cardElevation(10.dp)  //Эффект подьема
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(LDarkBG)
                                .padding(10.dp)
                        ) {
                            val VisotaDetali = remember {
                                mutableStateOf("")
                            }
                            val DiametrDetali = remember {
                                mutableStateOf("")
                            }
                            val VisotaRezbi = remember {
                                mutableStateOf("")
                            }
                            Text(
                                text = "Редактируем $i наружнюю плоскость ",
                                fontSize = 16.sp
                            )
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = VisotaDetali.value,
                                onValueChange = { VisotaDetali.value = it },
                                label = {
                                    Text(
                                        "Высота $i плоскости", fontSize = 20.sp,
                                        color = LaytBG
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                singleLine = true,
                                textStyle = TextStyle(fontSize = 20.sp),
                            )
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = DiametrDetali.value,
                                onValueChange = { DiametrDetali.value = it },
                                label = {
                                    Text(
                                        "Диаметр $i плоскости", fontSize = 20.sp,
                                        color = LaytBG
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                singleLine = true,
                                textStyle = TextStyle(fontSize = 20.sp),
                            )
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = VisotaRezbi.value,
                                onValueChange = { VisotaRezbi.value = it },
                                label = {
                                    Text(
                                        "Высота резьбы на $i плоскости", fontSize = 16.sp,
                                        color = LaytBG
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                singleLine = true,
                                textStyle = TextStyle(fontSize = 20.sp),
                            )

                            val narpl = remember { mutableStateOf(0f) }
                            val vis = VisotaDetali.value.toFloatOrNull() ?: 0f
                            val diam = DiametrDetali.value.toFloatOrNull() ?: 0f
                            val schetResult = PI * vis * diam
                            val vis_rezbi = VisotaRezbi.value.toFloatOrNull() ?: 0f
                            val plos_rezbi = PI * vis_rezbi * diam * 0.7
                            narpl.value =
                                schetResult.toFloat() + plos_rezbi.toFloat()  // Площадь I-ой плоскости
                            val sum_nar_pl_i = summNaruzhPlosk.value + narpl.value
                            sum_nar_pl += sum_nar_pl_i
//TODO Глобальная сумма:
                            SummaNaruznihPloskostey.value = sum_nar_pl.toString()

                            Text(
                                "Площадь $i плоскости: ${narpl.value} мм.кв",
                                color = Color.White
                            )
                        }

                    }
                }
            }
//TODO Поле ввода количества внутренних плоскостей

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = KolvoVnutrennihPloskostey.value,
                onValueChange = { KolvoVnutrennihPloskostey.value = it },
                label = {
                    Text(
                        "Кол-во внутренних плоскостей", fontSize = 20.sp,
                        color = LDarkBG
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp)

            )

            val kvp: Int = KolvoVnutrennihPloskostey.value.toIntOrNull() ?: 0
            val result = remember { mutableStateOf(0f) }
            if (kvp > 0) {
                //TODO Поле ввода минимального диаметра внутренних плоскостей
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = MinDiametrVnutrennihPloskostey.value,
                    onValueChange = { MinDiametrVnutrennihPloskostey.value = it },
                    label = {
                        Text(
                            "Min диаметр внутр. плоскости", fontSize = 20.sp,
                            color = LDarkBG
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp)

                )
//TODO Добавляем внутренниее плоскости:
                // если плоскости есть добавляем окна:
                (1..kvp).forEach() { i ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),  //всю ширину и отступ
                        shape = RoundedCornerShape(15.dp),  //Закругленные края
                        elevation = CardDefaults.cardElevation(10.dp)  //Эффект подьема
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(LDarkBG)
                                .padding(10.dp)
                        ) {
                            val VisotaVnutrPlosk = remember {
                                mutableStateOf("")
                            }
                            val DiametrVnutrPlosk = remember {
                                mutableStateOf("")
                            }
                            val VisotaRezbiVnutrPlosk = remember {
                                mutableStateOf("")
                            }
                            Text(
                                text = "Редактируем $i внутреннюю плоскость ",
                                fontSize = 16.sp
                            )
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = VisotaVnutrPlosk.value,
                                onValueChange = { VisotaVnutrPlosk.value = it },
                                label = {
                                    Text(
                                        "Высота $i плоскости", fontSize = 20.sp,
                                        color = LaytBG
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                singleLine = true,
                                textStyle = TextStyle(fontSize = 20.sp),
                            )
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = DiametrVnutrPlosk.value,
                                onValueChange = { DiametrVnutrPlosk.value = it },
                                label = {
                                    Text(
                                        "Диаметр $i  вн. плоскости", fontSize = 20.sp,
                                        color = LaytBG
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                singleLine = true,
                                textStyle = TextStyle(fontSize = 20.sp),
                            )
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = VisotaRezbiVnutrPlosk.value,
                                onValueChange = { VisotaRezbiVnutrPlosk.value = it },
                                label = {
                                    Text(
                                        "Высота резьбы на $i плоскости", fontSize = 16.sp,
                                        color = LaytBG
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                singleLine = true,
                                textStyle = TextStyle(fontSize = 20.sp),
                            )

                            val vnpl = remember { mutableStateOf(0f) }
                            val vis_vp = VisotaVnutrPlosk.value.toFloatOrNull() ?: 0f
                            val diam_vp = DiametrVnutrPlosk.value.toFloatOrNull() ?: 0f
                            val schetResult = PI * vis_vp * diam_vp
                            val vis_rezbi_vp = VisotaRezbiVnutrPlosk.value.toFloatOrNull() ?: 0f
                            val plos_rezbi = PI * vis_rezbi_vp * diam_vp * 0.7
                            vnpl.value =
                                schetResult.toFloat() + plos_rezbi.toFloat()  // Площадь I-ой плоскости
                            val sum_vn_pl_i = summVnutrPlosk.value + vnpl.value
                            sum_vn_pl += sum_vn_pl_i
//TODO Глобальная сумма внутренних плоскостей:
                            SummaVnutrennihPloskostey.value = sum_vn_pl.toString()

                            Text(
                                "Площадь $i внутренней плоскости: ${vnpl.value} мм.кв",
                                color = Color.White
                            )
                        }

                    }

                }
//TODO Отображение глобальной суммы наружних плоскостей:

                Text(
                    "Cумма наружних плоскостей = ${
                        SummaNaruznihPloskostey.value
                    } мм.кв",  // Отображение суммы нар.плоск.
                    color = Color.White
                )
//TODO Отображение глобальной суммы внутренних плоскостей:

                Text(
                    "Cумма внутренних плоскостей = ${
                        SummaVnutrennihPloskostey.value
                    } мм.кв",  // Отображение суммы нар.плоск.
                    color = Color.White
                )
//TODO Отображение глобальной суммы торцов:
                max_diam_detali = MaxDiametrDetali.value.toFloatOrNull()?: 0f
                min_diam_vnenr_otv = MinDiametrVnutrennihPloskostey.value.toFloatOrNull()?: 0f
                sum_torc_pl = (((max_diam_detali * max_diam_detali)/4 * PI -
                        (min_diam_vnenr_otv * min_diam_vnenr_otv)/4 * PI)*2).toFloat()
                SummaTorcevihihPloskostey.value = sum_torc_pl.toString()
                Text(
                    "Cумма торцевых плоскостей = ${
                        SummaTorcevihihPloskostey.value
                    } мм.кв",  // Отображение суммы торцевых плоскостей.
                    color = Color.White
                )
//TODO Кнопка посчитать общую площадь с выводом:

                Button(onClick = {
                    global_summ = sum_nar_pl + sum_vn_pl + sum_torc_pl
                    summGlobal.value = global_summ

                })
                {
                    Text("Посчитать общую площадь")
                }
                // Результат
                Text(
                    "Площадь: ${summGlobal.value} мм.кв",
                    color = Color.White
                )
                Text(
                    "Площадь: ${summGlobal.value/ 10000} дм.кв",
                    color = Color.White
                )
            }
        }
    }
}

