package com.example.congresodanp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardCongresista(
    funNombre:(String)->Unit,
    funTipo:(String)->Unit,
    funTele:(String)->Unit,
    funCorreo:(String)->Unit,
    funMonto:(String)->Unit,
    funTextButton:(String)->Unit,
    funEditando:(Boolean)->Unit,
    funBorrar:(String)->Unit,
    congresista: Congresista
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), Arrangement.Center) {
            Text(text = congresista.nombre, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = congresista.tipo, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = congresista.telefono, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = congresista.correo, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = congresista.monto, modifier = Modifier.align(Alignment.CenterHorizontally))
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        funNombre(congresista.nombre)
                        funTipo(congresista.tipo)
                        funTele(congresista.telefono)
                        funCorreo(congresista.correo)
                        funMonto(congresista.monto)
                        funTextButton("Editar Congresista")
                        funEditando(true)
                        
                    }
                ) {
                    Text(text = "Editar", color = Color.White)
                }

                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funBorrar(congresista.nombre)

                    }
                ) {
                    Text(text = "Borrar", color = Color.White)
                }

            }
        }
    }
}